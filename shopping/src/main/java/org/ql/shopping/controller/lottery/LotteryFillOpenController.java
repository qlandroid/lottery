package org.ql.shopping.controller.lottery;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.security.auth.kerberos.ServicePermission;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.exception.PowerException;
import org.ql.shopping.pojo.lottery.FillUserDetails;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillOpenSearch;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.ql.shopping.pojo.lottery.LotteryFillUserSearch;
import org.ql.shopping.pojo.manifest.IncomeManifest;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.result.Rows;
import org.ql.shopping.pojo.result.TabelResult;
import org.ql.shopping.pojo.user.UserClientSSearch;
import org.ql.shopping.pojo.user.UserManager;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.service.manifest.IManifestIncomeManagerService;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.service.user.IUserServiceManagerService;
import org.ql.shopping.util.HttpUrl;
import org.ql.shopping.util.LotteryStageUtils;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.MakeManifestNo;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.SessionUtils;
import org.ql.shopping.util.ServiceUserPowerUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.fill.FillUserPaySearch;

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
	@Resource
	private IUserClientManagerService mUserClientManagerService;
	@Resource
	private IManifestIncomeManagerService mManifestIncomeManagerService;

	private String url(String url) {
		return HttpUrl.replaceUrl("/lottery/fill" + url);
	}

	/**
	 * 显示彩票类型 下的所有彩票
	 * 
	 * @param model
	 * @param params
	 * @return
	 */
	@RequestMapping("/view/list")
	public String showListView(Model model, LotteryFillOpenSearch params) {
		model.addAttribute("fillOpenList", url("/operate/list?lotteryTypeId="
				+ params.getLotteryTypeId()));
		model.addAttribute("typeId", params.getLotteryTypeId());
		model.addAttribute("openAwardUrl", url("/view/open"));
		model.addAttribute("seeUserList", url("/view/userList"));
		model.addAttribute("seeAwardUserUrl", url("/view/seeAwardUser"));// 用于查看中奖用户
		model.addAttribute("addLotteryUrl", url("/view/addLottery"));
		return "page/lottery/fill/lottery_open.jsp";
	}

	@RequestMapping("/view/addLottery")
	public String showAddLotteryView(Model model, LotteryFillOpenSearch params) {
		model.addAttribute("createUrl", url("/operate/createFillOpen"));
		model.addAttribute("modelUrl", url("/operate/getModel"));
		model.addAttribute("typeId", params.getLotteryTypeId());
		return "page/lottery/fill/create_fill_open.jsp";
	}

	/**
	 * 显示购买彩票的用户
	 * 
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/userList")
	public String showUserListView(FillUserDetails params, Model model) {
		model.addAttribute("fillOpenId", params.getLotteryFillOpenId());
		model.addAttribute("fillUserList",
				HttpUrl.replaceUrl("/user/fill/operate/list"));
		return "page/lottery/fill/fill_user_list.jsp";
	}

	/**
	 * 查看中奖用户
	 * 
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/seeAwardUser")
	public String showSeeAwardUserView(FillUserDetails params, Model model) {
		// 中奖用户
		FillUserDetails awardUser = mLotteryFillUserService
				.selectAwardUserByOpenId(params.getLotteryFillOpenId());
		model.addAttribute("awardUser", awardUser);

		// 彩票信息
		LotteryFillOpen fillOpen = mLotteryFillOpenService.selectById(params
				.getLotteryFillOpenId());
		model.addAttribute("fillOpen", fillOpen);
		model.addAttribute("sendLBi", url("/operate/sendLBi"));

		return "page/lottery/fill/see_award_user.jsp";
	}

	/**
	 * 添加彩票
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/add")
	public String showAddView(Model model) {
		model.addAttribute("addFillUrl", url("/operate/add"));
		model.addAttribute("treeAllUrl",
				HttpUrl.replaceUrl("/lottery/clazz/operate/all"));
		return "page/lottery/fill/lottery_fill_add.jsp";
	}

	/**
	 * 开奖页面
	 * 
	 * @param params
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/open")
	public String showOpenView(FillUserDetails params, Model model) {
		Integer openId = params.getLotteryFillOpenId();
		LotteryFillOpen fOpen = mLotteryFillOpenService.selectById(openId);
		model.addAttribute("fOpen", fOpen);
		model.addAttribute("fillOpenId", openId);
		model.addAttribute("openAwardUrl", url("/operate/open"));
		model.addAttribute("userListUrl",
				HttpUrl.replaceUrl("/user/fill/operate/list"));

		return "page/lottery/fill/open_award.jsp";
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
			throw new ParamsErrorException("请登录");
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
		if(!ServiceUserPowerUtils.isCanCreateFillOpen(createUser.getPower())){
			throw new PowerException("权限不足");
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
	 * 用于发放积分
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/operate/sendLBi", method = RequestMethod.POST)
	@ResponseBody
	public Result sendLBi(HttpServletRequest request,
			LotteryFillUserSearch params) {
		Result result = new Result();
		try {
			HttpSession session = request.getSession();
			Integer operateUserId = SessionUtils.getId(session);
			UserManager operateUser = mUserServiceManagerService
					.findUserById(operateUserId);
			if (operateUser == null) {
				throw new LotteryException("没有登录");
			}
			String pw = params.getPw();
			if (StringUtils.isEmpty(pw)) {
				throw new LotteryException("参数不正确");
			}

			if (!pw.equals(operateUser.getPw())) {
				throw new LotteryException("密码不正确");
			}

			if (!ServiceUserPowerUtils.isCanSendLBi(operateUser.getPower())) {
				throw new LotteryException("权限不足");
			}
			if (NumberUtils.isZero(params.getLotteryFillOpenId())) {
				throw new LotteryException("参数不正确");
			}
			LotteryFillOpen fillOpen = mLotteryFillOpenService
					.selectById(params.getLotteryFillOpenId());

			if (fillOpen == null) {
				throw new LotteryException("参数不正确");
			}

			String sendStatus = fillOpen.getSendStatus();
			if (C.LotteryOpen.SEND_STATUS_OK.equals(sendStatus)) {
				throw new LotteryException("已经发放奖励，不能重复发放奖励");
			}

			/**
			 * 查询到的中奖彩票
			 */
			FillUserDetails awardUserLottery = mLotteryFillUserService
					.selectAwardUserByOpenId(params.getLotteryFillOpenId());
			if (awardUserLottery == null) {
				throw new LotteryException("当前没有中奖用户");
			}

			// 获取中奖彩票拥有人id
			Integer userId = awardUserLottery.getUserId();
			UserClientSSearch awardUserClient = mUserClientManagerService
					.findUserByUserId(userId);
			if (awardUserClient == null) {
				throw new LotteryException("用户不存在");
			}

			// 中奖积分数量
			BigDecimal awardLBi = fillOpen.getAwardLBi();
			// 添加充值积分表，
			IncomeManifest createIncome = new IncomeManifest();
			createIncome
					.setCreateDate(new Timestamp(System.currentTimeMillis()));
			createIncome.setIncomeDocNo(MakeManifest
					.makeFillSendLBiManifestNo());
			createIncome.setPayMoney(0d);
			createIncome.setInQty(awardLBi.doubleValue());
			createIncome.setUserId(userId);
			mManifestIncomeManagerService
					.createIncomeTypeManifest(createIncome);
			// 添加积分kkkkk变化表//更新用户表
			mManifestIncomeManagerService.incomeSuccessById(
					createIncome.getIncomeId(), "奖励积分",
					C.CHANGE_OPERATE_TYPE_FILL);

			// 修改中奖彩票状态，修改为已经发放奖励；
			LotteryFillOpen updateFillOpen = new LotteryFillOpen();
			updateFillOpen
					.setLotteryFillOpenId(fillOpen.getLotteryFillOpenId());
			updateFillOpen.setSendStatus(C.LotteryOpen.SEND_STATUS_OK);
			updateFillOpen.setAwardManifestId(createIncome.getIncomeId());

			mLotteryFillOpenService.updateFillOpenById(updateFillOpen);

			result.setCode(Code.SUCCESS);

		} catch (Exception e) {
			logger.error("sendLBi", e);
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
	public Result openLottery(HttpServletRequest request,
			LotteryFillOpenSearch params) {
		Result result = new Result();
		try {
			// 需要检测 是否有开奖的的lotteryOpenId
			Integer fOpenId = params.getLotteryFillOpenId();
			if (NumberUtils.isZero(fOpenId)) {
				throw new LotteryException("参数不正确");
			}
			// 检测用户是否拥有权限
			HttpSession session = request.getSession();
			Integer id = SessionUtils.getId(session);
			UserManager findUserById = mUserServiceManagerService
					.findUserById(id);
			if (findUserById == null) {
				throw new LotteryException("请登录");
			}

			if (!C.UserManagerPower.POWER_ALL.equals(findUserById.getPower())) {
				throw new LotteryException("权限不足");
			}

			// 检测购买数量是否足够
			params.setCanSendAward(LotteryFillOpenSearch.TPYE_CAN_SEND);
			List<LotteryFillOpen> list = mLotteryFillOpenService
					.selectByParams(params);
			if (list == null || list.size() != 1) {
				throw new LotteryException("参数不正确");
			}
			LotteryFillOpen openF = list.get(0);
			if (!StringUtils.isEmpty(openF.getOpenNumber())) {
				throw new LotteryException("已经抽取过中奖用户，不能重复操作");
			}

			// 查询所有购买过的该彩票的用户，
			List<FillUserDetails> buyUserList = mLotteryFillUserService
					.selectUserDetailsByOpenId(openF.getLotteryFillOpenId());
			// 用于存放 购买用户的编号
			FillUserDetails[] arrs = new FillUserDetails[openF.getFillLBi()
					.intValue()];
			int index = 0;
			for (int i = 0; i < buyUserList.size(); i++) {
				FillUserDetails itemUser = buyUserList.get(i);
				for (int j = 0; j < itemUser.getLotteryFillBuyQty(); j++) {
					arrs[index] = itemUser;
					index++;
				}
			}
			// 生成随机数，获得中奖用户
			Random random = new Random();
			int awardIndex = random.nextInt(index);

			FillUserDetails fillUserDetails = arrs[awardIndex];

			// 更新开奖表，中奖用户ID，中奖号码，
			LotteryFillOpenSearch updateFillOpen = new LotteryFillOpenSearch();
			updateFillOpen.setAwardUserId(fillUserDetails
					.getLotteryFillUserId());
			updateFillOpen.setOpenNumber(String.valueOf(awardIndex));
			updateFillOpen.setLotteryFillOpenId(fillUserDetails
					.getLotteryFillOpenId());
			updateFillOpen.setLotteryFillCreaterDate(openF
					.getLotteryFillCreaterDate());
			updateFillOpen.setLotteryFillEndDate(new Date());
			updateFillOpen.setStatus(C.LotteryOpen.STATUS_OPEN);
			mLotteryFillOpenService.updateFillOpenById(updateFillOpen);

			// 更新中奖用户 中的中奖号码
			LotteryFillUser updateFillUser = new LotteryFillUser();
			updateFillUser.setLotteryFillUserId(fillUserDetails
					.getLotteryFillUserId());
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

	/**
	 * 通过typeId 创建与当前type类型相同的彩票。
	 * 
	 * @return
	 */
	@RequestMapping("/operate/createFillOpen")
	@ResponseBody
	public Result createSameFillOpenLotteryByTypeId(HttpServletRequest request,
			LotteryFillOpenSearch params) {
		Result result = new Result();
		try {
			checkCreateFillOpenParams(request, params);
			Integer createUserId = SessionUtils.getId(request.getSession());
			LotteryFillOpenSearch createFillOpen = mLotteryFillOpenService
					.createFillOpenByTypeId(createUserId, params);
			result.setData(createFillOpen);
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("createSameFillOpenLotteryByTypeId", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	/**
	 * 通过typeId 创建一个model对象，并返回给页面展示
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/operate/getModel")
	@ResponseBody
	public Result getFillOpenLotteryModelByTypeId(HttpServletRequest requset,
			LotteryFillOpenSearch params) {
		Result result = new Result();
		try {
			checkCreateFillOpenParams(requset, params);
			LotteryFillOpenSearch fillOpenModel = mLotteryFillOpenService
					.getFillOpenModelByTypeId(params.getLotteryTypeId());

			if (fillOpenModel == null) {
				throw new LotteryException("当前没有彩票模型对象");
			}

			result.setCode(Code.SUCCESS);
			result.setData(fillOpenModel);
		} catch (Exception e) {
			logger.error("createSameFillOpenLotteryModelByTypeId", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	private void checkCreateFillOpenParams(HttpServletRequest requset,
			LotteryFillOpenSearch params) {
		HttpSession session = requset.getSession();
		Integer userId = SessionUtils.getId(session);
		if (NumberUtils.isZero(userId)) {
			throw new LotteryException("请登录");
		}

		UserManager userService = mUserServiceManagerService
				.findUserById(userId);
		if (userService == null) {
			throw new LotteryException("请登录");
		}

		if (!ServiceUserPowerUtils.isCanCreateFillOpen(userService.getPower())) {
			throw new PowerException("权限不足，不能创建彩票");
		}

		if (NumberUtils.isZero(params.getLotteryTypeId())) {
			throw new LotteryException("参数不正确");
		}
	}
}
