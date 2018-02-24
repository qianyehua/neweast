package com.skyjoo.neweast.biz.art.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtCommentDAO;
import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.art.domain.query.ArtCommentQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
@SuppressWarnings("deprecation")
@Repository
public class ArtCommentDaoImpl  extends BaseDaoiBatis implements ArtCommentDAO {
	
	private static final String SQLMAP_SPACE = "ART_COMMENT.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;


	@Override
	public void getPaginateArtComment(ArtCommentQuery artCommentQuery) {
		super.paginate(artCommentQuery, SQLMAP_SPACE+"getArtCommentCount", SQLMAP_SPACE+"getPaginateArtComment");
	}


	@Override
	public ArtComment getArtCommentDetailById(Long id) {
		return (ArtComment) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtCommentDetailById", id);
	}


	@Override
	public void deleteArtCommentById(Long id) {
		this.sqlMapClient.delete(SQLMAP_SPACE+"deleteArtCommentById", id);
		
	}

	
	
}
