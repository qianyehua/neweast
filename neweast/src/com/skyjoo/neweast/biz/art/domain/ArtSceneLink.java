package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

/***
 * ART_SCENE_LINK ����Ʒ������ϵ��
 * @author linzw
 * @version 2016-1-19 14:08:22
 */
public class ArtSceneLink {
	
    /**pk,seq*/
    private Long   id;
    /**����ƷID*/
    private Long   artId;
    /**����ID */
    private Long   sceneId;
    /**������Ӧ��ͼƬ����*/
    private String sceneUrl;
    /**��������*/
    private String description;
    /**����ʱ��*/
    private Date gmtCreate;
    /**����޸�ʱ��*/
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
 
	public Long getSceneId() {
		return sceneId;
	}
	public void setSceneId(Long sceneId) {
		this.sceneId = sceneId;
	}
	public String getSceneUrl() {
		return sceneUrl;
	}
	public void setSceneUrl(String sceneUrl) {
		this.sceneUrl = sceneUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
