package com.gxp.model;

public class GxpNameAge {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gxp_name_age.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gxp_name_age.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column gxp_name_age.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gxp_name_age.id
     *
     * @return the value of gxp_name_age.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gxp_name_age.id
     *
     * @param id the value for gxp_name_age.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gxp_name_age.name
     *
     * @return the value of gxp_name_age.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gxp_name_age.name
     *
     * @param name the value for gxp_name_age.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column gxp_name_age.age
     *
     * @return the value of gxp_name_age.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column gxp_name_age.age
     *
     * @param age the value for gxp_name_age.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}