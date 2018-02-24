package com.skyjoo.neweast.biz.artise.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.artise.dao.ArtiseRecordDAO;
import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@Repository
public class ArtiseRecordDAOImpl extends BaseDaoiBatis implements ArtiseRecordDAO {
	private static final String SQLMAP_SPACE = "ARTISE_RECORD.";
	
    @Autowired
    private SqlMapClientTemplate sqlMapClient;

    @SuppressWarnings({ "deprecation", "unchecked" })
    @Override
    public List<ArtiseRecord> getRecordList(Artise artise) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"queryList", artise);
    }


}
