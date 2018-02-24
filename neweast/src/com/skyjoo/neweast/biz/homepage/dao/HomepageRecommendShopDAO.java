package com.skyjoo.neweast.biz.homepage.dao;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendShop;

public interface HomepageRecommendShopDAO {

	public Long insertHomepageRecommendShop(HomepageRecommendShop recommendShop);
	
	public HomepageRecommendShop selectHomepageRecommendShopByShopId(Long shopId);
	
	public int updateHomepageRecommendShop(HomepageRecommendShop recommendShop);
	
	/**
	 * 当前推荐数量
	 * @return
	 */
	public int selectTotalHomepageRecommendShopCount();
	
	/**
     * 判断店铺是否被推荐
     * @param id
     * @return
     */
    public Integer getRecommendShopByID(Long shopId);
    
    
    /**
     * 更新店铺推荐时间
     * @param shopId
     */
    public void updateRecommendShop(Long shopId);
}
