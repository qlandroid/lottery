package org.ql.shopping.pojo.lottery;

import org.ql.shopping.pojo.Model;

public class LotteryType extends Model{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_type.lottery_type_id
     *
     * @mbggenerated
     */
    private Integer lotteryTypeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_type.lottery_type
     *
     * @mbggenerated
     */
    private String lotteryType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_type.lottery_name
     *
     * @mbggenerated
     */
    private String lotteryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column lottery_type.lottery_clazz_id
     *
     * @mbggenerated
     */
    private Integer lotteryClazzId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_type.lottery_type_id
     *
     * @return the value of lottery_type.lottery_type_id
     *
     * @mbggenerated
     */
    public Integer getLotteryTypeId() {
        return lotteryTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_type.lottery_type_id
     *
     * @param lotteryTypeId the value for lottery_type.lottery_type_id
     *
     * @mbggenerated
     */
    public void setLotteryTypeId(Integer lotteryTypeId) {
        this.lotteryTypeId = lotteryTypeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_type.lottery_type
     *
     * @return the value of lottery_type.lottery_type
     *
     * @mbggenerated
     */
    public String getLotteryType() {
        return lotteryType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_type.lottery_type
     *
     * @param lotteryType the value for lottery_type.lottery_type
     *
     * @mbggenerated
     */
    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType == null ? null : lotteryType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_type.lottery_name
     *
     * @return the value of lottery_type.lottery_name
     *
     * @mbggenerated
     */
    public String getLotteryName() {
        return lotteryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_type.lottery_name
     *
     * @param lotteryName the value for lottery_type.lottery_name
     *
     * @mbggenerated
     */
    public void setLotteryName(String lotteryName) {
        this.lotteryName = lotteryName == null ? null : lotteryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column lottery_type.lottery_clazz_id
     *
     * @return the value of lottery_type.lottery_clazz_id
     *
     * @mbggenerated
     */
    public Integer getLotteryClazzId() {
        return lotteryClazzId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column lottery_type.lottery_clazz_id
     *
     * @param lotteryClazzId the value for lottery_type.lottery_clazz_id
     *
     * @mbggenerated
     */
    public void setLotteryClazzId(Integer lotteryClazzId) {
        this.lotteryClazzId = lotteryClazzId;
    }
}