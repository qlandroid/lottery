package client.service.manifest.impl;

import java.util.List;

import javax.annotation.Resource;

import org.ql.shopping.dao.manifest.ManifestExpendMapper;
import org.springframework.stereotype.Service;

import client.pojo.manifest.ManifestExpendSearch;
import client.service.manifest.IManifestExpendService;

@Service("manifestExpendSearchService")
public class ManifestExpendSearchServiceImpl implements IManifestExpendService {

	@Resource
	private ManifestExpendMapper mManifestExpendMapper;
	
	
	public int createExpendManifest(ManifestExpendSearch params) {
		return mManifestExpendMapper.insertSelectivea(params);
	}

	public int updateExpendManfiest(ManifestExpendSearch params) {
		return mManifestExpendMapper.updateByPrimaryKeySelectivea(params);
	}

	public List<ManifestExpendSearch> selectByStatus(String status) {
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setStatus(status);
		return mManifestExpendMapper.selectByParams(params);
	}

	public List<ManifestExpendSearch> selectByUserId(Integer userId) {
		if(userId == null){
			return null;
		}
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setUserId(userId);
		return mManifestExpendMapper.selectByParams(params);
	}

	public List<ManifestExpendSearch> selectByLotteryTypeId(Integer typeId) {
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setLotteryTypeId(typeId);
		return mManifestExpendMapper.selectByParams(params);
	}

	public ManifestExpendSearch selectByKey(Integer id) {
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setExpendId(id);
		List<ManifestExpendSearch> selectByParams = mManifestExpendMapper.selectByParams(params);
		if(selectByParams == null || selectByParams.size() <= 0){
			return null;
		}
		return selectByParams.get(0);
	}

	public ManifestExpendSearch selectByDocNo(String docNo) {
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setDocNo(docNo);
		List<ManifestExpendSearch> selectByParams = mManifestExpendMapper.selectByParams(params);
		if(selectByParams == null || selectByParams.size() <= 0){
			return null;
		}
		return selectByParams.get(0);
	}

	public ManifestExpendSearch selectByDocNoAndUserId(String docNo,
			Integer userId) {
		
		ManifestExpendSearch params = new ManifestExpendSearch();
		params.setDocNo(docNo);
		params.setUserId(userId);
		ManifestExpendSearch expendManifest = mManifestExpendMapper.selectManifestByDocNoAndUserId(params);
		return expendManifest;
	}


}
