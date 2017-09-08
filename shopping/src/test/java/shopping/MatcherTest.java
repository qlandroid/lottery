package shopping;

import org.ql.shopping.util.MatcherUtils;

public class MatcherTest {
	public static void main(String[] args) {
		String phone0 = "186178105254";
		String phone1 = "18655555";
		boolean p0 = MatcherUtils.isPhoneMatcher(phone0);
		boolean p1 = MatcherUtils.isPhoneMatcher(phone1);
		System.out.println("phone0"+"---"+phone0 +"----" + p0);
		System.out.println("phone1"+"---"+phone1 +"----" + p1);

	}
}
