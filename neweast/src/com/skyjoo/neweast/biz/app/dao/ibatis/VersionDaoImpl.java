package com.skyjoo.neweast.biz.app.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.app.dao.VersionDAO;
import com.skyjoo.neweast.biz.app.domain.VersionInfo;
@SuppressWarnings("deprecation")
@Repository
public class VersionDaoImpl implements VersionDAO {

	private static final String SQLMAP_SPACE = "VERSION_INFO.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;

	@Override
	public List<VersionInfo> getVersionList() {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getVersionList") ;
	}

	@Override
	public VersionInfo getVersionById(Long id) {
	    return (VersionInfo) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getVersionById",id) ;
	}
	
	@Override
	public Integer updateVersion(VersionInfo versionInfo) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"updateVersion",versionInfo);
	}
}
