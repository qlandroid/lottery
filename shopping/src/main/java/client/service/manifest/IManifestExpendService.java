package client.service.manifest;

import java.util.List;

import client.pojo.manifest.ManifestExpendSearch;

public interface IManifestExpendService {

	int createExpendManifest(ManifestExpendSearch params);

	int updateExpendManfiest(ManifestExpendSearch params);

	/**
	 * 通过状态值进行查询
	 * 
	 * @param status
	 * @return
	 */
	List<ManifestExpendSearch> selectByStatus(String status);

	/**
	 * 通过用户id进行查询
	 * 
	 * @param userId
	 * @return
	 */
	List<ManifestExpendSearch> selectByUserId(Integer userId);

	/**
	 * 通过彩票类型进行查询
	 * 
	 * @param typeId
	 * @return
	 */
	List<ManifestExpendSearch> selectByLotteryTypeId(Integer typeId);

	/**
	 * 通过主键id进行查询
	 * 
	 * @param id
	 * @return
	 */
	ManifestExpendSearch selectByKey(Integer id);

	/**
	 * 通过单据号进行查询
	 * 
	 * @param docNo
	 * @return
	 */
	ManifestExpendSearch selectByDocNo(String docNo);
	
	ManifestExpendSearch selectByDocNoAndUserId(String docNo,Integer userId);
	
}
