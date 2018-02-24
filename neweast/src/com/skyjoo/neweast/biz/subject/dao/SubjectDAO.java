package com.skyjoo.neweast.biz.subject.dao;

import java.util.List;

import com.skyjoo.neweast.biz.subject.domain.Subject;

public interface SubjectDAO {
	/**
	 * ���ר��
	 */
	public Long addSubject(Subject subject);
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
	public List<Subject> getSbListByarticleId(Long articleId);
}
