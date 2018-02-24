package com.skyjoo.neweast.biz.activity.service;

import java.util.List;

import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;

public interface ActivityXArtService {

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
     * ���ݹ�����idɾ������
     * @param id
     * @return
     */
    public Integer deleteActivityXArt(Long id);
    
    /**
     * ������������
     * @param activityXArtList
     * @return
     */
    public List<Integer> batchEditOrder(final List<ActivityXArt> activityXArtList);
}
