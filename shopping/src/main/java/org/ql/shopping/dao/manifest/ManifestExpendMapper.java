package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestExpend;
import org.ql.shopping.pojo.manifest.ManifestExpendSs;

import client.pojo.manifest.ManifestExpendSearch;

public interface ManifestExpendMapper {
    int deleteByPrimaryKeya(Integer expendId);

    int inserta(ManifestExpend record);

    int insertSelectivea(ManifestExpend record);

    ManifestExpend selectByPrimaryKeya(Integer expendId);

    int updateByPrimaryKeySelectivea(ManifestExpend record);

    int updateByPrimaryKeya(ManifestExpend record);

	List<ManifestExpendSearch> selectByParams(ManifestExpendSearch params);
	
	ManifestExpendSearch selectManifestByDocNoAndUserId(ManifestExpendSearch params);
	
	List<ManifestExpendSs> selectDetailsListPageByParams(ManifestExpendSs params);

	Integer getListCountByParams(ManifestExpendSs params);
}