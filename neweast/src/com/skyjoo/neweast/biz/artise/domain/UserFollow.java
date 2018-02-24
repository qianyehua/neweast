package com.skyjoo.neweast.biz.artise.domain;

import java.util.Date;

public class UserFollow {
	// pk,seq
	private Long id;
	// 用户ID
	private Long userId;
	// 被关注人
	private Long objectId;
	// 创建时间
	private Date gmtCreate;
	// 最后修改时间
	private Date gmtModify;
	// 作家ID
	private Long artiseId;

	public Long getArtiseId() {
		return artiseId;
	}

	public void setArtiseId(Long artiseId) {
		this.artiseId = artiseId;
	}

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

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
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
