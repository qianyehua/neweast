package com.skyjoo.neweast.biz.art.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtSceneLinkDAO;
import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;
import com.skyjoo.neweast.biz.art.service.ArtSceneLinkService;

@Service("artSceneLinkService")
public class ArtSceneLinkServiceImpl implements ArtSceneLinkService{

	@Autowired 
	ArtSceneLinkDAO artSceneLinkDAO;


	@Override
	public List<ArtSceneLink> getByArtId(Long id) {
		return artSceneLinkDAO.getByArtId(id);
	}

}
