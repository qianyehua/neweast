package com.skyjoo.neweast.biz.artise.dao;

import com.skyjoo.neweast.biz.artise.domain.ArtiseTrend;


public interface ArtiseTrendDAO {
	/**
	 * �������Ҷ�̬
	 */
	public Long inserAtriseTrend(ArtiseTrend artiseTrend);
	
	/**
	 * ��ȡ������Ʒ�ڶ�̬���������
	 * @param artId
	 * @return
	 */
	public int getArtiseTrendCount(Long artId);

}
