package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArtScene extends Pagination<ArtScene> {
	
	private static final long serialVersionUID = 1L;

	/**
	 * pk,seq
	 */
	private Long id;
	
	/**
	 * ��������
	 */
	private String name;
	
	/**
	 * ��������
	 */
	private String description;
	
	/**
	 * ����
	 */
	private Integer ordering;
	
	/**
	 * �Ƿ����
	 */
	private Integer isdisable;
	
	/**
	 *  ����ʱ��
	 */
	private Date gmtCreate;
	
	/**
	 *  �޸�ʱ��
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

	public Integer getIsdisable() {
		return isdisable;
	}

	public void setIsdisable(Integer isdisable) {
		this.isdisable = isdisable;
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
