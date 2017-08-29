package client.service.manifest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestExpendMapper;

import client.pojo.manifest.ManifestExpentSearch;
import client.service.manifest.IManifestExpendService;

public class ManifestExpendSearchServiceImpl implements IManifestExpendService {

	@Resource
	private ManifestExpendMapper mManifestExpendMapper;
	
	
	public int createExpendManifest(ManifestExpentSearch params) {
		return mManifestExpendMapper.insertSelective(params);
	}

	public int updateExpendManfiest(ManifestExpentSearch params) {
		return mManifestExpendMapper.updateByPrimaryKeySelective(params);
	}

	public List<ManifestExpentSearch> selectByStatus(String status) {
		ManifestExpentSearch params = new ManifestExpentSearch();
		params.setStatus(status);
		return mManifestExpendMapper.selectByParams(params);
	}

	public List<ManifestExpentSearch> selectByUserId(Integer userId) {
		if(userId == null){
			return null;
		}
		ManifestExpentSearch params = new ManifestExpentSearch();
		params.setUserId(userId);
		return mManifestExpendMapper.selectByParams(params);
	}

	public List<ManifestExpentSearch> selectByLotteryTypeId(Integer typeId) {
		ManifestExpentSearch params = new ManifestExpentSearch();
		params.setLotteryTypeId(typeId);
		return mManifestExpendMapper.selectByParams(params);
	}

	public ManifestExpentSearch selectByKey(Integer id) {
		ManifestExpentSearch params = new ManifestExpentSearch();
		params.setExpendId(id);
		List<ManifestExpentSearch> selectByParams = mManifestExpendMapper.selectByParams(params);
		if(selectByParams == null || selectByParams.size() <= 0){
			return null;
		}
		return selectByParams.get(0);
	}

	public ManifestExpentSearch selectByDocNo(String docNo) {
		ManifestExpentSearch params = new ManifestExpentSearch();
		params.setDocNo(docNo);
		List<ManifestExpentSearch> selectByParams = mManifestExpendMapper.selectByParams(params);
		if(selectByParams == null || selectByParams.size() <= 0){
			return null;
		}
		return selectByParams.get(0);
	}

}
