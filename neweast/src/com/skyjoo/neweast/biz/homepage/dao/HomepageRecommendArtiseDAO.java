package com.skyjoo.neweast.biz.homepage.dao;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;

public interface HomepageRecommendArtiseDAO {

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
