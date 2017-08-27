package org.ql.shopping.pojo.result;

import java.util.List;

import org.ql.shopping.pojo.IResultError;

public class TabelResult extends IResultError{
	/**
	 * 数据显示信息 { code: 0, //状态码，0代表成功，其它失败 msg: "", //状态信息，一般可为空 count: 1000,
	 * //数据总量 data: [] //数据，字段是任意的。如：[{"id":1,"username":"贤心"},
	 * {"id":2,"username":"佟丽娅"}] }
	 * 
	 * @type {{url: string, where: {}, method: string, cols: [*]}}
	 */

	private String msg;
	private Long count;
	private List data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

}
