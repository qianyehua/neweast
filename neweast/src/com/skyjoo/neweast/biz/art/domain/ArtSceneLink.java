package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

/***
 * ART_SCENE_LINK 艺术品场景关系表
 * @author linzw
 * @version 2016-1-19 14:08:22
 */
public class ArtSceneLink {
	
    /**pk,seq*/
    private Long   id;
    /**艺术品ID*/
    private Long   artId;
    /**场景ID */
    private Long   sceneId;
    /**场景对应的图片链接*/
    private String sceneUrl;
    /**场景描述*/
    private String description;
    /**创建时间*/
    private Date gmtCreate;
    /**最后修改时间*/
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
