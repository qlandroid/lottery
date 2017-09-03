package org.ql.shopping.pojo.user;

import java.math.BigDecimal;

import org.ql.shopping.pojo.Model;

public class UserClient extends Model{
    private Integer id;

    private String zhifubao;

    private String name;

    private String clientId;

    private String phone;

    private Integer userId;

    private BigDecimal lBi;

    private String payPw;
    
    private String account;
    private String pw;
    
    private Double expendQty;
    
    
    
    

    public Double getExpendQty() {
		return expendQty;
	}

	public void setExpendQty(Double expendQty) {
		this.expendQty = expendQty;
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

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZhifubao() {
        return zhifubao;
    }

    public void setZhifubao(String zhifubao) {
        this.zhifubao = zhifubao == null ? null : zhifubao.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId == null ? null : clientId.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getlBi() {
        return lBi;
    }

    public void setlBi(BigDecimal lBi) {
        this.lBi = lBi;
    }

    public String getPayPw() {
        return payPw;
    }
    public void setPayPw(String payPw) {
        this.payPw = payPw == null ? null : payPw.trim();
    }
}