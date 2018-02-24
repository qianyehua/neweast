/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * 首页推荐艺术品管理业务
 * @date 2014-11-12 10:45:22
 */
public interface HomepageRecommendService {
	
	/**
	 * 修改艺术品推荐
	 * @param artId		艺术品ID
	 * @param isRecommend	是否推荐
	 * @return
	 */
	public CommResult chRecommend(Long artId, boolean isRecommend, String operator);
	
	/**
	 * 删除推荐艺术品ById
	 * @param artId
	 */
	public void deleteRecommendByArtId(Long artId);
}
