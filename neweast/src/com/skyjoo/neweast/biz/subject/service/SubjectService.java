package com.skyjoo.neweast.biz.subject.service;

import java.util.List;

import com.skyjoo.neweast.biz.subject.domain.Subject;


public interface SubjectService {
	/**
	 * 专题添加
	 */
	public Long addsubjectService( Subject subject);
	/**
	 * 专题列表
	 */
	public List<Subject> getSubject();
	/**
	 * 查询专题名是否存在
	 */
	public Subject searchsbName(String subjectName);
	/**
	 * 更新专题
	 */
	public Integer updateSubject(Subject subject);
	/**
	 * 根据id获取专题
	 */
	public Subject getSubjectById(Long id);
	/**
	 * 专题删除
	 */
	public Integer removeSubject(Subject subject);
	
	/**
	 * 根据文章id获取专题列表
	 */
	public List<Subject> getSbListByarticleId(Long id);
}
