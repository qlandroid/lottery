package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.ManifestLBiChange;
import org.ql.shopping.pojo.manifest.ManifestLBiChangeSearch;

public interface ManifestLBiChangeMapper {
    int deleteByPrimaryKey(Integer changeDocId);

    int insert(ManifestLBiChange record);

    int insertSelective(ManifestLBiChange record);

    ManifestLBiChange selectByPrimaryKey(Integer changeDocId);

    int updateByPrimaryKeySelective(ManifestLBiChange record);

    int updateByPrimaryKeyWithBLOBs(ManifestLBiChange record);

    int updateByPrimaryKey(ManifestLBiChange record);
    
    List<ManifestLBiChangeSearch> selectListPageByParams(ManifestLBiChangeSearch params);

	Integer getListCountByParams(ManifestLBiChangeSearch params);
}