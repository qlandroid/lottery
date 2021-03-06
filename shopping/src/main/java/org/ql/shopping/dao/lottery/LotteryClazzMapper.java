package org.ql.shopping.dao.lottery;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ql.shopping.pojo.lottery.LotteryClazz;
import org.ql.shopping.pojo.lottery.LotteryClazzSearch;
import org.ql.shopping.pojo.result.LotteryClazzTree;
import org.ql.shopping.pojo.result.ResultClazzTree;

public interface LotteryClazzMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer lotteryClazzId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int insert(LotteryClazz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int insertSelective(LotteryClazz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	LotteryClazz selectByPrimaryKey(Integer lotteryClazzId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(LotteryClazz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(LotteryClazz record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table lottery_clazz
	 *
	 * @mbggenerated
	 */
	int updateByPrimaryKey(LotteryClazz record);

	/**
	 * 通过父类 的id查询子类的集合
	 * 
	 * @param clazzId
	 * @return
	 */
	List<LotteryClazz> selectChildByParentNameOrId(LotteryClazz record);

	/**
	 * 通过大类的名称和id查询
	 * 
	 * @param record
	 * @return
	 */
	LotteryClazz selectByClazzIdOrName(LotteryClazz record);

	List<LotteryClazz> selectByParentId(@Param("id") Integer id);
}