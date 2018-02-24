package com.skyjoo.neweast.biz.subject.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.subject.dao.SubjectDAO;
import com.skyjoo.neweast.biz.subject.domain.Subject;

@Repository
@SuppressWarnings({"deprecation" })
public class SubjectDAOImpl extends BaseDaoiBatis implements SubjectDAO{
	
	private static String SQLMAP_SPACE = "SUBJECT.";
	
	@SuppressWarnings("deprecation")
	@Override
	public Long addSubject(Subject subject) {
		return (Long)this.getSqlMapClientTemplate().insert(SQLMAP_SPACE+"insertSubject", subject);
	}

	@Override
	public List<Subject> getSubject() {		
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getSubject");
	}

	@Override
	public Subject searchsbName(String subjectName) {
		return (Subject)this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE+"searchsbName",subjectName);
	}

	@Override
	public Integer updateSubject(Subject subject) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE+"updateSubject",subject);
	}

	@Override
	public Subject getSubjectById(Long id) {
		return(Subject) this.getSqlMapClientTemplate().
				queryForObject(SQLMAP_SPACE+"getSubjectById",id);
	}

	@Override
	public Integer removeSubject(Subject subject) {
		return  this.getSqlMapClientTemplate().delete(SQLMAP_SPACE+"removeSubject", subject);
	}

	@Override
	public List<Subject> getSbListByarticleId(Long articleId) {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE+"getSbListByarticleId", articleId);
	}

}
