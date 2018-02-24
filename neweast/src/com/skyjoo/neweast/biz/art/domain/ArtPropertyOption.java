package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class ArtPropertyOption{
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * ѡ������
	 */
	private String content;
	/**
	 * ѡ���Ӧ������
	 */
	private Long PropertyId;
	/**
	 * ����Ʒ������ĿID����Ϊȫ�����ԣ�ÿ������Ʒ������ѡ��
	 */
	private Long categoryId;
	/**
	 * ѡ������
	 */
	private Integer ordering;
	/**
	 * �������� 1-��ѡ��2-��ѡ
	 */
	private Integer optionType;
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
	 * �Ƿ���Ա�ɾ��
	 * @return
	 */
	private boolean canDeleted;
	/**
	 * ѡ��״̬ �Ƿ��ѱ�ɾ��
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
