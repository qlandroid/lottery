package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestIncome;
import org.ql.shopping.pojo.manifest.ManifestIncomeSearch;

public interface ManifestIncomeMapper {
	/**
	 * 通过id进行山出
	 * 
	 * @param incomeId
	 * @return
	 */
	int deleteByPrimaryKey(Integer incomeId);

	/**
	 * 插入数据 全部插入
	 * 
	 * @param record
	 * @return
	 */
	int insert(ManifestIncome record);

	/**
	 * 插入数据 选择插入
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(ManifestIncome record);

	/**
	 * 通过id查询
	 * 
	 * @param incomeId
	 * @return
	 */
	ManifestIncome selectByPrimaryKey(Integer incomeId);

	/**
	 * 不为空的更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(ManifestIncome record);

	/**
	 * 全部更新
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(ManifestIncome record);

	/**
	 * 查询分页，按时间排序
	 * 
	 * @param record
	 * @return
	 */
	public List<ManifestIncomeSearch> searchPageOrderByCreateDate(ManifestIncomeSearch record);

	/**
	 * 获得全部数量
	 * 
	 * @param params
	 * @return
	 */
	public long getSearchPageCount(ManifestIncomeSearch params);
}