package com.skyjoo.neweast.biz.article.dao;

import com.skyjoo.neweast.biz.article.domain.SubjectXArticle;

public interface SubjectXArticleDAO {
	/**
	 * ��������-ר�����
	 * @param subjectXArticle
	 * @return
	 */
	public Long addSubjectXArticle(SubjectXArticle subjectXArticle);
	
	/**
	 * ɾ������-ר�����
	 * @param articleId
	 * @return
	 */
	public Integer deleteSubjectXArticle(Long articleId);
	/**
	 * ɾ��ר���������
	 * @param subjectId
	 * @return
	 */
	public Integer removeSubjectXArticle(Long subjectId);
}
