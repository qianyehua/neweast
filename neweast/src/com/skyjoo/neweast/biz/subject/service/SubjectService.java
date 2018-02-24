package com.skyjoo.neweast.biz.subject.service;

import java.util.List;

import com.skyjoo.neweast.biz.subject.domain.Subject;


public interface SubjectService {
	/**
	 * ר�����
	 */
	public Long addsubjectService( Subject subject);
	/**
	 * ר���б�
	 */
	public List<Subject> getSubject();
	/**
	 * ��ѯר�����Ƿ����
	 */
	public Subject searchsbName(String subjectName);
	/**
	 * ����ר��
	 */
	public Integer updateSubject(Subject subject);
	/**
	 * ����id��ȡר��
	 */
	public Subject getSubjectById(Long id);
	/**
	 * ר��ɾ��
	 */
	public Integer removeSubject(Subject subject);
	
	/**
	 * ��������id��ȡר���б�
	 */
	public List<Subject> getSbListByarticleId(Long id);
}
