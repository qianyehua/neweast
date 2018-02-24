package com.skyjoo.neweast.biz.activity.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.activity.dao.ActivityXArtDAO;
import com.skyjoo.neweast.biz.activity.domain.Activity;
import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;
import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;

@Repository
@SuppressWarnings("deprecation")
public class ActivityXArtDaoImpl implements ActivityXArtDAO {
    private static final String SQLMAP_SPACE = "ACTIVITY_X_ART.";
    
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    
    @Override
    public List<ActivityXArt> getActivityXArt(Long activityId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getActivityXArt",activityId);
    }
    
    @Override
    public List<Long> batchInsertActivityXArt(final List<ActivityXArt> activityXArtList) {
        return this.sqlMapClient.execute(new SqlMapClientCallback<List<Long>>() {
            
            @Override
            public List<Long> doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                List<Long> ids = new ArrayList<Long>();
                executor.startBatch();
                for (ActivityXArt axa : activityXArtList) {
                    ids.add((Long) executor.insert(SQLMAP_SPACE + "insert", axa));
                }
                executor.executeBatch();
                return ids;
            }
        });
       
    }
    
    @Override
    public Integer deleteActivityXArt(Long id) {
        return (Integer) this.sqlMapClient.delete(SQLMAP_SPACE + "deleteActivityXArt", id);
    }
    
    @Override
    public Integer deleteByActivityId(Long activityId){
        return (Integer) this.sqlMapClient.delete(SQLMAP_SPACE + "deleteByActivityId", activityId);
    }
    
    @Override
    public List<Integer> batchEditOrder(final List<ActivityXArt> activityXArtList) {
        return this.sqlMapClient.execute(new SqlMapClientCallback<List<Integer>>() {
            
            @Override
            public List<Integer> doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                List<Integer> ids = new ArrayList<Integer>();
                executor.startBatch();
                for (ActivityXArt axa : activityXArtList) {
                    ids.add((Integer) executor.update(SQLMAP_SPACE + "updateOrder", axa));
                }
                executor.executeBatch();
                return ids;
            }
        });
       
    }
}
