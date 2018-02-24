package com.skyjoo.neweast.biz.artise.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.artise.dao.ArtiseTrendDAO;
import com.skyjoo.neweast.biz.artise.domain.ArtiseTrend;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@Repository
public class ArtiseTrendDAOImpl extends BaseDaoiBatis implements ArtiseTrendDAO {
	private static final String SQLMAP_SPACE = "ARTISE_TREND.";

	   
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
	
    @Override
    public Long inserAtriseTrend(ArtiseTrend artiseTrend) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"insertTrend", artiseTrend);
    }

    @Override
    public int getArtiseTrendCount(Long artId) {
        return (int) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtiseTrendCount",artId);
    }

}
