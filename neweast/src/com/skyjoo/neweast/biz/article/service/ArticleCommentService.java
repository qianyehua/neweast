package com.skyjoo.neweast.biz.article.service;

import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;

public interface ArticleCommentService {
	/**
	 * 获取文章评论列表
	 * @param articleAppraiseQuery
	 */
	public void getArticleComment(ArticleCommentQuery  articleCommentQuery);
	/**
	 * 删除评论
	 * @param ids
	 * @return
	 */
	public Integer deleteCommentByIds(Long id);
}
