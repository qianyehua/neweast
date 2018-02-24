package com.skyjoo.neweast.biz.artise.dao;

import com.skyjoo.neweast.biz.artise.domain.ArtiseTrend;


public interface ArtiseTrendDAO {
	/**
	 * 插入卖家动态
	 */
	public Long inserAtriseTrend(ArtiseTrend artiseTrend);
	
	/**
	 * 获取该艺术品在动态里面的数量
	 * @param artId
	 * @return
	 */
	public int getArtiseTrendCount(Long artId);

}
