package com.skyjoo.neweast.biz.article.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.article.dao.SubjectXArticleDAO;
import com.skyjoo.neweast.biz.article.domain.SubjectXArticle;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@SuppressWarnings("deprecation")
@Repository
public class SubjectXArticleDAOImpl extends BaseDaoiBatis implements SubjectXArticleDAO{
	private static final String SQLMAP_SPACE = "SUBJECT_X_ARTICLE.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	
	@Override
	public Long addSubjectXArticle(SubjectXArticle subjectXArticle){
		 return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "addSubjectXArticle", subjectXArticle);
	}
	
	@Override
	public Integer deleteSubjectXArticle(Long articleId){
		 return (Integer) this.getSqlMapClientTemplate().delete(SQLMAP_SPACE + "deleteSubjectXArticle", articleId);
	}

    @Override
    public Integer removeSubjectXArticle(Long subjectId) {
        return (Integer) this.getSqlMapClientTemplate().delete(SQLMAP_SPACE + "removeSubjectXArticle", subjectId);
    }
}
