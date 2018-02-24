/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.domain;

import java.io.File;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;
import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxSize;
import org.springmodules.validation.bean.conf.loader.annotation.handler.Size;

import com.hundsun.wudadao.common.DomainBase;

/**
 * @author ywb
 * @version $Id: SubjectMedia.java,v 0.1 2017年4月24日 下午2:33:08 Administrator Exp $
 */
public class SubjectMedia extends DomainBase {
    private Long          id;
    private String        mediaName;
    private String        mediaLogo;
    private MultipartFile logo;
    private int           visitType;
    private Date          gmtCreate;
    private Date          gmtModify;
    private long          count;     //媒体类目下多少文章

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaLogo() {
        return mediaLogo;
    }

    public void setMediaLogo(String mediaLogo) {
        this.mediaLogo = mediaLogo;
    }

    public int getVisitType() {
        return visitType;
    }

    public void setVisitType(int visitType) {
        this.visitType = visitType;
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

    public MultipartFile getLogo() {
        return logo;
    }

    public void setLogo(MultipartFile logo) {
        this.logo = logo;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
