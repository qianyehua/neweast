/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.biz.article.dao;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;

/**
 * @author ywb
 * @version $Id: ArticleManagerDao.java,v 0.1 2017年4月25日 下午5:58:21 Administrator Exp $
 */
public interface ArticleManagerDao {
    //分页获取数据统计列表
    public List<ArticlStatistic> getPaginatedStatistic(ArticlStatistic statistic);

    //根据文章id查找专题
    public List<String> getSubjectByArticleId(Long id);
}
