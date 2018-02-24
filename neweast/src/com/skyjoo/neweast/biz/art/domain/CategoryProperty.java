package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class CategoryProperty {

    //pk,seq
    private Long id;
    //艺术品二级类目id
    private Long categoryId;
    //属性名称id
    private Long propertyId;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModify;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public Long getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
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
