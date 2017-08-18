package org.ql.shopping.util;

import org.ql.shopping.code.Code;
import org.ql.shopping.pojo.Result;

public class ResultHintUtils {

	public static void setSystemError(Result result){
		result.setCode(Code.ERROR);
		result.setMessage("系統內部錯誤");
	}
}
