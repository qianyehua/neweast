package com.skyjoo.neweast.biz.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.article.dao.ArticleCommentDAO;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;
import com.skyjoo.neweast.biz.article.service.ArticleCommentService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
@Service("articleCommentService")
public class ArticleCommentServiceImpl extends BaseManager implements ArticleCommentService{
	@Autowired
	private ArticleCommentDAO articleCommentDAO;
	

	@Override
	public void getArticleComment(ArticleCommentQuery articleCommentQuery) {	
		articleCommentDAO.getArticleComment(articleCommentQuery);
	}


    @Override
    public Integer deleteCommentByIds(Long id) { 
        return articleCommentDAO.deleteCommentByIds(id);
    }

}
