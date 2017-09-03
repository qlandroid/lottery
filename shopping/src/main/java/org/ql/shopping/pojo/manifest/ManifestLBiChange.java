package org.ql.shopping.pojo.manifest;

import java.util.Date;

import org.ql.shopping.pojo.Model;

public class ManifestLBiChange extends Model{
    private Integer changeDocId;
    private String type;

    private Integer docExpendId;

    private Integer docIncomeId;
    private Date operateDate;

    private Integer userId;

    private String operateType;

    private String remark;

    public Integer getChangeDocId() {
        return changeDocId;
    }

    public void setChangeDocId(Integer changeDocId) {
        this.changeDocId = changeDocId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getDocExpendId() {
        return docExpendId;
    }

    public void setDocExpendId(Integer docExpendId) {
        this.docExpendId = docExpendId;
    }

    public Integer getDocIncomeId() {
        return docIncomeId;
    }

    public void setDocIncomeId(Integer docIncomeId) {
        this.docIncomeId = docIncomeId;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType == null ? null : operateType.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}