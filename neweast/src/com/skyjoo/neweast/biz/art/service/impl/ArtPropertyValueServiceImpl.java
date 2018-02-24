package com.skyjoo.neweast.biz.art.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtPropertyValueDAO;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;
import com.skyjoo.neweast.biz.art.service.ArtPropertyValueService;

@Service
public class ArtPropertyValueServiceImpl implements ArtPropertyValueService {
	
	@Autowired
	private ArtPropertyValueDAO artPropertyValueDAO;
	
	@Override
	public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId) {
		return artPropertyValueDAO.getArtPropertyValuesByArtId(artId);
	}
}
