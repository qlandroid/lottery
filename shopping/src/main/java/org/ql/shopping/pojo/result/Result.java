package org.ql.shopping.pojo.result;

import java.util.List;

import org.ql.shopping.pojo.IResultError;

public class Result extends IResultError{
	private Object data;
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
