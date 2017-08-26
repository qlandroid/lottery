package org.ql.shopping.code;

public class C {
	public static final Integer PAGE_SIZE = 10;

	// 积分变化表 type字段 0-支出 ，1-收入
	public static final String CHANGE_TYPE_INCOME = "1";
	public static final String CHANGE_TYPE_EXPEND = "0";
	// 积分变化表 operateType字段 ，0-收入任务单创建，1-支出任务单创建，2-其他操作，
	public static final String CHANGE_OPERATE_TYPE_INCOME = "0";
	public static final String CHANGE_OPERATE_TYPE_EXPEND = "1";
	public static final String CHANGE_OPERATE_TYPE_OTHER = "2";

	public static class ManifestIncome {
		// manifest_income status 当前交易状态0-未支付，1-支付完成，2-订单超时，3-取消订单
		public final static String INCOME_STATUS_WAITING = "0";
		public final static String INCOME_STATUS_SUCCESS = "1";
		public final static String INCOME_STATUS_TIME_OUT = "2";
		public final static String INCOME_STATUS_CANCEL = "3";
	}

	public static class LotteryClazz {
		/**
		 * 查询他的父类为-1 那么他就是最外层的
		 */
		public final static Integer MAIN = 0;
	}

	public static class LotteryType {
		public final static String SEND_STATUS_OVER = "1";// 支付状态 已经支付完成
		public final static String SEND_STATUS_UNFINSH = "0";// 支付状态 未完成
	}
}
