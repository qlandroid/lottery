package client.utils;

public class TokenUtils {

	
	public static Integer getUserId(String token){
		return Integer.parseInt(token);
	}
}
