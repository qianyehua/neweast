package com.skyjoo.neweast.biz.art.dao;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;

public interface ArtConsultingDAO {

	/**
	 * ��ȡ��ѯ��ҳ
	 * @param artConsulting
	 */
	public void  getPaginateArtConsulting(ArtConsultingQuery artConsulting);
	
	/**
	 * ��ȡ��ѯ����
	 * @param id
	 * @return
	 */
	public ArtConsulting getArtConsultingDetail(Long id);
	
	/**
	 * ����IDɾ����ѯ
	 * @param id
	 */
	public void deleteArtConsultingById(Long id);
	
}
