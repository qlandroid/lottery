package client.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.Resource;
import javax.security.auth.login.LoginException;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.MakeManifestNo;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.fill.FillUserPaySearch;
import client.pojo.manifest.ManifestExpentSearch;
import client.service.manifest.IManifestExpendService;
import client.utils.TokenUtils;

@Controller
@RequestMapping("/fill/user")
public class ClientFillUserPayController {
	private Logger logger = LoggerFactory
			.getLogger(ClientFillUserPayController.class);

	@Resource
	private IUserClientManagerService mUserClientManagerService;
	@Resource
	private ILotteryFillOpenService mLotteryFillOpenService;
	@Resource
	private ILotteryFillUserService mLotteryFillUserService;
	@Resource
	private IManifestExpendService mManifestExpendService;

	/**
	 * 创建 支付的任务单号
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/createManifest")
	@ResponseBody
	public Result createManifest(FillUserPaySearch params) {
		Result result = new Result();
		try {
			checkCreateManifestParams(params);
			UserClient payUser = mUserClientManagerService
					.findUserById(new Long(params.getUserId()));
			if (payUser == null) {
				throw new LotteryException("账号不存在");
			}
			LotteryFillOpen fillOpen = mLotteryFillOpenService
					.selectById(params.getFillId());

			if (fillOpen == null) {
				throw new LotteryException("彩票不存在");
			}

			// 判断用户支付积分 是否 小于 当前所拥有的积分数量
			Double haveLBi = payUser.getlBi();
			double fillUnitPrice = fillOpen.getLotteryFillUnitPrice()
					.doubleValue();
			Double userPayQty = fillUnitPrice * params.getPayQty();

			if (haveLBi < userPayQty) {
				throw new LotteryException("积分余额不足，请充值");
			}

			// 生成支付订单
			String expendDocNo = MakeManifest.makeExpendManifestNo();
			ManifestExpentSearch createExpentManifest = new ManifestExpentSearch();
			createExpentManifest.setCreateTime(new Date());
			createExpentManifest.setDocNo(expendDocNo);
			createExpentManifest.setLotteryTypeId(fillOpen
					.getLotteryFillOpenId());
			mManifestExpendService.createExpendManifest(createExpentManifest);

			// 生成彩票
			LotteryFillUser user = new LotteryFillUser();
			user.setLotteryFillStatus(C.ManifestStatus.INCOME_STATUS_WAITING);
			user.setLotteryFillBuyQty(params.getPayQty());
			user.setUserId(TokenUtils.getUserId(params.getToken()));
			user.setLotteryTypeId(fillOpen.getLotteryTypeId());
			user.setLotteryFillOpenId(fillOpen.getLotteryFillOpenId());
			mLotteryFillUserService.addFillLottery(params);

			result.setCode(Code.SUCCESS);
			result.setData(createExpentManifest);
		} catch (Exception e) {
			logger.error("pay", e);
			ResultHintUtils.setSystemError(result, e);

		}

		return result;
	}

	private void checkCreateManifestParams(FillUserPaySearch params) {
		// 当前彩票的id
		Integer fillId = params.getFillId();
		// 当前用户要支付的金额
		Double payQty = params.getPayQty();
		// 当前用户id
		Integer userId = TokenUtils.getUserId(params.getToken());

		if (NumberUtils.isZero(userId) || NumberUtils.isZero(fillId)
				|| NumberUtils.isZero(payQty)) {
			throw new ParamsErrorException("参数不正确");
		}

	}

	public Result payMoney(FillUserPaySearch params) {
		Result result = new Result();
		try {
			checkPayMoneyParams(params);
			
			ManifestExpentSearch expendManifest = mManifestExpendService.selectByDocNo(params.getExpendDocNo());
			if(expendManifest==null){
				throw new LotteryException("任务单号不存在");
			}
			//判断当前任务单的状态，如果已经状态是支付完成
			if(!C.ManifestStatus.INCOME_STATUS_WAITING.equals(expendManifest.getStatus())){
				throw new LotteryException("任务单已经完成，不能重复操作");
			}
			
			Integer userId = TokenUtils.getUserId(params.getToken());
			if(NumberUtils.isZero(userId)){
				throw new LotteryException("未登录");
			}
			
			UserClient payUser = mUserClientManagerService.findUserById(new Long(userId));
			if(payUser == null){
				throw new LotteryException("未登录");
			}
			
			
			
		} catch (Exception e) {
			logger.error("payMoney",e);
			ResultHintUtils.setSystemError(result, e);

		}
		return result;
	}

	private void checkPayMoneyParams(FillUserPaySearch params) {
		String payPw = params.getPayPw();
		String expendDocNo = params.getExpendDocNo();
		String token = params.getToken();
		if(StringUtils.isEmpty(token)){
			throw new LotteryException("请登录");
		}
		
		if (StringUtils.isEmpty(payPw) || StringUtils.isEmpty(expendDocNo)||StringUtils.isEmpty(token)) {
			throw new ParamsErrorException("参数不正确");
		}
	}
}
