package com.skyjoo.neweast.biz.activity.dao;

import java.util.List;

import com.skyjoo.neweast.biz.activity.domain.Activity;

public interface ActivityDAO {
	
    /**
     * 根据名称获取活动列表
     * 名称为空返回全部
     * @param name
     * @return
     */
	public List<Activity> getActivityList(String actName);
	
	/**
	 * 根据id获取活动
	 * @param id
	 * @return
	 */
	public Activity getActivityById(Long id);
	
	/**
	 * 新增活动
	 * @param activity
	 * @return
	 */
	public Long addActivity(Activity activity);
	
	/**
	 * 更新活动信息
	 * @param activity
	 * @return
	 */
	public Integer updateActivity(Activity activity);
	
	/**
	 * 根据id删除活动
	 * @param id
	 * @return
	 */
	public Integer deleteActivity(Long id);
}
