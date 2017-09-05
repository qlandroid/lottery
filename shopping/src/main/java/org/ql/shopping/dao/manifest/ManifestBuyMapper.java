package org.ql.shopping.dao.manifest;

import org.ql.shopping.pojo.manifest.ManifestBuy;

public interface ManifestBuyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ManifestBuy record);

    int insertSelective(ManifestBuy record);

    ManifestBuy selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ManifestBuy record);

    int updateByPrimaryKey(ManifestBuy record);
    
    
}