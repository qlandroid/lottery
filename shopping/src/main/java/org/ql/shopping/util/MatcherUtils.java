package org.ql.shopping.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherUtils {
	private static final String MATCHER_ACCTOUNT = "^[A-Za-z][A-Za-z0-9_-]+$";
	private static final String MATCHER_PHONE = "^1[3|4|5|8][0-9]\\d{8}$";
	private static final String MATCHER_EMAIL="^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$";
	
	private static final String MATCHER_CLIENT_ID = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d)([0123]\\d)(\\d{3})(\\d|X|x)?$";
	/**
	 * 验证基础
	 * @param str  //验证的信息
	 * @param compile //验证的规则
	 * @return
	 */
	private static boolean matcher(String str,String compile) {
		Pattern compiles = Pattern.compile(compile);
		Matcher matcher = compiles.matcher(str);
		return matcher.matches();
	}
	/**
	 * 用户名（字母开头 + 数字/字母/下划线）
	 * 验证账号 是否符合 格式
	 * @param acctount
	 * @return
	 */
	public static boolean isAccountMatcher(String acctount){
		return matcher(acctount,MATCHER_ACCTOUNT);
	}


	public static boolean isPhoneMatcher(String phone){
		return matcher(phone,MATCHER_PHONE);
	}
	
	public static boolean isEmailMatcher(String eMail){
		return matcher(eMail,MATCHER_EMAIL);
	}
	
	public static boolean isClientIdMatcher(String clientId){
		return matcher(clientId,MATCHER_CLIENT_ID);
	}
}

