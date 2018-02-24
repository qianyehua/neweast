package com.skyjoo.neweast.biz.homepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendArtiseDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendArtiseService;

@Service("homepageRecommendArtiseService")
public class HomepageRecommendArtiseServiceImpl extends BaseManager implements HomepageRecommendArtiseService{
    @Autowired
    private HomepageRecommendArtiseDAO homepageRecommendArtiseDAO;    
    
    @Override
    public Long addHomepageRecommendArtise(HomepageRecommendArtise homepageRecommendArtise) {
        // TODO Auto-generated method stub
        return homepageRecommendArtiseDAO.addHomepageRecommendArtise(homepageRecommendArtise);
    }

    @Override
    public int getHomepageRecommendArtiseStatusById(Long artiseId) {
        // TODO Auto-generated method stub
        return homepageRecommendArtiseDAO.getHomepageRecommendArtiseStatusById(artiseId);
    }

    @Override
    public int updataHomepageRecommendArtiseStatusById(HomepageRecommendArtise homepageRecommendArtise) {
        // TODO Auto-generated method stub
        return homepageRecommendArtiseDAO.updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
    }

   
    

}
