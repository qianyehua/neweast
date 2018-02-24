package com.skyjoo.neweast.biz.shop.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopAuthApplyDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;

@Repository
@SuppressWarnings("deprecation")
public class ShopAuthApplyDAOImpl extends BaseDaoiBatis implements
		ShopAuthApplyDAO {

	private static final String SQLMAP_SPACE = "SHOP_AUTH_APPLY.";
	
	@Override
	public void getShopAuthApplyPage(ShopAuthApplyQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}

	@Override
	public ShopAuthApply selectShopAuthApplyById(Long id) {
		return (ShopAuthApply) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectById", id);
	}

	@Override
	public int updateShopAuthApply(ShopAuthApply apply) {
		return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", apply);
	}

    @Override
    public ShopAuthApply selectShopAuthApplyByLoginId(String loginId) {
        return (ShopAuthApply) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByLoginId", loginId);
    }

    @Override
    public Long insertShopAuthApply(ShopAuthApply apply) {
        return (Long)  this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", apply);
    }

}
