package com.skyjoo.neweast.biz.activity.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.art.domain.Art;


public class ActivityXArt extends Art{
	// seq,pk
	private Long id;
	// �id
	private Long activityId;
	//����Ʒid
	private Long artId;
	//����
	private Integer ordering;
	//����ʱ��
	private Date gmtCreate;
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
    public Long getArtId() {
        return artId;
    }
    public void setArtId(Long artId) {
        this.artId = artId;
    }
    public Integer getOrdering() {
        return ordering;
    }
    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }
    public Date getGmtCreate() {
        return gmtCreate;
    }
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
