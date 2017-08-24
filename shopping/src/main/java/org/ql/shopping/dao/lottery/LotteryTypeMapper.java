package org.ql.shopping.dao.lottery;

import java.util.List;

import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.lottery.LotteryType;
import org.ql.shopping.pojo.lottery.LotteryTypeWithBLOBs;

public interface LotteryTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer lotteryTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int insert(LotteryTypeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int insertSelective(LotteryTypeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    LotteryTypeWithBLOBs selectByPrimaryKey(Integer lotteryTypeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(LotteryTypeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(LotteryTypeWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lottery_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(LotteryType record);
    
    
    /**
     * 通过TypeOrClazzId进行查询
     * @param record
     * @return
     */
    List<LotteryTypeWithBLOBs> selectByClazzTypeOrClazzId(LotteryClazzSearch record);
    
    
}