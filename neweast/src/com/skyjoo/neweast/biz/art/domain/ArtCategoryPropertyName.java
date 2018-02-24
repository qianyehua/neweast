package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class ArtCategoryPropertyName {
        
    /**
     * pk,seq
     */
    private Long id;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 1-单选，2-多选，3-输入框，4-文本框
     */
    private Integer propertyType;
    /**
     * 操作员
     */
    private String operator;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModify;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(Integer propertyType) {
        this.propertyType = propertyType;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Date getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
    
}
