package com.skyjoo.neweast.biz.activity.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.activity.dao.ActivityDAO;
import com.skyjoo.neweast.biz.activity.domain.Activity;

@Repository
@SuppressWarnings("deprecation")
public class ActivityDaoImpl implements ActivityDAO {
    private static final String SQLMAP_SPACE = "ACTIVITY.";
    
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    
    @Override
    public List<Activity> getActivityList(String actName) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getActivityList",actName);
    }

    @Override
    public Activity getActivityById(Long id){
        return (Activity) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getActivityById",id);
    }
    
    @Override
    public Long addActivity(Activity activity) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE + "addActivity", activity);
    }

    @Override
    public Integer updateActivity(Activity activity) {
        return (Integer) this.sqlMapClient.update(SQLMAP_SPACE + "updateActivity", activity);
    }

    @Override
    public Integer deleteActivity(Long id) {
        return (Integer) this.sqlMapClient.delete(SQLMAP_SPACE + "deleteActivity", id);
    }

}
