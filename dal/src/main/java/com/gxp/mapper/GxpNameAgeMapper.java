package com.gxp.mapper;

import com.gxp.model.GxpNameAge;

public interface GxpNameAgeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    int insert(GxpNameAge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    int insertSelective(GxpNameAge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    GxpNameAge selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GxpNameAge record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gxp_name_age
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GxpNameAge record);
}