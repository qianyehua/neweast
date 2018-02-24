package com.skyjoo.neweast.biz.artise.domain;

import java.util.Date;

public class ArtiseTrend  {

	private static final long serialVersionUID = 1L;

	// pk,seq
	private Long id;
	// �û�ID
	private Long userId;
	// ������ID
	private Long artiseId;
	// 0:��פ 1:���� 2������ Ĭ����פ
	private Integer objectType;
	// ���Ͷ���ID
	private Long objectId;
	// ����
	private String title;
	// ����ʱ��
	private Date gmtCreate;
	// ����޸�ʱ��
	private Date gmtModify;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getArtiseId() {
		return artiseId;
	}

	public void setArtiseId(Long artiseId) {
		this.artiseId = artiseId;
	}

	public Integer getObjectType() {
		return objectType;
	}

	public void setObjectType(Integer objectType) {
		this.objectType = objectType;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
