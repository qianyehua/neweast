package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;

public interface HomepageRecommendArtiseService {

      /**
       * �����Ƽ�������
       */
     public Long addHomepageRecommendArtise(HomepageRecommendArtise homepageRecommendArtise);
     /**
      * ����ID��ѯ�Ƽ�������״̬
      */
     public  int getHomepageRecommendArtiseStatusById(Long artiseId);
     /**
      * ����id������������Ϣ
      */
     public int updataHomepageRecommendArtiseStatusById(HomepageRecommendArtise homepageRecommendArtise);
}
