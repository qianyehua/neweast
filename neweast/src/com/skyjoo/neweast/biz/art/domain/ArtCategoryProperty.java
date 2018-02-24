package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;
import java.util.List;


public class ArtCategoryProperty{
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * ��������
	 */
	private String content;
	/**
	 * ����Ʒ������Ŀid
	 */
	private Long categoryId;
	/**
	 * ����
	 */
	private Integer ordering;
	/**
	 * 1-��ѡ��2-��ѡ��3-�����4-�ı���
	 */
	private Integer propertyType;
	/**
	 * 1-ȫ��,2-˽��
	 */
	private Integer  type;
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
	 * ����ѡ��
	 */
	private List<ArtPropertyOption> options;
	/**
	 * �Ƿ���Ա�ɾ��
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * ����״̬ �Ƿ��ѱ�ɾ��
	 */
//	private Integer isDeleted;
	/**
	 * ������Ŀ����ID
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
	 * �Ƿ���ѡ��������
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
