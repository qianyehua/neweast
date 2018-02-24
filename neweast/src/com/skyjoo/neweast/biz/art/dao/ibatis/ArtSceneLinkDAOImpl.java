package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtSceneLinkDAO;
import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;


@Repository("artSceneLinkDAO")
public class ArtSceneLinkDAOImpl extends BaseDaoiBatis implements ArtSceneLinkDAO{

    private static final String NameSpace = "artSceneLink.";
    
    @Autowired
	private SqlMapClientTemplate sqlMapClient;

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<ArtSceneLink> getByArtId(Long id) {
		return (List<ArtSceneLink>) this.sqlMapClient
				.queryForList(NameSpace+"getByArtId", id);
	}
    
}
