package com.skyjoo.neweast.biz.activity.service;

import java.util.List;

import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;

public interface ActivityXArtService {

    /**
     * 根据活动id获取对应艺术品列表
     * @param activityId
     * @return
     */
    public List<ActivityXArt> getActivityXArt(Long activityId);
    
    /**
     * 批量添加活动-艺术品关联信息
     * @param activityXArtList
     * @return
     */
    public List<Long> batchInsertActivityXArt(final List<ActivityXArt> activityXArtList);
    
    /**
     * 根据关联表id删除数据
     * @param id
     * @return
     */
    public Integer deleteActivityXArt(Long id);
    
    /**
     * 批量更新排序
     * @param activityXArtList
     * @return
     */
    public List<Integer> batchEditOrder(final List<ActivityXArt> activityXArtList);
}
