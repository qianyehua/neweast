/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��25��
 */
package com.skyjoo.neweast.biz.article.service;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;

/**
 * @author ywb
 * @version $Id: articleManagerService.java,v 0.1 2017��4��25�� ����5:31:29 Administrator Exp $
 */
public interface ArticleManagerService {
    //��ҳ��ȡ����ͳ���б�
    public List<ArticlStatistic> getPaginatedStatistic(ArticlStatistic articlStatistic);
}
