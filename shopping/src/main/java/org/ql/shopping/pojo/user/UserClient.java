package org.ql.shopping.pojo.user;

public class UserClient {

	private Long id;
	private String name;// 用户姓名
	private Long userId;
	private String zhifubao;// 支付宝账号
	private String clientId;// 身份证号
	private String phone;// 电话号码
	private Double lBi;// 当前平台货币；
	private String pw;
	private String account;
	private Double expendLBi;// 消费的积分

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZhifubao() {
		return zhifubao;
	}

	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getlBi() {
		return lBi;
	}

	public void setlBi(Double lBi) {
		this.lBi = lBi;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getExpendLBi() {
		return expendLBi;
	}

	public void setExpendLBi(Double expendLBi) {
		this.expendLBi = expendLBi;
	}

}
