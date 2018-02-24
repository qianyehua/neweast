package com.skyjoo.neweast.biz.subject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.subject.dao.SubjectDAO;
import com.skyjoo.neweast.biz.subject.domain.Subject;
import com.skyjoo.neweast.biz.subject.service.SubjectService;
@Service("subjectService")
public class SubjectServiceImpl  extends BaseManager implements SubjectService{

	@Autowired
	private SubjectDAO subjectDAO;
	@Override
	public Long addsubjectService(Subject subject) {
		
		return subjectDAO.addSubject(subject);
	}
	@Override
	public List<Subject> getSubject() {
	
		return subjectDAO.getSubject();
	}
	@Override
	public Subject searchsbName(String subjectName) {
		return subjectDAO.searchsbName(subjectName);
	}
	@Override
	public Integer updateSubject(Subject subject) {
		return subjectDAO.updateSubject(subject);
	}
	@Override
	public Subject getSubjectById(Long id) {
		return subjectDAO.getSubjectById(id);
	}
	@Override
	public Integer removeSubject(Subject subject) {
		return subjectDAO.removeSubject(subject);
	}
	@Override
	public List<Subject> getSbListByarticleId(Long articleId) {	
		return subjectDAO.getSbListByarticleId(articleId);
	}

}
