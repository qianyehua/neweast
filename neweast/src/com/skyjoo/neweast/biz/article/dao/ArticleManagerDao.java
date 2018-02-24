/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��25��
 */
package com.skyjoo.neweast.biz.article.dao;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;

/**
 * @author ywb
 * @version $Id: ArticleManagerDao.java,v 0.1 2017��4��25�� ����5:58:21 Administrator Exp $
 */
public interface ArticleManagerDao {
    //��ҳ��ȡ����ͳ���б�
    public List<ArticlStatistic> getPaginatedStatistic(ArticlStatistic statistic);

    //��������id����ר��
    public List<String> getSubjectByArticleId(Long id);
}
