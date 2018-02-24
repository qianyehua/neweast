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
 *@date 2016年1月8日 上午12:05:21
 */
public interface ArtSceneDAO {

	
	/**
	 * 分页查询,获取场景列表
	 * @param page
	 * @return
	 */
	public Paginable<ArtScene> getPaginategArt(Paginable<ArtScene> page);
	
	
	/**
	 * 获取全部的场景列表
	 * @param scene
	 * @return
	 */
	public List<ArtScene> getAllArtScene(ArtScene scene);
	
	
	/**
	 * 保存艺术品场景
	 * @param artScene
	 * @return
	 */
	public Long saveArtScene(ArtScene artScene);
	
	/**
	 * 修改艺术品场景
	 * @param artScene
	 * @return
	 */
	public int updateScene(ArtScene artScene);
	
	
	/**
	 * 根据ID获取艺术品详情
	 * @param sceneId
	 * @return
	 */
	public ArtScene getArtSceneById(Long sceneId);
	
    /**
     * 获取所有场景
     * @return
     */
    public List<ArtScene> getArtAllSceneList();

	
}
