package com.skyjoo.neweast.biz.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.article.dao.ArticleRecommendArtDAO;
import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;
import com.skyjoo.neweast.biz.article.service.ArticleRecommendArtService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
@Service("articleRecommendArtService")
public class ArticleRecommendArtServiceImpl  extends BaseManager implements  ArticleRecommendArtService {
    @Autowired
    private ArticleRecommendArtDAO articleRecommendArtDAO;
  
    @Override
    public List<ArticleRecommendArt> getRecommendArtByArticleId(Long articleId) {
        return articleRecommendArtDAO.getRecommendArtByArticleId(articleId);
    }

    @Override
    public int batchAddRecomendArts(List<ArticleRecommendArt> RecommendArts) {
        
        articleRecommendArtDAO.batchInsertRecommendArt(RecommendArts);
        return 0;
     
    }

    @Override
    public ArticleRecommendArt getRecommendArt(Long id) {
        return articleRecommendArtDAO.getRecommendArt(id);
    }

    @Override
    public Integer editArticleRecommendArt(ArticleRecommendArt articleRecommendArt) {
        return articleRecommendArtDAO.editArticleRecommendArt(articleRecommendArt);
    }

    @Override
    public Integer removeRecommendArt(Long id) {
        return articleRecommendArtDAO.removeRecommendArt(id);
    }

  
  
    

}
