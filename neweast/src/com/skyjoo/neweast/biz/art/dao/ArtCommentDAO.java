package com.skyjoo.neweast.biz.art.dao;

import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.art.domain.query.ArtCommentQuery;

public interface ArtCommentDAO {


	/**
	 * ��ȡ���۷�ҳ�б�
	 * @param messageQuery
	 */
	public void  getPaginateArtComment(ArtCommentQuery artCommentQuery);
	
	/**
	 * ��ȡ��������
	 * @param id
	 * @return
	 */
	public ArtComment getArtCommentDetailById(Long id);
	
	/**
	 * ɾ������
	 * @param id
	 */
	public void  deleteArtCommentById(Long id);
	
}
