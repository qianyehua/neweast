package com.skyjoo.neweast.biz.homepage.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendArtiseDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;

@Repository("homepageRecommendArtiseDAO")
public class HomepageRecommendArtiseDAOImpl extends BaseDaoiBatis implements HomepageRecommendArtiseDAO {
    private static String SQLMAP_SPACE = "HOMEPAGE_RECOMMEND_ARTISE.";
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    
    @Override
    public Long addHomepageRecommendArtise(HomepageRecommendArtise homepageRecommendArtise) {
       
        return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insertHomepageRecommendArtise",
            homepageRecommendArtise);
    }

 
    @Override
    public int getHomepageRecommendArtiseStatusById(Long artiseId) {
        int status=0;
        Long  at=(Long) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectHomepageRecommendArtiseStatusById", artiseId);
       if (at==null) {
           status=0;
           
       }
     else{
      if(at>0)
      {status=1;
      }
      if(at<0) {
        status=-1;
    }
       }
      return status;
    }


    @Override
    public int updataHomepageRecommendArtiseStatusById(HomepageRecommendArtise homepageRecommendArtise) {
        // TODO Auto-generated method stub
        return this.sqlMapClient.update(SQLMAP_SPACE+"updateHomepageRecommendArtiseById", homepageRecommendArtise);
    }
    
 
}
