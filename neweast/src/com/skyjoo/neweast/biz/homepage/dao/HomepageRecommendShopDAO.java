package com.skyjoo.neweast.biz.homepage.dao;

import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendShop;

public interface HomepageRecommendShopDAO {

	public Long insertHomepageRecommendShop(HomepageRecommendShop recommendShop);
	
	public HomepageRecommendShop selectHomepageRecommendShopByShopId(Long shopId);
	
	public int updateHomepageRecommendShop(HomepageRecommendShop recommendShop);
	
	/**
	 * ��ǰ�Ƽ�����
	 * @return
	 */
	public int selectTotalHomepageRecommendShopCount();
	
	/**
     * �жϵ����Ƿ��Ƽ�
     * @param id
     * @return
     */
    public Integer getRecommendShopByID(Long shopId);
    
    
    /**
     * ���µ����Ƽ�ʱ��
     * @param shopId
     */
    public void updateRecommendShop(Long shopId);
}
