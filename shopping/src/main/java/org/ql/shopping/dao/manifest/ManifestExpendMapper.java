package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestExpend;

import client.pojo.manifest.ManifestExpendSearch;

public interface ManifestExpendMapper {
    int deleteByPrimaryKey(Integer expendId);

    int insert(ManifestExpend record);

    int insertSelective(ManifestExpend record);

    ManifestExpend selectByPrimaryKey(Integer expendId);

    int updateByPrimaryKeySelective(ManifestExpend record);

    int updateByPrimaryKey(ManifestExpend record);

	List<ManifestExpendSearch> selectByParams(ManifestExpendSearch params);
}