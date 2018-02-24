package com.skyjoo.neweast.biz.datadic.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.datadic.dao.CommDatadicDAO;
import com.skyjoo.neweast.biz.datadic.domain.CommDatadic;

@Repository
@SuppressWarnings({"deprecation" })
public class CommDatadicDAOImpl extends BaseDaoiBatis implements CommDatadicDAO {

	private static String SQLMAP_SPACE = "COMM_DATADIC.";


	@SuppressWarnings("unchecked")
	@Override
	public List<CommDatadic> getAllCommDatadics() {
		return this.getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "getAll");
	}
}
