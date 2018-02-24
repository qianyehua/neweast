package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;
import java.util.List;


public class ArtCategory {
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * �ϼ���Ŀid(һ����ĿΪ0)
	 */
	private Long parentId;
	/**
	 * ��Ŀ����
	 */
	private String name;
	/**
	 * ����Ʒ��ţ�������Ŀ���У�
	 */
	private String artCode;
	/**
	 * ����
	 */
	private String description;
	/**
	 * ����
	 */
	private Integer ordering;
	/**
	 * ��Ŀ����
	 */
	private Integer catLevel;
	/**
	 * �Ƿ���ɾ�� 0-���� 1-��ɾ��
	 */
	private Integer isDeleted;
	/**
	 * ����Ա
	 */
	private String operator;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
	private Date gmtModify;
	/**
	 * ������Ŀ¼����
	 */
	private List<ArtCategoryProperty> properties;
	/**
	 * �Ƿ���Ա�ɾ��
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * �Ƿ�����޸�ǰ׺
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
	 * �Ƿ��Ƕ�����Ŀ
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
