/**
*@title ����Ʒ����
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.common.page.Paginable;


public interface ArtSceneService {

	/**
	 * ��ҳ��ѯ ��ȡ�����б�
	 * @param page
	 * @return
	 */
	public Paginable<ArtScene> getPaginatedScene(Paginable<ArtScene> page);
	
	/**
	 * ��ȡȫ������
	 * @param artScene
	 * @return
	 */
	public List<ArtScene> getArtSceneAll(ArtScene artScene);
	
	/**
	 * ��������Ʒ����
	 * @param artScene
	 * @return
	 */
	public Long saveArtScene(ArtScene artScene);
	
	
	/**
	 * �޸�����Ʒ����
	 * @param artScene
	 * @return
	 */
	public int editScene(ArtScene artScene);
	
	
	
	/**
	 * ����ID��ȡ����Ʒ����
	 * @param sceneId
	 * @return
	 */
	public ArtScene getArtSceneById(Long sceneId);
	
    /**
     * ��ȡ���г���
     */
    public List<ArtScene> getArtAllSceneList();	
	
}
