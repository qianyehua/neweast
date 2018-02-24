package com.skyjoo.neweast.biz.shop.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopAuthApplyOrgDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApplyOrg;

@Repository
@SuppressWarnings("deprecation")
public class ShopAuthApplyOrgDAOImpl extends BaseDaoiBatis implements ShopAuthApplyOrgDAO {

	private static final String SQLMAP_SPACE = "SHOP_AUTH_APPLY_ORG.";

	@Override
	public ShopAuthApplyOrg selectShopAuthApplyOrgByApplyId(Long applyId) {
		return (ShopAuthApplyOrg) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByApplyId", applyId);
	}

}
