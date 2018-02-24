/**
*@title
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtSceneDAO;
import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.art.service.ArtSceneService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author paul
 *@version 1.0
 *@date 2016��1��8�� ����12:00:23
 */
@Service
public class ArtSceneServiceImpl extends BaseManager implements ArtSceneService {
	
	@Autowired
	private ArtSceneDAO artSceneDao;

	/**
	 * ��ѯ������ҳ
	 * @param page
	 * @return
	 */
	@Override
	public Paginable<ArtScene> getPaginatedScene(Paginable<ArtScene> page) {
		artSceneDao.getPaginategArt(page);
		return null;
	}

	/**
	 * ��ȡȫ������
	 * @param artScene
	 * @return
	 */
	@Override
	public List<ArtScene> getArtSceneAll(ArtScene artScene) {
		return artSceneDao.getAllArtScene(artScene);
	}

	/**
	 * ��������Ʒ����
	 * @param artScene
	 * @return
	 */
	@Override
	public Long saveArtScene(ArtScene artScene) {
		return artSceneDao.saveArtScene(artScene);
	}

	/**
	 * �޸�����Ʒ����
	 * @param artScene
	 * @return
	 */
	@Override
	public int editScene(ArtScene artScene) {
		return artSceneDao.updateScene(artScene);
	}

	/**
	 * ����ID��ȡ����Ʒ����
	 * @param sceneId
	 * @return
	 */
	@Override
	public ArtScene getArtSceneById(Long sceneId) {
		return artSceneDao.getArtSceneById(sceneId);
	}

	@Override
	public List<ArtScene> getArtAllSceneList() {
		return artSceneDao.getArtAllSceneList();
	}

}
