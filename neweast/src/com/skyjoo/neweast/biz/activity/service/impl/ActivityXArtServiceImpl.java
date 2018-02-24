package com.skyjoo.neweast.biz.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.activity.dao.ActivityXArtDAO;
import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;
import com.skyjoo.neweast.biz.activity.service.ActivityXArtService;

@Service
public class ActivityXArtServiceImpl implements ActivityXArtService {
    @Autowired
    private ActivityXArtDAO activityXArtDao;

    @Override
    public List<ActivityXArt> getActivityXArt(Long activityId) {
        return activityXArtDao.getActivityXArt(activityId);
    }
    
    @Override
    public List<Long> batchInsertActivityXArt(final List<ActivityXArt> activityXArtList) {
        return activityXArtDao.batchInsertActivityXArt(activityXArtList);
    }
    
    @Override
    public Integer deleteActivityXArt(Long id){
        return activityXArtDao.deleteActivityXArt(id);
    }
    
    @Override
    public List<Integer> batchEditOrder(final List<ActivityXArt> activityXArtList){
        return activityXArtDao.batchEditOrder(activityXArtList);
    }
}
