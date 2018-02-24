package com.skyjoo.neweast.biz.article.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.article.dao.ibatis.SubjectXArticleDAOImpl;
import com.skyjoo.neweast.biz.article.domain.SubjectXArticle;
import com.skyjoo.neweast.biz.article.service.SubjectXArticleService;

@Service
public class SubjectXArticleServiceImpl implements SubjectXArticleService{
	@Autowired
	private SubjectXArticleDAOImpl subjectXArticleDAO;
	
	/**
	 * 新增文章-专题关联
	 * @param subjectXArticle
	 * @return
	 */
	public Long addSubjectXArticle(SubjectXArticle subjectXArticle){
		return subjectXArticleDAO.addSubjectXArticle(subjectXArticle);
	}
	
	/**
	 * 删除文章-专题关联
	 * @param articleId
	 * @return
	 */
	public Integer deleteSubjectXArticle(Long articleId){
		return subjectXArticleDAO.deleteSubjectXArticle(articleId);
	}

    @Override
    public Integer removeSubjectXArticle(Long subjectId) {
        return subjectXArticleDAO.removeSubjectXArticle(subjectId);
    }
}
