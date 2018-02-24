package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;


/**
 * ART_SCENE_LINK 艺术品场景关系表 Service
 * @author paul
 * @version 2016-2-29 15:45
 **/
public interface ArtSceneLinkService {

    
    /**
     * 根据艺术品id 获取 记录
     */
	public List<ArtSceneLink> getByArtId(Long id);
    
}
