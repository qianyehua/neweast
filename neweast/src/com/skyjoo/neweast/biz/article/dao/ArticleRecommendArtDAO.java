package com.skyjoo.neweast.biz.article.dao;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;

public interface ArticleRecommendArtDAO {
    /**
     * �����ƹ�����Ʒ�б�
     */
    public List<ArticleRecommendArt> getRecommendArtByArticleId(Long articleId);
    /**
     * ��������
     */
    public List<Long> batchInsertRecommendArt(List<ArticleRecommendArt>  Recommendarts);
    
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
