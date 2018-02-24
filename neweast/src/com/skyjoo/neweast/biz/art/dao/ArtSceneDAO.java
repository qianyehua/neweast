/**
*@title
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author paul
 *@version 1.0
 *@date 2016��1��8�� ����12:05:21
 */
public interface ArtSceneDAO {

	
	/**
	 * ��ҳ��ѯ,��ȡ�����б�
	 * @param page
	 * @return
	 */
	public Paginable<ArtScene> getPaginategArt(Paginable<ArtScene> page);
	
	
	/**
	 * ��ȡȫ���ĳ����б�
	 * @param scene
	 * @return
	 */
	public List<ArtScene> getAllArtScene(ArtScene scene);
	
	
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
	public int updateScene(ArtScene artScene);
	
	
	/**
	 * ����ID��ȡ����Ʒ����
	 * @param sceneId
	 * @return
	 */
	public ArtScene getArtSceneById(Long sceneId);
	
    /**
     * ��ȡ���г���
     * @return
     */
    public List<ArtScene> getArtAllSceneList();

	
}
