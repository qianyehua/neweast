package com.skyjoo.neweast.biz.article.service;

import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;

public interface ArticleCommentService {
	/**
	 * ��ȡ���������б�
	 * @param articleAppraiseQuery
	 */
	public void getArticleComment(ArticleCommentQuery  articleCommentQuery);
	/**
	 * ɾ������
	 * @param ids
	 * @return
	 */
	public Integer deleteCommentByIds(Long id);
}
