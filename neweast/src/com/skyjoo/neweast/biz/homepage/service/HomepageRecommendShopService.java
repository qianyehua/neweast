package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * ��ҳ�����Ƽ�
 * @author lxh
 *
 */
public interface HomepageRecommendShopService {
	
	/**
	 * �޸ĵ����Ƽ�
	 * @param shopId		����ID
	 * @param isRecommend	�Ƿ��Ƽ�
	 * @return
	 */
	public CommResult chRecommend(Long shopId, boolean isRecommend, String operator);
}
