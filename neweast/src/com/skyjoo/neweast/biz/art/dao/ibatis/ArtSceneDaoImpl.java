/**
*@title
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao.ibatis;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtSceneDAO;
import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author paul
 *@version 1.0
 *@date 2016年1月8日 上午12:12:32
 */
@SuppressWarnings("deprecation")
@Repository
public class ArtSceneDaoImpl extends BaseDaoiBatis  implements ArtSceneDAO {

	private static final String SQLMAP_SPACE = "ART_SCENE.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	



	@Override
	public Paginable<ArtScene> getPaginategArt(Paginable<ArtScene> page) {
		super.paginate(page, SQLMAP_SPACE+"getArtSceneCount",SQLMAP_SPACE+"getPaginatedArtSceneQuery");
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ArtScene> getAllArtScene(ArtScene scene) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getAllArtScene",scene);
	}


	@Override
	public Long saveArtScene(ArtScene artScene) {
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"insertArtScene",artScene);
	}


	@Override
	public int updateScene(ArtScene artScene) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"updateArtScene", artScene);
	}


	@Override
	public ArtScene getArtSceneById(Long sceneId) {
		return (ArtScene) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtSceneById", sceneId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArtScene> getArtAllSceneList() {
		return (List<ArtScene>) this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtAllSceneList");
	}
	

	
}
