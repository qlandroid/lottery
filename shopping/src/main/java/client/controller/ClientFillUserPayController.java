package client.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.code.C;
import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.exception.ManifestNoHaveException;
import org.ql.shopping.exception.ParamsErrorException;
import org.ql.shopping.pojo.lottery.LotteryFillOpen;
import org.ql.shopping.pojo.lottery.LotteryFillUser;
import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.result.Result;
import org.ql.shopping.pojo.user.UserClient;
import org.ql.shopping.service.lottery.ILotteryFillOpenService;
import org.ql.shopping.service.lottery.ILotteryFillUserService;
import org.ql.shopping.service.user.IUserClientManagerService;
import org.ql.shopping.util.MakeManifest;
import org.ql.shopping.util.NumberUtils;
import org.ql.shopping.util.ResultHintUtils;
import org.ql.shopping.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import client.pojo.fill.FillOpenSearch;
import client.pojo.fill.FillUserPaySearch;
import client.pojo.manifest.ManifestExpendSearch;
import client.pojo.user.UserClientSearch;
import client.service.lottery.IClientFillOpenService;
import client.service.lottery.IClientFillUserService;
import client.service.manifest.IClientLBiChangeManifestService;
import client.service.manifest.IManifestExpendService;
import client.service.user.IUserManagerService;
import client.utils.TokenUtils;

@Controller
@RequestMapping("/fill/user")
public class ClientFillUserPayController {
	private Logger logger = LoggerFactory.getLogger(ClientFillUserPayController.class);

	@Resource
	private IUserClientManagerService mUserClientManagerService;
	@Resource
	private ILotteryFillOpenService mLotteryFillOpenService;
	@Resource
	private ILotteryFillUserService mLotteryFillUserService;
	@Resource
	private IManifestExpendService mManifestExpendService;
	@Resource
	private IClientFillUserService mClientFIllUserService;
	@Resource
	private IClientFillOpenService mClientFillOpenService;
	@Resource 
	private IClientLBiChangeManifestService mClientLBichangeManifestService;
	@Resource 
	private IUserManagerService mUserManagerService;
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
			Integer userId = TokenUtils.getUserId(params.getToken());
			UserClient payUser = mUserClientManagerService.findUserByUserId(userId);
			if (payUser == null) {
				throw new LotteryException("账号不存在");
			}
			LotteryFillOpen fillOpen = mLotteryFillOpenService.selectById(params.getFillId());

			if (fillOpen == null) {
				throw new LotteryException("彩票不存在");
			}
			
			// 判断用户支付积分 是否 小于 当前所拥有的积分数量
			Double haveLBi = payUser.getlBi().doubleValue();
			double fillUnitPrice = fillOpen.getLotteryFillUnitPrice().doubleValue();
			Double userPayQty = fillUnitPrice * params.getPayQty();

			if (haveLBi < userPayQty) {
				throw new LotteryException("积分余额不足，请充值");
			}

			checkCanBuy(fillOpen, userPayQty);
			// 生成彩票
			LotteryFillUser user = new LotteryFillUser();
			user.setLotteryFillStatus(C.ManifestStatus.INCOME_STATUS_WAITING);
			user.setLotteryFillBuyQty(params.getPayQty());
			user.setUserId(TokenUtils.getUserId(params.getToken()));
			user.setLotteryTypeId(fillOpen.getLotteryTypeId());
			user.setLotteryFillOpenId(fillOpen.getLotteryFillOpenId());
			mLotteryFillUserService.addFillLottery(user);

			// 生成支付订单
			String expendDocNo = MakeManifest.makeExpendManifestNo();
			ManifestExpendSearch createExpentManifest = new ManifestExpendSearch();
			createExpentManifest.setCreateTime(new Date());
			createExpentManifest.setDocNo(expendDocNo);
			createExpentManifest.setLotteryTypeId(fillOpen.getLotteryTypeId());
			createExpentManifest.setUserId(payUser.getUserId());
			createExpentManifest.setLotteryId(user.getLotteryFillUserId());
			createExpentManifest.setStatus(C.ManifestStatus.INCOME_STATUS_WAITING);
			mManifestExpendService.createExpendManifest(createExpentManifest);

