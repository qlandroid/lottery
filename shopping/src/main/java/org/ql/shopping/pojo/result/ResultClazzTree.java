package org.ql.shopping.pojo.result;

import java.util.List;

public class ResultClazzTree {
	public static final String TYPE_CLAZZ = "0";
	public static final String TYPE_TYPE = "1";
	public static final String TYPE_FILL_OPEN = "2";

	private String name;
	private Integer id;
	private List<ResultClazzTree> children;
	private Boolean spread;
	private String type;
	private String url;
	
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<ResultClazzTree> getChildren() {
		return children;
	}

	public void setChildren(List<ResultClazzTree> children) {
		this.children = children;
	}

}
