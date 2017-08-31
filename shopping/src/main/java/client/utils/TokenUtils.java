package client.utils;

public class TokenUtils {

	public final static String TAG_ACCOUNT = "F";

	public final static String TAG_ID = "C";

	public static Integer getUserId(String token) {
		try {
			return Integer.parseInt(token);
		} catch (Exception e) {
			return -1;
		}
	}

	public static String createToken(String account, String pw, long id) {
		long time = System.currentTimeMillis();
		String token = String.valueOf(time)+ TAG_ID + String.valueOf(id)+TAG_ACCOUNT + account;
		return token ;
	}
	
}