package com.skyjoo.neweast.biz.activity.dao;

import java.util.List;

import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;

public interface ActivityXArtDAO {
	
    /**
     * ���ݻid��ȡ��Ӧ����Ʒ�б�
     * @param activityId
     * @return
     */
	public List<ActivityXArt> getActivityXArt(Long activityId);
	
	/**
	 * ������ӻ-����Ʒ������Ϣ
	 * @param activityXArtList
	 * @return
	 */
	public List<Long> batchInsertActivityXArt(final List<ActivityXArt> activityXArtList);
	
	/**
     * ����idɾ����������Ϣ
     * @param id
     * @return
     */
    public Integer deleteActivityXArt(Long id);
    
    /**
     * ���ݻidɾ��������Ϣ
     * @param id
     * @return
     */
    public Integer deleteByActivityId(Long activityId);
    
    /**
     * ������������
     * @param activityXArtList
     * @return
     */
    public List<Integer> batchEditOrder(final List<ActivityXArt> activityXArtList);
}
