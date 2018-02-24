package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class ArtPropertyOption{
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * 选项内容
	 */
	private String content;
	/**
	 * 选项对应的属性
	 */
	private Long PropertyId;
	/**
	 * 艺术品二级类目ID，空为全局属性（每个艺术品都可以选择）
	 */
	private Long categoryId;
	/**
	 * 选项排序
	 */
	private Integer ordering;
	/**
	 * 属性类型 1-单选，2-多选
	 */
	private Integer optionType;
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
	 * 是否可以被删除
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * 选项状态 是否已被删除
	 */
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
	    if (StringUtils.isBlank(content)) {
            this.content=null;
        }
	    else {
	        this.content = content.trim();   
	    }
	}
	public Long getPropertyId() {
		return PropertyId;
	}
	public void setPropertyId(Long propertyId){
		PropertyId = propertyId;
	}
	public Integer getOrdering(){
		return ordering;
	}
	public void setOrdering(Integer ordering){
		this.ordering = ordering;
	}
	public Integer getOptionType() {
		return optionType;
	}
	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
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
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public boolean isCanDeleted() {
		return canDeleted;
	}

	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	 

}
