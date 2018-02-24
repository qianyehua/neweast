package com.skyjoo.neweast.biz.article.service;

import com.skyjoo.neweast.biz.article.domain.SubjectXArticle;

public interface SubjectXArticleService {

	/**
	 * 新增文章-专题关联
	 * @param subjectXArticle
	 * @return
	 */
	public Long addSubjectXArticle(SubjectXArticle subjectXArticle);
	
	/**
	 * 删除文章-专题关联
	 * @param articleId
	 * @return
	 */
	public Integer deleteSubjectXArticle(Long articleId);
	 /**
     * 删除专题关联文章
     * @param subjectId
     * @return
     */
    public Integer removeSubjectXArticle(Long subjectId);
}
