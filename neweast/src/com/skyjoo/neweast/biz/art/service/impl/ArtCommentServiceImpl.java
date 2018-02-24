package com.skyjoo.neweast.biz.art.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtCommentDAO;
import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.art.domain.query.ArtCommentQuery;
import com.skyjoo.neweast.biz.art.service.ArtCommentService;

@Service
public class ArtCommentServiceImpl implements ArtCommentService{
	
	@Autowired
	private ArtCommentDAO artCommentDAO;

	@Override
	public void getPaginateArtComment(ArtCommentQuery artCommentQuery) {
		artCommentDAO.getPaginateArtComment(artCommentQuery);
	}

	@Override
	public ArtComment getArtCommentDetailById(Long id) {
		return artCommentDAO.getArtCommentDetailById(id);
	}

	@Override
	public void deleteArtCommentById(Long id) {
		artCommentDAO.deleteArtCommentById(id);
	}
	

}
