package com.skyjoo.neweast.biz.activity.dao;

import java.util.List;

import com.skyjoo.neweast.biz.activity.domain.Activity;

public interface ActivityDAO {
	
    /**
     * �������ƻ�ȡ��б�
     * ����Ϊ�շ���ȫ��
     * @param name
     * @return
     */
	public List<Activity> getActivityList(String actName);
	
	/**
	 * ����id��ȡ�
	 * @param id
	 * @return
	 */
	public Activity getActivityById(Long id);
	
	/**
	 * �����
	 * @param activity
	 * @return
	 */
	public Long addActivity(Activity activity);
	
	/**
	 * ���»��Ϣ
	 * @param activity
	 * @return
	 */
	public Integer updateActivity(Activity activity);
	
	/**
	 * ����idɾ���
	 * @param id
	 * @return
	 */
	public Integer deleteActivity(Long id);
}
