package org.ql.shopping.pojo;

public class UserClient {

	private Long id;
	private String name;//用户姓名
	private String zhiFuBao;//支付宝账号
	private String clientId;//身份证号
	private String phone;//电话号码
	private long userId;
	private double lBi;//当前平台货币；
	private String idFront;//身份证正面；
	private String idVerso;//身份证反面；
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZhiFuBao() {
		return zhiFuBao;
	}
	public void setZhiFuBao(String zhiFuBao) {
		this.zhiFuBao = zhiFuBao;
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
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public double getlBi() {
		return lBi;
	}
	public void setlBi(double lBi) {
		this.lBi = lBi;
	}
	public String getIdFornt() {
		return idFront;
	}
	public void setIdFornt(String idFornt) {
		this.idFront = idFornt;
	}
	public String getIdVerso() {
		return idVerso;
	}
	public void setIdVerso(String idVerso) {
		this.idVerso = idVerso;
	}
	
	
}
