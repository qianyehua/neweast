package com.skyjoo.neweast.biz.artise.dao.ibatis;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.skyjoo.neweast.biz.artise.dao.ArtiseDAO;
import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.UserFollow;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
@Repository("artiseDAO")
public  class ArtiseDAOImpl extends BaseDaoiBatis implements ArtiseDAO{
    private static String SQLMAP_SPACE = "ARTISE.";
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    @Override
    public void getArtisePage(ArtiseQuery query) {
        
        this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
    }
    @Override
    public void getCheckArtisePage(ArtiseQuery query) {
        
        this.paginate(query, SQLMAP_SPACE + "checkPageCount", SQLMAP_SPACE + "checkPage");
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public Artise getArtiseById(Long artiseId) {
      
        return (Artise) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByartiseId",artiseId);
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public void deleteArtiseById(Long artiseId) {
        this.sqlMapClient.delete(SQLMAP_SPACE+"deleteArtiseById", artiseId); 
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public Long updateArtiseById(Artise artise) {
        return (long) this.sqlMapClient.update(SQLMAP_SPACE+"updateArtiseById", artise);
    }
    
    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<UserFollow> getUserFollowListByUserID(Long userId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getUserFollowListByUserID",userId);
    }
    
    
    

}
