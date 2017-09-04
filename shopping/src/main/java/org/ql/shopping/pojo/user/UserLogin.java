package org.ql.shopping.pojo.user;

import org.ql.shopping.pojo.Model;

public class UserLogin extends Model{
	private Integer id;
	private String account;
	private String pw;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
