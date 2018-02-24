package com.skyjoo.neweast.biz.art.service;

import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.art.domain.query.ArtCommentQuery;

public interface ArtCommentService {

	/**
	 * 获取评论列表分页
	 * @param messageQuery
	 */
	public void getPaginateArtComment(ArtCommentQuery artCommentQuery);
	
	/**
	 * 获取评论详情
	 * @param id
	 * @return
	 */
	public ArtComment getArtCommentDetailById(Long id);
	
	
	/**
	 * 删除评论
	 * @param id
	 */
	public void deleteArtCommentById(Long id);
	
}
