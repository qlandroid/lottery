package org.ql.shopping.util;

public class NumberUtils {

	
	public static<T extends Number> boolean isZero(T n){
		if(n == null || n.equals(0)){
			return true;
		}
		
		return false;
	}
}
