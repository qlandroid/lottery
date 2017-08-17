package org.ql.shopping.pojo.result;

import java.util.List;

public class MainLeftNav {
	
	private String title;
	private String icon;
	private String href;
	private boolean spread;
	private List<MainLeftNav> children;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public boolean getSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public List<MainLeftNav> getChildren() {
		return children;
	}
	public void setChildren(List<MainLeftNav> children) {
		this.children = children;
	}
	
/**
 * [{
	"title" : "鍚庡彴棣栭〉",
	"icon" : "icon-computer",
	"href" : "page/main.html",
	"spread" : false
},{
	"title" : "鏂囩珷鍒楄〃",
	"icon" : "icon-text",
	"href" : "page/news/newsList.html",
	"spread" : false
},{
	"title" : "鍙嬫儏閾炬帴",
	"icon" : "&#xe64c;",
	"href" : "page/links/linksList.html",
	"spread" : false
},{
	"title" : "绯荤粺鍩烘湰鍙傛暟",
	"icon" : "&#xe631;",
	"href" : "page/systemParameter/systemParameter.html",
	"spread" : false
},{
	"title" : "鍏朵粬椤甸潰",
	"icon" : "&#xe630;",
	"href" : "",
	"spread" : false,
	"children" : [
		{
			"title" : "404椤甸潰",
			"icon" : "&#xe61c;",
			"href" : "page/404.html",
			"spread" : false
		},
		{
			"title" : "鐧诲綍",
			"icon" : "&#xe609;",
			"href" : "page/login/login.html",
			"spread" : false,
			"target" : "_blank"
		}
	]
}]
 */
}
