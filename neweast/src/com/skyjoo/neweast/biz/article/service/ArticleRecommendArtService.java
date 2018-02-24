package com.skyjoo.neweast.biz.article.service;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;

public interface ArticleRecommendArtService {

    /**
     * 文章推广艺术品列表
     */
    public List<ArticleRecommendArt> getRecommendArtByArticleId(Long articleId);
    
    /**
     * 批量插入推广艺术品
     */
    public int batchAddRecomendArts (List<ArticleRecommendArt> arts);
    /**
     * 根据id 获取推广艺术品详情
     * 
     */
    public ArticleRecommendArt getRecommendArt(Long id);
    /**
     * 编辑推广内容
     */
    public Integer editArticleRecommendArt(ArticleRecommendArt articleRecommendArt);
    /**
     * 删除推广艺术品
     */
    public Integer removeRecommendArt(Long id);
    
}
