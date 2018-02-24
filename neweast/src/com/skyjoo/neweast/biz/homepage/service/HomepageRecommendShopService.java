package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * 首页店铺推荐
 * @author lxh
 *
 */
public interface HomepageRecommendShopService {
	
	/**
	 * 修改店铺推荐
	 * @param shopId		店铺ID
	 * @param isRecommend	是否推荐
	 * @return
	 */
	public CommResult chRecommend(Long shopId, boolean isRecommend, String operator);
}
