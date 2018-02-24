package com.skyjoo.neweast.biz.trade.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.trade.dao.SalesVolumeDAO;
import com.skyjoo.neweast.biz.trade.domain.SalesVolume;

@Repository
@SuppressWarnings("deprecation")
public class SalesVolumeDAOImpl extends BaseDaoiBatis implements SalesVolumeDAO {

	private static final String SQLMAP_SPACE = "SALES_VOLUME.";
 
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesVolume> groupSalesVolumeByShopAndCategory(String startDate, String endDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "groupByShopAndCategory", map);
	}

	@Override
	public void dealMoveToHis(String beforeStartDate) {
		getSqlMapClientTemplate().insert(SQLMAP_SPACE + "dealMoveToHis", beforeStartDate);
	}

	@Override
	public void deleteAfterMove(String beforeStartDate) {
		getSqlMapClientTemplate().delete(SQLMAP_SPACE + "deleteAfterMove", beforeStartDate);
	}

}
