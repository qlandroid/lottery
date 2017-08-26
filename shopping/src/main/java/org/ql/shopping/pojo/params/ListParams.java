package org.ql.shopping.pojo.params;

public class ListParams {
	private int page;
	private int pageSize;
	private int firstIndex;
	private int footIndex;

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getFootIndex() {
		return footIndex;
	}

	public void setFootIndex(int footIndex) {
		this.footIndex = footIndex;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
