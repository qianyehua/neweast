package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

/**
 * ��ӦCategory_X_Option�����ݶ���
 * 
 * @author Administrator
 *
 */
public class CategoryOptionDTO {
	private Long id;
	/**
	 * ��ĿID
	 */
	private Long categoryId;
	/**
	 * ѡ��id
	 */
	private Long optionId;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
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

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
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
