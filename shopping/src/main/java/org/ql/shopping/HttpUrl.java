package org.ql.shopping;


public class HttpUrl {

	public static final String BASE_URL = "http://localhost:8080/lottery";
	
	public static String replaceUrl(String url){
		return BASE_URL + url;
	}
}
