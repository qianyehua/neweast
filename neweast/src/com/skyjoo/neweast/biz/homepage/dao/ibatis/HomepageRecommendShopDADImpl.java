package com.skyjoo.neweast.biz.homepage.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendShopDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendShop;

@Repository
@SuppressWarnings("deprecation")
public class HomepageRecommendShopDADImpl extends BaseDaoiBatis implements
		HomepageRecommendShopDAO {

	private static String SQLMAP_SPACE = "HOMEPAGE_RECOMMEND_SHOP.";
	
	@Override
	public Long insertHomepageRecommendShop(HomepageRecommendShop recommendShop) {
		return (Long) getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", recommendShop);
	}

	@Override
	public int updateHomepageRecommendShop(HomepageRecommendShop recommendShop) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", recommendShop);
	}

	@Override
	public int selectTotalHomepageRecommendShopCount() {
		return (Integer) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectTotalCount");
	}

	@Override
	public HomepageRecommendShop selectHomepageRecommendShopByShopId(Long shopId) {
		return (HomepageRecommendShop) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByShopId", shopId);
	}

    @Override
    public Integer getRecommendShopByID(Long shopId) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "getRecommendShopByID", shopId);
    }

    @Override
    public void updateRecommendShop(Long shopId) {
        this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateRecommendShop", shopId);
    }

}
