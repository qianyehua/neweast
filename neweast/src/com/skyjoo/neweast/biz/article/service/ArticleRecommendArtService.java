package com.skyjoo.neweast.biz.article.service;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;

public interface ArticleRecommendArtService {

    /**
     * �����ƹ�����Ʒ�б�
     */
    public List<ArticleRecommendArt> getRecommendArtByArticleId(Long articleId);
    
    /**
     * ���������ƹ�����Ʒ
     */
    public int batchAddRecomendArts (List<ArticleRecommendArt> arts);
    /**
     * ����id ��ȡ�ƹ�����Ʒ����
     * 
     */
    public ArticleRecommendArt getRecommendArt(Long id);
    /**
     * �༭�ƹ�����
     */
    public Integer editArticleRecommendArt(ArticleRecommendArt articleRecommendArt);
    /**
     * ɾ���ƹ�����Ʒ
     */
    public Integer removeRecommendArt(Long id);
    
}
