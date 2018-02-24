package com.skyjoo.neweast.biz.article.dao;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface ArticleDAO {
	/**
	 * ��ҳ��ѯ,�õ�ȫ������
	 * @param page
	 * @return
	 */
	public Paginable<ArticleCheckQuery> getPaginategArticle(Paginable<ArticleCheckQuery> page);
	
	/**
	 * ���´���
	 * @param article
	 * @return
	 */
	public Long addArticle(Article article);
	/**
	 * ����id��ȡ��������
	 * @param id
	 * @return
	 */
	public Article getArticleById(Long id);
	/**
	 * ����ɾ������
	 * @param ids
	 * @return
	 */
	public Integer deleteArticleByIds(String[] ids);
	
	/**
	 * ���±༭
	 * @param article
	 * @return
	 */
	public Integer updateArticle(Article article);
    /**
     * ����ר��id��ѯ����������Ŀ
     * @param subjectId
     * @return
     */
    public Integer  getArticleCount(Long subjectId);
    /**
     * ��������id��������������
     * @param id
     * @return
     */
    public Integer updateCommentCount(Long  id);
    /**
     * ɾ����ר������������
     * @param subjectId
     * @return
     */
    public Integer removeArticleBysubjectId(Long subjectId);
}
