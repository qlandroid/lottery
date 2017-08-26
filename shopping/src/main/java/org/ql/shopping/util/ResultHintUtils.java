package org.ql.shopping.util;

import org.ql.shopping.code.Code;
import org.ql.shopping.exception.LotteryException;
import org.ql.shopping.pojo.IResultError;
import org.ql.shopping.pojo.result.Result;

public class ResultHintUtils {

	public static void setSystemError(Result result) {
		result.setCode(Code.ERROR);
		result.setMessage("系統內部錯誤");
	}

	public static <T extends IResultError> void setSystemError(T result, Exception e) {
		if (e instanceof LotteryException) {
			result.setCode(Code.ERROR);
			result.setMessage(e.getMessage());
		} else {
			result.setCode(Code.ERROR);
			result.setMessage("系统内部错误");
		}
	}
}
