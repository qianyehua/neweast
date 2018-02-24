/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommend;

/**
 * 首页推荐艺术品表DAO
 * @date 2014-11-12 10:49:27
 */
public interface HomepageRecommendDAO {
	
	public Long insertHomepageRecommend(HomepageRecommend recommend);
	
	public HomepageRecommend selectHomepageRecommendByArtId(Long artId);
	
	public int updateHomepageRecommend(HomepageRecommend recommend);
	
	/**
	 * 当前推荐数量
	 * @return
	 */
	public int selectTotalHomepageRecommendCountByCategroyId(Long categroyId);
	
	/**
	 * 根据艺术品更新推荐页面
	 * @param recommend
	 * @return
	 */
	public int updateHomepageRecommendByArtId(HomepageRecommend recommend);
}
