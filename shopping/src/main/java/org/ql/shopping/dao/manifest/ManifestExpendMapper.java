package org.ql.shopping.dao.manifest;

import org.ql.shopping.pojo.manifest.ManifestExpend;

public interface ManifestExpendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer expendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    int insert(ManifestExpend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    int insertSelective(ManifestExpend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    ManifestExpend selectByPrimaryKey(Integer expendId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ManifestExpend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manifest_expend
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ManifestExpend record);
}