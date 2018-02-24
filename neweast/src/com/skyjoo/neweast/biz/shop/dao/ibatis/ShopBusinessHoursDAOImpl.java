package com.skyjoo.neweast.biz.shop.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopBusinessHoursDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopBusinessHours;

@Repository
@SuppressWarnings("deprecation")
public class ShopBusinessHoursDAOImpl extends BaseDaoiBatis implements
		ShopBusinessHoursDAO {

	private static final String SQLMAP_SPACE = "SHOP_BUSINESS_HOURS.";

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopBusinessHours> selectShopBusinessHoursByShopId(Long shopId) {
		return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE + "selectByShopId", shopId);
	}

    @Override
    public int deleteShopBusinessHoursByShopId(Long shopId) {
        return getSqlMapClientTemplate().delete(SQLMAP_SPACE + "deleteByShopId", shopId);
    }

}
