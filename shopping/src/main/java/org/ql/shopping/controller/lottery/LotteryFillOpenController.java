package org.ql.shopping.controller.lottery;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.FillUserDetails;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.LotteryStageUtils;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.MakeManifestNo;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.SessionUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lottery/fill")
public class LotteryFillOpenController {
	private Logger logger = LoggerFactory
			.getLogger(LotteryFillOpenController.class);

	@Resource
	private ILotteryFillOpenService mLotteryFillOpenService;
	@Resource
	private IUserServiceManagerService mUserServiceManagerService;
	@Resource
	private ILotteryFillUserService mLotteryFillUserService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/fill/" + url);
	}

	@RequestMapping("/view/list")
	public String showListView(Model model, LotteryFillOpenSearch params) {
		model.addAttribute("fillOpenList", url("/operate/list?lotteryTypeId="
				+ params.getLotteryTypeId()));
		model.addAttribute("seeUserList", url("/view/userList"));
		return "page/lottery/fill/lottery_open.jsp";
	}

	@RequestMapping("/view/userList")
	public String showUserListView(FillUserDetails params, Model model) {
		model.addAttribute("fillOpenId", params.getLotteryFillOpenId());
		model.addAttribute("fillUserList",
				HttpUrl.replaceUrl("/user/fill/operate/list"));
		return "page/lottery/fill/fill_user_list.jsp";
	}

	@RequestMapping("/view/add")
	public String showAddView(Model model) {
		model.addAttribute("addFillUrl", url("operate/add"));
		model.addAttribute("treeAllUrl",
				HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		return "page/lottery/fill/lottery_fill_add.jsp";
	}

	@RequestMapping(value = "/operate/add", method = RequestMethod.POST)
	@ResponseBody
	public Result addFillOpen(HttpServletRequest request, LotteryFillOpen params) {
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		params.setCreateUserId(userId);
		try {
			checkAddFillOpenParams(params);

			// 需要创建时间
			params.setLotteryFillCreaterDate(new Date());
			params.setSendStatus(C.LotteryType.SEND_STATUS_UNFINSH);

			mLotteryFillOpenService.addFillOpen(params);
			String stage = LotteryStageUtils.createStage(
					C.LotteryStageFlag.FILL, params.getLotteryFillOpenId());
			params.setLotteryStage(stage);
			mLotteryFillOpenService.updateFillOpenById(params);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("addFillOpen", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 添加 彩票类型 的检测 创建的参数 是否正确
	 * 
	 * @param params
	 */
	private void checkAddFillOpenParams(LotteryFillOpen params) {
		BigDecimal awardLBi = params.getAwardLBi();
		Integer createUserId = params.getCreateUserId();
		BigDecimal fillLBi = params.getFillLBi();
		BigDecimal lotteryFillUnitPrice = params.getLotteryFillUnitPrice();
		Integer lotteryTypeId = params.getLotteryTypeId();
		String name = params.getLotteryFillName();
		if (StringUtils.isEmpty(name)) {
			throw new ParamsErrorException("参数不正确");
		}

		if (NumberUtils.isZero(awardLBi)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(createUserId)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(fillLBi)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(lotteryFillUnitPrice)) {
			throw new ParamsErrorException("参数数值不正确");
		}
		if (NumberUtils.isZero(lotteryTypeId)) {
			throw new ParamsErrorException("参数数值不正确");
		}

		UserManager createUser = mUserServiceManagerService
				.findUserById(createUserId);
		if (createUser == null) {
			throw new ParamsErrorException("参数不正确");
		}
	}

	@RequestMapping("/operate/list")
	@ResponseBody
	public TabelResult getList(LotteryFillOpenSearch params) {
		TabelResult result = new TabelResult();
		try {
			List<LotteryFillOpenSearch> list = mLotteryFillOpenService
					.selectSearchByParams(params);
			int count = mLotteryFillOpenService.getSearchCountParams(params);
			result.setCount(new Long(count));
			result.setData(list);
			result.setCode(0);
		} catch (Exception e) {
			logger.error("getList", e);
			ResultHintUtils.setSystemError(result, e);
		}

		return result;
	}

	/**
	 * 用于开奖
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/operate/open")
	@ResponseBody
	public Result openLottery(HttpServletRequest request,LotteryFillOpenSearch params) {
		Result result = new Result();
		try {
			// 需要检测 是否有开奖的的lotteryOpenId
			Integer fOpenId = params.getLotteryFillOpenId();
			if(NumberUtils.isZero(fOpenId)){
				throw new LotteryException("参数不正确");
			}
			// 检测用户是否拥有权限
			HttpSession session = request.getSession();
			Integer id = SessionUtils.getId(session);
			UserManager findUserById = mUserServiceManagerService.findUserById(id);
			if(findUserById == null){
				throw new LotteryException("请登录");
			}
			
			if(!C.UserManagerPower.POWER_ALL.equals(findUserById.getPower())){
				throw new LotteryException("权限不足");
			}
			
			// 检测购买数量是否足够
			params.setCanSendAward(LotteryFillOpenSearch.TPYE_CAN_SEND);
			List<LotteryFillOpen> list = mLotteryFillOpenService.selectByParams(params);
			if(list == null || list.size() != 1){
				throw new LotteryException("参数不正确");
			}
			LotteryFillOpen openF = list.get(0);
			
			//查询所有购买过的该彩票的用户，
			List<FillUserDetails> buyUserList = mLotteryFillUserService.selectUserDetailsByOpenId(openF.getLotteryFillOpenId());
			//用于存放 购买用户的编号
			Map<Integer,FillUserDetails> map = new HashMap<Integer, FillUserDetails>();
			int count = 0;
			for (int i = 0; i < buyUserList.size(); i++) {
				FillUserDetails itemUser = buyUserList.get(i);
				for (int j = 0; j < itemUser.getLotteryFillBuyQty(); j++) {
					count ++;
					map.put(j, itemUser);
				}
			}
			//生成随机数，获得中奖用户
			Random random = new Random();
			int awardIndex = random.nextInt(count+1);
			
			FillUserDetails fillUserDetails = map.get(awardIndex);
			
			//更新开奖表，中奖用户ID，中奖号码，
			LotteryFillOpenSearch updateFillOpen = new LotteryFillOpenSearch();
			updateFillOpen.setAwardUserId(fillUserDetails.getLotteryFillUserId());
			updateFillOpen.setOpenNumber(String.valueOf(awardIndex));
			updateFillOpen.setLotteryFillOpenId(fillUserDetails.getLotteryFillOpenId());
			updateFillOpen.setStatus(C.LotteryOpen.STATUS_OPEN);
			mLotteryFillOpenService.updateFillOpenById(params);
			
			//更新中奖用户 中的中奖号码			
			LotteryFillUser updateFillUser = new LotteryFillUser();
			updateFillUser.setLotteryFillUserId(fillUserDetails.getLotteryFillUserId());
			updateFillUser.setNumber(String.valueOf(awardIndex));
			mLotteryFillUserService.updateFillLotteryByKey(updateFillUser);
			
			result.setCode(Code.SUCCESS);
			result.setData(fillUserDetails);

		} catch (Exception e) {
			logger.error("openLottery", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

}
