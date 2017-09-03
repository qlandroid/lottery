package client.utils;

public class TokenUtils {

	public final static int ERROR_USER_ID = -1;
	public final static String TAG_ACCOUNT = "8975643158";

	public final static String TAG_ID = "ff55997ddaad23fg";

	public static Integer getUserId(String token) {
		try {
			
			String[] split = token.split(TAG_ID);
			if(split.length < 2){
				return ERROR_USER_ID;
			}
			
			String split2 = split[1];
			String[] split3 = split2.split(TAG_ACCOUNT);
			if(split3.length <2){
				return ERROR_USER_ID;
			}
			
			return Integer.parseInt(split3[0]);
		} catch (Exception e) {
			return ERROR_USER_ID;
		}
	}

	public static String createToken(String account, String pw, long id) {
		long time = System.currentTimeMillis();
		String token = String.valueOf(time)+ TAG_ID + String.valueOf(id)+TAG_ACCOUNT + account;
		return token ;
	}
	
}