package org.ql.shopping.util;

import javax.servlet.http.HttpSession;

public class SessionUtils {

	public static Integer getId(HttpSession session) {
		return (Integer) session.getAttribute("userId");
		
	}

}
