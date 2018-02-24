package com.skyjoo.neweast.biz.art.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtConsultingDAO;
import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;
import com.skyjoo.neweast.biz.art.service.ArtConsultingService;

@Service
public class ArtConsultingServiceImpl implements ArtConsultingService{
	
	@Autowired
	private ArtConsultingDAO artConsultingDAO;

	@Override
	public void getPaginateArtConsulting(ArtConsultingQuery artConsulting) {
		artConsultingDAO.getPaginateArtConsulting(artConsulting);
	}

	@Override
	public ArtConsulting getArtConsultingDetail(Long id) {
		return artConsultingDAO.getArtConsultingDetail(id);
	}

	@Override
	public void deleteArtConsultingById(Long id) {
		artConsultingDAO.deleteArtConsultingById(id);
	}

}
