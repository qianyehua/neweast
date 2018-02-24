/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.biz.article.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.article.dao.ArticleManagerDao;
import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.SimplePage;

/**
 * @author ywb
 * @version $Id: ArticleManagerDaoIbatic.java,v 0.1 2017年4月25日 下午5:59:05 Administrator Exp $
 */

@Repository
public class ArticleManagerDaoIbatic extends BaseDaoiBatis implements ArticleManagerDao {
    private static final String SPACE = "ARTICLE_STATISTIC.";

    /**
     * 
     * @return 
     * @see com.skyjoo.neweast.biz.article.dao.ArticleManagerDao#getPaginatedScene()
     */
    @Override
    public List<ArticlStatistic> getPaginatedStatistic(ArticlStatistic statistic) {
        this.paginate(statistic, SPACE + "Count", SPACE + "getStatistic");
        return null;
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.article.dao.ArticleManagerDao#getSubjectByArticleId(java.lang.Long)
     */
    @Override
    public List<String> getSubjectByArticleId(Long id) {
        return this.getSqlMapClientTemplate().queryForList(SPACE+"getSubjectById", id);
    }
}
