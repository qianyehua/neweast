package com.skyjoo.neweast.biz.art.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtConsultingDAO;
import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
@SuppressWarnings("deprecation")
@Repository
public class ArtConsultingDaoImpl  extends BaseDaoiBatis implements ArtConsultingDAO {
	
	private static final String SQLMAP_SPACE = "ART_CONSULTING_INFORMATION.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;


	@Override
	public void getPaginateArtConsulting(ArtConsultingQuery artConsulting) {
		super.paginate(artConsulting, SQLMAP_SPACE+"getArtConsultingCount", SQLMAP_SPACE+"getPaginateArtConsulting");
	}

	@Override
	public ArtConsulting getArtConsultingDetail(Long id) {
		return (ArtConsulting) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtConsultingDetail", id);
	}

	@Override
	public void deleteArtConsultingById(Long id) {
		this.sqlMapClient.delete(SQLMAP_SPACE+"deleteArtConsultingById", id);
	}
	
	
}
