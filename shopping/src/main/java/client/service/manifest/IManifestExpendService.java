package client.service.manifest;

import java.util.List;

import client.pojo.manifest.ManifestExpentSearch;

public interface IManifestExpendService {

	int createExpendManifest(ManifestExpentSearch params);

	int updateExpendManfiest(ManifestExpentSearch params);

	/**
	 * 通过状态值进行查询
	 * 
	 * @param status
	 * @return
	 */
	List<ManifestExpentSearch> selectByStatus(String status);

	/**
	 * 通过用户id进行查询
	 * 
	 * @param userId
	 * @return
	 */
	List<ManifestExpentSearch> selectByUserId(Integer userId);

	/**
	 * 通过彩票类型进行查询
	 * 
	 * @param typeId
	 * @return
	 */
	List<ManifestExpentSearch> selectByLotteryTypeId(Integer typeId);

	/**
	 * 通过主键id进行查询
	 * 
	 * @param id
	 * @return
	 */
	ManifestExpentSearch selectByKey(Integer id);

	/**
	 * 通过单据号进行查询
	 * 
	 * @param docNo
	 * @return
	 */
	ManifestExpentSearch selectByDocNo(String docNo);

}
