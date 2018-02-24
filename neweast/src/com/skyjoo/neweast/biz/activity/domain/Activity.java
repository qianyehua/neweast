package com.skyjoo.neweast.biz.activity.domain;

import java.util.Date;
import java.util.List;


public class Activity {
	// seq,pk
	private Long id;
	// 活动名称
	private String name;
	//活动描述
	private String introduction;
	//活动图片
	private String attachment;
	//活动排序
	private Integer ordering;
    // 创建时间
    private Date gmtCreate;
    // 修改时间
    private Date gmtModify;
    //上传图片列表
    private List<String> imgList;
    
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
    public String getIntroduction() {
        return introduction;
    }
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public String getAttachment() {
        return attachment;
    }
    public void setAttachment(String attachment) {
        this.attachment = attachment;
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
    public Date getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
    public List<String> getImgList() {
        return imgList;
    }
    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
