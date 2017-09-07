package org.ql.shopping.util;

import java.text.SimpleDateFormat;

public class LotteryStageUtils {
	
	public static  String createStage(String firstFlag,int count){
		StringBuffer sb = new StringBuffer();
		sb.append(firstFlag);
		String datePrefix = new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
		sb.append(datePrefix);
		int[] array = new int[7];
		for (int i =0 ; i< 7 ;i++) {
			int a = count%10;
			count = count/10;
			array[i] = a;
		}
		for(int i = 6 ;i >= 0 ;i--){
			sb.append(array[i]);
		}
		
		return sb.toString();
	}
}
