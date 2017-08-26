package org.ql.shopping.pojo.manifest;

import java.math.BigDecimal;
import java.util.Date;

import org.ql.shopping.pojo.Model;

public class ManifestExpend extends Model {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.expend_id
	 *
	 * @mbggenerated
	 */
	private Integer expendId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.expend_doc_no
	 *
	 * @mbggenerated
	 */
	private String expendDocNo;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.create_time
	 *
	 * @mbggenerated
	 */
	private Date createTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.expend_qty
	 *
	 * @mbggenerated
	 */
	private BigDecimal expendQty;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.status
	 *
	 * @mbggenerated
	 */
	private String status;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.user_id
	 *
	 * @mbggenerated
	 */
	private Integer userId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.end_time
	 *
	 * @mbggenerated
	 */
	private Date endTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.expend_after_qty
	 *
	 * @mbggenerated
	 */
	private BigDecimal expendAfterQty;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.expend_before_qty
	 *
	 * @mbggenerated
	 */
	private BigDecimal expendBeforeQty;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column manifest_expend.lottery_type_id
	 *
	 * @mbggenerated
	 */
	private Integer lotteryTypeId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.expend_id
	 *
	 * @return the value of manifest_expend.expend_id
	 *
	 * @mbggenerated
	 */
	public Integer getExpendId() {
		return expendId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.expend_id
	 *
	 * @param expendId
	 *            the value for manifest_expend.expend_id
	 *
	 * @mbggenerated
	 */
	public void setExpendId(Integer expendId) {
		this.expendId = expendId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.expend_doc_no
	 *
	 * @return the value of manifest_expend.expend_doc_no
	 *
	 * @mbggenerated
	 */
	public String getExpendDocNo() {
		return expendDocNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.expend_doc_no
	 *
	 * @param expendDocNo
	 *            the value for manifest_expend.expend_doc_no
	 *
	 * @mbggenerated
	 */
	public void setExpendDocNo(String expendDocNo) {
		this.expendDocNo = expendDocNo == null ? null : expendDocNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.create_time
	 *
	 * @return the value of manifest_expend.create_time
	 *
	 * @mbggenerated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.create_time
	 *
	 * @param createTime
	 *            the value for manifest_expend.create_time
	 *
	 * @mbggenerated
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.expend_qty
	 *
	 * @return the value of manifest_expend.expend_qty
	 *
	 * @mbggenerated
	 */
	public BigDecimal getExpendQty() {
		return expendQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.expend_qty
	 *
	 * @param expendQty
	 *            the value for manifest_expend.expend_qty
	 *
	 * @mbggenerated
	 */
	public void setExpendQty(BigDecimal expendQty) {
		this.expendQty = expendQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.status
	 *
	 * @return the value of manifest_expend.status
	 *
	 * @mbggenerated
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.status
	 *
	 * @param status
	 *            the value for manifest_expend.status
	 *
	 * @mbggenerated
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.user_id
	 *
	 * @return the value of manifest_expend.user_id
	 *
	 * @mbggenerated
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.user_id
	 *
	 * @param userId
	 *            the value for manifest_expend.user_id
	 *
	 * @mbggenerated
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.end_time
	 *
	 * @return the value of manifest_expend.end_time
	 *
	 * @mbggenerated
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.end_time
	 *
	 * @param endTime
	 *            the value for manifest_expend.end_time
	 *
	 * @mbggenerated
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.expend_after_qty
	 *
	 * @return the value of manifest_expend.expend_after_qty
	 *
	 * @mbggenerated
	 */
	public BigDecimal getExpendAfterQty() {
		return expendAfterQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.expend_after_qty
	 *
	 * @param expendAfterQty
	 *            the value for manifest_expend.expend_after_qty
	 *
	 * @mbggenerated
	 */
	public void setExpendAfterQty(BigDecimal expendAfterQty) {
		this.expendAfterQty = expendAfterQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.expend_before_qty
	 *
	 * @return the value of manifest_expend.expend_before_qty
	 *
	 * @mbggenerated
	 */
	public BigDecimal getExpendBeforeQty() {
		return expendBeforeQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.expend_before_qty
	 *
	 * @param expendBeforeQty
	 *            the value for manifest_expend.expend_before_qty
	 *
	 * @mbggenerated
	 */
	public void setExpendBeforeQty(BigDecimal expendBeforeQty) {
		this.expendBeforeQty = expendBeforeQty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column manifest_expend.lottery_type_id
	 *
	 * @return the value of manifest_expend.lottery_type_id
	 *
	 * @mbggenerated
	 */
	public Integer getLotteryTypeId() {
		return lotteryTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column manifest_expend.lottery_type_id
	 *
	 * @param lotteryTypeId
	 *            the value for manifest_expend.lottery_type_id
	 *
	 * @mbggenerated
	 */
	public void setLotteryTypeId(Integer lotteryTypeId) {
		this.lotteryTypeId = lotteryTypeId;
	}
}