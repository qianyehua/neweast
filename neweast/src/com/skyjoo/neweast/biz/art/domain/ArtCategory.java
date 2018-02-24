package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;
import java.util.List;


public class ArtCategory {
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * 上级类目id(一级类目为0)
	 */
	private Long parentId;
	/**
	 * 类目名称
	 */
	private String name;
	/**
	 * 艺术品编号（二级类目才有）
	 */
	private String artCode;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 排序
	 */
	private Integer ordering;
	/**
	 * 类目级别
	 */
	private Integer catLevel;
	/**
	 * 是否已删除 0-正常 1-已删除
	 */
	private Integer isDeleted;
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
	 * 二级类目录属性
	 */
	private List<ArtCategoryProperty> properties;
	/**
	 * 是否可以被删除
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * 是否可以修改前缀
	 */
	private boolean canEditArtCode;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId(){
		return parentId;
	}
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtCode() {
		return artCode;
	}
	public void setArtCode(String artCode){
		this.artCode = artCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public Integer getOrdering(){
		return ordering;
	}
	public void setOrdering(Integer ordering){
		this.ordering = ordering;
	}
	public Integer getCatLevel(){
		return catLevel;
	}
	public void setCatLevel(Integer catLevel){
		this.catLevel = catLevel;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
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
	public void setGmtModify(Date gmtModify){
		this.gmtModify = gmtModify;
	}
	
	public List<ArtCategoryProperty> getProperties() {
		return properties;
	}
	public void setProperties(List<ArtCategoryProperty> properties) {
		this.properties = properties;
	}
	
	/**
	 * 是否是二级类目
	 */
	public boolean isSecondCategory(){
		if(catLevel == 2){
			return true;
		}
		return false;
	}
	
	public boolean getCanDeleted() {
		return canDeleted;
	}
	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
	}
	public boolean isCanEditArtCode() {
		return canEditArtCode;
	}
	public void setCanEditArtCode(boolean canEditArtCode) {
		this.canEditArtCode = canEditArtCode;
	}
	
}
