package org.ql.shopping.util;

public class StringUtils {
	public static boolean isEmpty(String s){
		if(s == null || s.isEmpty()){
			return true;
		}
		return false;
	}
}
