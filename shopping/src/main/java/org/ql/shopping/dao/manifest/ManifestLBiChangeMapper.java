package org.ql.shopping.dao.manifest;

import org.ql.shopping.pojo.manifest.ManifestLBiChange;

public interface ManifestLBiChangeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer changeDocId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int insert(ManifestLBiChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int insertSelective(ManifestLBiChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    ManifestLBiChange selectByPrimaryKey(Integer changeDocId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ManifestLBiChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(ManifestLBiChange record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_l_bi_change
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ManifestLBiChange record);
}