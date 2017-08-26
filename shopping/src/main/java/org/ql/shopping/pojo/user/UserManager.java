package org.ql.shopping.pojo.user;

public class UserManager {

	private Integer id;
	private String account;
	private String pw;
	private String power;
	private String name;
	private String phone;
	private String address;
	private Long firstIndex;
	private Integer pageSize;
	private Long page;
	private Boolean isLike;

	public Boolean getIsLike() {
		return isLike;
	}

	public void setIsLike(Boolean isLike) {
		this.isLike = isLike;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
