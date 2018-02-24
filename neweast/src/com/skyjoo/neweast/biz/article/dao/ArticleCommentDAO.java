package com.skyjoo.neweast.biz.article.dao;

import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;

public interface ArticleCommentDAO {
	/**
	 * 获取文章评价列表
	 * @param articleCommentQuery
	 */
	public void getArticleComment(ArticleCommentQuery  articleCommentQuery);
	/**
	 * 评论删除
	 * @param id
	 * @return
	 */
	public Integer deleteCommentByIds(Long id);
}
