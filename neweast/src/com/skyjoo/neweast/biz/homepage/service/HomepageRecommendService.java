/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service;

import com.skyjoo.neweast.biz.common.CommResult;

/**
 * ��ҳ�Ƽ�����Ʒ����ҵ��
 * @date 2014-11-12 10:45:22
 */
public interface HomepageRecommendService {
	
	/**
	 * �޸�����Ʒ�Ƽ�
	 * @param artId		����ƷID
	 * @param isRecommend	�Ƿ��Ƽ�
	 * @return
	 */
	public CommResult chRecommend(Long artId, boolean isRecommend, String operator);
	
	/**
	 * ɾ���Ƽ�����ƷById
	 * @param artId
	 */
	public void deleteRecommendByArtId(Long artId);
}
