package com.skyjoo.neweast.biz.art.service;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;

public interface ArtConsultingService {

	/**
	 * ��ȡ��ѯ�б��ҳ
	 * @param artConsulting
	 * @return
	 */
	public void getPaginateArtConsulting(ArtConsultingQuery artConsulting);
	
	/**
	 * ��ȡ��ѯ����
	 * @param id
	 * @return
	 */
	public ArtConsulting getArtConsultingDetail(Long id);
	
	/**
	 * ����Idɾ����ѯ
	 * @param id
	 */
	public void deleteArtConsultingById(Long id);
}
