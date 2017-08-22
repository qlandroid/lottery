package org.ql.shopping.dao.manifest;

import java.util.List;

import org.ql.shopping.pojo.manifest.LBiChangeManager;

public interface ILBiChangeManagerDao {
    void deleteById(Long id);

    void insert(LBiChangeManager record);

    void updateById(LBiChangeManager record);

    List<LBiChangeManager> findAnd(LBiChangeManager record);

    List<LBiChangeManager> findOr(LBiChangeManager record);

    Long getTotalCount(LBiChangeManager record);

    Long getTotalCountOr(LBiChangeManager record);
    Long getTotalCountAnd(LBiChangeManager record);
}