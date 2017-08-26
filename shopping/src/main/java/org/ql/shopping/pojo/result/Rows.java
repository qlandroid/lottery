package org.ql.shopping.pojo.result;

import java.util.List;

import org.ql.shopping.pojo.IResultError;

public class Rows extends IResultError {
	private Long total;
	private List<Object> list;

	public Long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<Object> getList() {
		return list;
	}

	public <T> void setList(List<T> list) {
		this.list = (List<Object>) list;
	}

}