			result.setCode(Code.SUCCESS);

			ManifestExpendSearch s = new ManifestExpendSearch();
			s.setDocNo(createExpentManifest.getDocNo());
			result.setData(s);
		} catch (Exception e) {
			logger.error("createManifest", e);
			ResultHintUtils.setSystemError(result, e);

		}

		return result;
	}

	/**
	 * 用于检测 用户是否可以购买
	 * 
	 * @param fillOpen
	 *            开奖彩票的id
	 * @param userPayQty
	 *            用户要购买的数量
	 */
	private void checkCanBuy(LotteryFillOpen fillOpen, Double userPayQty) {
		// 判断当前彩票状态，当前剩余可购买数量
		Double overBuyQty = mClientFIllUserService.selectOverBuyByOpenId(fillOpen.getLotteryFillOpenId());
		double fillLBi = fillOpen.getFillLBi().doubleValue();
		if (overBuyQty == fillLBi) {
			throw new LotteryException("彩票购买数量已经满足，不能进行购买");
		}

		double payTotalQty = userPayQty + overBuyQty;
		if (payTotalQty > fillLBi) {
			throw new LotteryException("购买数量已经超出当前剩余数量，请重新填写购买数量");
		}
	}

	private void checkCreateManifestParams(FillUserPaySearch params) {
		// 当前彩票的id
		Integer fillId = params.getFillId();
		// 当前用户要支付的金额
		Double payQty = params.getPayQty();
		// 当前用户id
		Integer userId = TokenUtils.getUserId(params.getToken());

		if (NumberUtils.isZero(userId) || NumberUtils.isZero(fillId) || NumberUtils.isZero(payQty)) {
			throw new ParamsErrorException("参数不正确");
		}

	}

	/**
	 * 用户进行支付
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/payMoney")
	@ResponseBody
	public Result payMoney(FillUserPaySearch params) {
		Result result = new Result();
		try {
			checkPayMoneyParams(params);
			/*
			 * 检测用户是否登陆
			 */
			Integer userId = TokenUtils.getUserId(params.getToken());
			if (NumberUtils.isZero(userId)) {
				throw new LotteryException("未登录");
			}
			UserClient payUser = mUserClientManagerService.findUserByUserId(userId);
			if (payUser == null) {
				throw new LotteryException("未登录");
			}

			/**
			 * 检测任务单是否完成
			 */
			ManifestExpendSearch expendManifest = mManifestExpendService.selectByDocNo(params.getExpendDocNo());
			if (expendManifest == null) {
				throw new LotteryException("任务单号不存在");
			}
			// 判断当前任务单的状态，不是未完成状态
			if (!C.ManifestStatus.INCOME_STATUS_WAITING.equals(expendManifest.getStatus())) {
				throw new LotteryException("当前订单状态不可支付，请查看订单状态");
			}

			if (!expendManifest.getUserId().equals(userId)) {
				throw new LotteryException("订单与用户不匹配");
			}
			String payPw = params.getPayPw();
			UserClientSearch clientPayPw = mUserManagerService.selectPayPwByUserId(userId);
			if(StringUtils.isEmpty(clientPayPw.getPayPw())){
				throw new LotteryException("没有设置支付密码，请前往个人中心设置支付密码");
			}
			if(!clientPayPw.getPayPw().equals(payPw)){
				throw new LotteryException("密码不正确");
			}

			FillOpenSearch fillOpen = mClientFillOpenService.selectByDocNo(expendManifest.getDocNo()); // 检测当前彩票是否已经满足数量；

			checkCanBuy(fillOpen, fillOpen.getUserBuyQty().doubleValue());

			Double payQty = fillOpen.getUserBuyQty().doubleValue();
			Double haveQty = payUser.getlBi().doubleValue();
			if (payQty > haveQty) {
				throw new LotteryException("账户余额不足请充值");
			}
			Double lastQty = haveQty;
			haveQty = haveQty - payQty;

			//更新用户金额；
			mUserClientManagerService.updateLBi(haveQty, payUser.getUserId());

			/*
			 * 更新购买彩票的状态
			 */
			FillUserPaySearch buyLottery = mClientFIllUserService.selectByDocNo(expendManifest.getDocNo());
			LotteryFillUser updateBuyLotteryP = new FillUserPaySearch();
			updateBuyLotteryP.setLotteryFillUserId(buyLottery.getLotteryFillUserId());
			updateBuyLotteryP.setLotteryFillStatus(C.ManifestStatus.INCOME_STATUS_SUCCESS);
			mClientFIllUserService.updateStatus(updateBuyLotteryP);
			
			//跟新订单状态
			ManifestExpendSearch expendManiefstStatus = new ManifestExpendSearch();
			expendManiefstStatus.setExpendId(expendManifest.getExpendId());
			expendManiefstStatus.setAfterQty(new BigDecimal(haveQty));
			expendManiefstStatus.setExpendQty(new BigDecimal(payQty));
			expendManiefstStatus.setBeforeQty(new BigDecimal(lastQty));
			expendManiefstStatus.setStatus(C.ManifestStatus.INCOME_STATUS_SUCCESS);
			expendManiefstStatus.setEndTime(new Date());
			mManifestExpendService.updateExpendManfiest(expendManiefstStatus);
			
			//创建 积分变化表
			ManifestLBiChange manifestChangeP = new ManifestLBiChange();
			manifestChangeP.setDocExpendId(expendManiefstStatus.getExpendId());
			manifestChangeP.setType(C.CHANGE_TYPE_EXPEND);
			manifestChangeP.setOperateDate(new Date());
			manifestChangeP.setUserId(userId);
			manifestChangeP.setOperateType(C.CHANGE_OPERATE_TYPE_EXPEND);
			mClientLBichangeManifestService.insert(manifestChangeP);
			//设置返回值
			result.setCode(Code.SUCCESS);
		} catch (Exception e) {
			logger.error("payMoney", e);
			ResultHintUtils.setSystemError(result, e);

		}
		return result;
	}

	private void checkPayMoneyParams(FillUserPaySearch params) {
		String payPw = params.getPayPw();
		String expendDocNo = params.getExpendDocNo();
		String token = params.getToken();
		if (StringUtils.isEmpty(token)) {
			throw new LotteryException("请登录");
		}

		if (StringUtils.isEmpty(payPw) || StringUtils.isEmpty(expendDocNo) || StringUtils.isEmpty(token)) {
			throw new ParamsErrorException("参数不正确");
		}
	}

	/**
	 * 查看订单详情
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping("/manifest/details")
	@ResponseBody
	public Result selectManifest(FillUserPaySearch params) {
		Result result = new Result();
		try {
			checkManfiestDetailsParams(params);
			String token = params.getToken();

			Integer userId = TokenUtils.getUserId(token);
			String expendDocNo = params.getExpendDocNo();

			// 查询订单号
			ManifestExpendSearch expendDoc = mManifestExpendService.selectByDocNoAndUserId(expendDocNo, userId);
			if (expendDoc == null) {
				throw new ManifestNoHaveException("订单不存在");
			}

			result.setCode(Code.SUCCESS);
			result.setData(expendDoc);
		} catch (Exception e) {
			logger.error("selectManifest", e);
			ResultHintUtils.setSystemError(result, e);
		}
		return result;
	}

	private void checkManfiestDetailsParams(FillUserPaySearch params) {
		String expendDocNo = params.getExpendDocNo();
		String token = params.getToken();
		if (StringUtils.isEmpty(token)) {
			throw new LotteryException("没有登录");
		}
		if (StringUtils.isEmpty(expendDocNo)) {
			throw new ParamsErrorException("参数不正确");
		}
	}
}
