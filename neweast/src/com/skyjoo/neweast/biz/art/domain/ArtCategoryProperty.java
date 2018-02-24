package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;
import java.util.List;


public class ArtCategoryProperty{
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * 属性内容
	 */
	private String content;
	/**
	 * 艺术品二级类目id
	 */
	private Long categoryId;
	/**
	 * 排序
	 */
	private Integer ordering;
	/**
	 * 1-单选，2-多选，3-输入框，4-文本框
	 */
	private Integer propertyType;
	/**
	 * 1-全局,2-私有
	 */
	private Integer  type;
	/**
	 * 操作员
	 */
	private String operator;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 最后修改时间
	 */
	private Date gmtModify;
	/**
	 * 属性选项
	 */
	private List<ArtPropertyOption> options;
	/**
	 * 是否可以被删除
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * 属性状态 是否已被删除
	 */
//	private Integer isDeleted;
	/**
	 * 属性类目名称ID
	 * @return
	 */
	private Long propertyNameId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	public Integer getOrdering() {
		return ordering;
	}
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
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
	public void setOperator(String operator){
		this.operator = operator;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;
	}
	
	public List<ArtPropertyOption> getOptions(){
		return options;
	}
	public void setOptions(List<ArtPropertyOption> options) {
		this.options = options;
	}
	/**
	 * 是否是选择类属性
	 */
	public boolean isSelectProperty(){
		if(propertyType == 1 || propertyType == 2){
			return true;
		}
		return false;
	}
	public boolean isCanDeleted() {
		return canDeleted;
	}
	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
	}

    //	public Integer getIsDeleted() {
    //		return isDeleted;
    //	}
    //	public void setIsDeleted(Integer isDeleted) {
    //		this.isDeleted = isDeleted;
    //	}
    public Long getPropertyNameId() {
        return propertyNameId;
    }
    public void setPropertyNameId(Long propertyNameId) {
        this.propertyNameId = propertyNameId;
    }
    public Integer getType() {
        return type;
    }
    public void setType(Integer type) {
        this.type = type;
    }
	
}
