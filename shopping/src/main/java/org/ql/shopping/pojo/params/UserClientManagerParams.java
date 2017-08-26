package org.ql.shopping.pojo.params;

public class UserClientManagerParams {

	private Long id;
	private String account;
	private String pw;
	private String name;
	private String zhifubao;
	private String clientId;// 身份证号
	private String phone;
	private String detailsId;// 用户详情id

	private Long firstIndex;
	private Long page;
	private Integer pageSize;

	private Double rechagerLBi;// 充值积分

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(Long firstIndex) {
		this.firstIndex = firstIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(String detailsId) {
		this.detailsId = detailsId;
	}

}
