package com.skyjoo.neweast.biz.artise.domain;

import java.util.Date;

public class ArtiseTrend  {

	private static final long serialVersionUID = 1L;

	// pk,seq
	private Long id;
	// 用户ID
	private Long userId;
	// 艺术家ID
	private Long artiseId;
	// 0:入驻 1:发布 2：购买 默认入驻
	private Integer objectType;
	// 类型对象ID
	private Long objectId;
	// 标题
	private String title;
	// 创建时间
	private Date gmtCreate;
	// 最后修改时间
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
