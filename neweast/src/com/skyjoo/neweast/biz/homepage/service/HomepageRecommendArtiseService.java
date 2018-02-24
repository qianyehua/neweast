package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;

public interface HomepageRecommendArtiseService {

      /**
       * 增加推荐艺术家
       */
     public Long addHomepageRecommendArtise(HomepageRecommendArtise homepageRecommendArtise);
     /**
      * 根据ID查询推荐艺术家状态
      */
     public  int getHomepageRecommendArtiseStatusById(Long artiseId);
     /**
      * 根据id更新艺术家信息
      */
     public int updataHomepageRecommendArtiseStatusById(HomepageRecommendArtise homepageRecommendArtise);
}
