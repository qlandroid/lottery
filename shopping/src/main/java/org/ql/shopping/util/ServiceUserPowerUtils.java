package org.ql.shopping.util;

import org.ql.shopping.code.C;

public class ServiceUserPowerUtils {

	/**
	 * 用于判断权限，是否可以发放奖励
	 * @param power
	 * @return
	 */
	public static boolean isCanSendLBi(String power) {
		return C.UserManagerPower.POWER_ALL.equals(power);
	}

	/**
	 * 权限判断是否可以创建彩票
	 * @param power
	 * @return
	 */
	public static boolean isCanCreateFillOpen(String power) {
		if(C.UserManagerPower.POWER_ALL.equals(power)){
			return true;
		}
		
		return false;
	}

}
