package com.skyjoo.neweast.biz.art.service;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;

public interface ArtConsultingService {

	/**
	 * 获取咨询列表分页
	 * @param artConsulting
	 * @return
	 */
	public void getPaginateArtConsulting(ArtConsultingQuery artConsulting);
	
	/**
	 * 获取咨询详情
	 * @param id
	 * @return
	 */
	public ArtConsulting getArtConsultingDetail(Long id);
	
	/**
	 * 根据Id删除咨询
	 * @param id
	 */
	public void deleteArtConsultingById(Long id);
}
