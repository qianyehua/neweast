package com.skyjoo.neweast.biz.art.dao;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;

public interface ArtConsultingDAO {

	/**
	 * 获取咨询分页
	 * @param artConsulting
	 */
	public void  getPaginateArtConsulting(ArtConsultingQuery artConsulting);
	
	/**
	 * 获取咨询详情
	 * @param id
	 * @return
	 */
	public ArtConsulting getArtConsultingDetail(Long id);
	
	/**
	 * 根据ID删除咨询
	 * @param id
	 */
	public void deleteArtConsultingById(Long id);
	
}
