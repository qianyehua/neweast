package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

public class ArtExt {

	/**
	 * seq,pk
	 */
	private Long id;
	/**
	 * ����Ʒid
	 */
	private Long artId;
	/**
	 * ��������������á�|���ָ�
	 */
	private String attachment;
	/**
	 * ����Ʒ����
	 */
	private String description;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
