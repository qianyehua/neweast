package com.skyjoo.neweast.biz.article.dao;

import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;

public interface ArticleCommentDAO {
	/**
	 * ��ȡ���������б�
	 * @param articleCommentQuery
	 */
	public void getArticleComment(ArticleCommentQuery  articleCommentQuery);
	/**
	 * ����ɾ��
	 * @param id
	 * @return
	 */
	public Integer deleteCommentByIds(Long id);
}
