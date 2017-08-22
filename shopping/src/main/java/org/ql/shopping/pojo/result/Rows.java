package org.ql.shopping.pojo.result;

import java.util.List;

public class Rows {
	private int code;
	private Long total;
	private String message;
	private List<Object> list;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Object> getList() {
		return list;
	}
	public<T> void setList(List<T> list) {
		this.list = (List<Object>) list;
	}
	
}
