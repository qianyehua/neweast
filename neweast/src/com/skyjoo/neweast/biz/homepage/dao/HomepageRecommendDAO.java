/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommend;

/**
 * ��ҳ�Ƽ�����Ʒ��DAO
 * @date 2014-11-12 10:49:27
 */
public interface HomepageRecommendDAO {
	
	public Long insertHomepageRecommend(HomepageRecommend recommend);
	
	public HomepageRecommend selectHomepageRecommendByArtId(Long artId);
	
	public int updateHomepageRecommend(HomepageRecommend recommend);
	
	/**
	 * ��ǰ�Ƽ�����
	 * @return
	 */
	public int selectTotalHomepageRecommendCountByCategroyId(Long categroyId);
	
	/**
	 * ��������Ʒ�����Ƽ�ҳ��
	 * @param recommend
	 * @return
	 */
	public int updateHomepageRecommendByArtId(HomepageRecommend recommend);
}
