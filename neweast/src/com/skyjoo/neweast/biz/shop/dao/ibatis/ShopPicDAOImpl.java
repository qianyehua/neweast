package com.skyjoo.neweast.biz.shop.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopPicDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopPic;
import com.skyjoo.neweast.biz.shop.domain.query.ShopPicQuery;

@Repository
@SuppressWarnings("deprecation")
public class ShopPicDAOImpl extends BaseDaoiBatis implements ShopPicDAO {

	private static final String SQLMAP_SPACE = "SHOP_PIC.";

	@Override
	public void getShopPicPage(ShopPicQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}

	@Override
	public Integer audit(ShopPic sp) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "audit", sp);
	}
	
}
