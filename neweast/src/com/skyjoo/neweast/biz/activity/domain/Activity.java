package com.skyjoo.neweast.biz.activity.domain;

import java.util.Date;
import java.util.List;


public class Activity {
	// seq,pk
	private Long id;
	// �����
	private String name;
	//�����
	private String introduction;
	//�ͼƬ
	private String attachment;
	//�����
	private Integer ordering;
    // ����ʱ��
    private Date gmtCreate;
    // �޸�ʱ��
    private Date gmtModify;
    //�ϴ�ͼƬ�б�
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
