package org.ql.shopping.pojo.manifest;

public class ManifestExpendSs extends ManifestExpend{
	private String zhifubao;
	private String name;
	private String clientId;//用户的身份证号码
	private String phone;
	private Double lBi;//订单所属用户 剩余积分数量
	private String account ;//订单所属用户 账号
	
	private String statusName;//订单的状态名称

	public String getZhifubao() {
		return zhifubao;
	}

	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
