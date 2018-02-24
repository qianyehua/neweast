package com.skyjoo.neweast.biz.artise.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArtiseRecord extends Pagination<ArtiseRecord>{
    
	private static final long serialVersionUID = 1L;
	// pk,seq
	private Long id;
	// �û�ID
	private Long userId;
	// ������ID
	private Long artiseId;
	// ��ʼʱ��
	private String startTime;
	// ����ʱ��
	private String endTime;
	// ����
	private String content;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
