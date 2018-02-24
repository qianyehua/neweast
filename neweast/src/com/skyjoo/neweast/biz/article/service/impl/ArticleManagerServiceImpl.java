/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.biz.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.article.dao.ArticleManagerDao;
import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;
import com.skyjoo.neweast.biz.article.service.ArticleManagerService;
import com.skyjoo.neweast.biz.common.base.BaseManager;

/**
 * @author ywb
 * @version $Id: articleManagerServiceImpl.java,v 0.1 2017年4月25日 下午5:56:06 Administrator Exp $
 */
@Service
public class ArticleManagerServiceImpl extends BaseManager implements ArticleManagerService {

    @Autowired
    private ArticleManagerDao articleManagerDao;

    /**
     * @param articlStatistic
     * @return 
     * @see com.skyjoo.neweast.biz.article.service.ArticleManagerService#getPaginatedStatistic(com.skyjoo.neweast.biz.article.domain.ArticlStatistic)
     */
    @Override
    public List<ArticlStatistic> getPaginatedStatistic(ArticlStatistic articlStatistic) {
        articleManagerDao.getPaginatedStatistic(articlStatistic);
        StringBuffer sb = new StringBuffer();
        if (articlStatistic.getData() != null) {
            for (ArticlStatistic ar : articlStatistic.getData()) {
                List<String> ls = articleManagerDao.getSubjectByArticleId(ar.getId());
                for (int i = 0; i < ls.size(); i++) {
                    if (i != ls.size() - 1) {
                        sb.append(ls.get(i)).append(" | ");
                    } else {
                        sb.append(ls.get(i));
                    }
                }
                ar.setSubject(sb.toString());
                sb.setLength(0);
            }
        }
        return null;
    }

}
