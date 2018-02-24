/**
*@title 艺术品场景
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.common.page.Paginable;


public interface ArtSceneService {

	/**
	 * 分页查询 获取场景列表
	 * @param page
	 * @return
	 */
	public Paginable<ArtScene> getPaginatedScene(Paginable<ArtScene> page);
	
	/**
	 * 获取全部场景
	 * @param artScene
	 * @return
	 */
	public List<ArtScene> getArtSceneAll(ArtScene artScene);
	
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
	public int editScene(ArtScene artScene);
	
	
	
	/**
	 * 根据ID获取艺术品详情
	 * @param sceneId
	 * @return
	 */
	public ArtScene getArtSceneById(Long sceneId);
	
    /**
     * 获取所有场景
     */
    public List<ArtScene> getArtAllSceneList();	
	
}
