/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * @author ywb
 * @version $Id: ArticlStatistic.java,v 0.1 2017年4月25日 下午5:44:48 Administrator Exp $
 */
public class ArticlStatistic extends Pagination<ArticlStatistic> {
    private static final long serialVersionUID = -2301647354158982003L;
    private Long              id;                                       //文章id
    private String            title;                                   //文章标题
    private String            media;                                   //所属媒体
    private String            subject;                                 //所属专题
    private Long              borwseCount;                             //浏览量
    private Long              praiseCount;                             //点赞数
    private Long              commentCount;                            //评论数
    private Date              gtmCreate;                               //创建时间

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getBorwseCount() {
        return borwseCount;
    }

    public void setBorwseCount(Long borwseCount) {
        this.borwseCount = borwseCount;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public Date getGtmCreate() {
        return gtmCreate;
    }

    public void setGtmCreate(Date gtmCreate) {
        this.gtmCreate = gtmCreate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
