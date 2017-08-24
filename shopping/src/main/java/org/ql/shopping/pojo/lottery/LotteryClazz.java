package org.ql.shopping.pojo.lottery;

public class LotteryClazz {
    private Integer lotteryClazzId;

    private String lotteryClazzName;

    private Integer lotteryClazzParentId;

    private Integer lotteryClazzLevel;

    private String lotteryClazzRemark;

    public Integer getLotteryClazzId() {
        return lotteryClazzId;
    }

    public void setLotteryClazzId(Integer lotteryClazzId) {
        this.lotteryClazzId = lotteryClazzId;
    }

    public String getLotteryClazzName() {
        return lotteryClazzName;
    }

    public void setLotteryClazzName(String lotteryClazzName) {
        this.lotteryClazzName = lotteryClazzName == null ? null : lotteryClazzName.trim();
    }

    public Integer getLotteryClazzParentId() {
        return lotteryClazzParentId;
    }
    
    public void setLotteryClazzParentId(Integer lotteryClazzParentId) {
        this.lotteryClazzParentId = lotteryClazzParentId;
    }
    
    public Integer getLotteryClazzLevel() {
        return lotteryClazzLevel;
    }
    
    public void setLotteryClazzLevel(Integer lotteryClazzLevel) {
        this.lotteryClazzLevel = lotteryClazzLevel;
    }
    
    public String getLotteryClazzRemark() {
        return lotteryClazzRemark;
    }
    
    public void setLotteryClazzRemark(String lotteryClazzRemark) {
        this.lotteryClazzRemark = lotteryClazzRemark == null ? null : lotteryClazzRemark.trim();
    }
}