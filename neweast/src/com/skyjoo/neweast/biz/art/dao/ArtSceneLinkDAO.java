package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;


public interface ArtSceneLinkDAO {
    
    /**
     * 根据艺术品id 获取 记录
     */
	public List<ArtSceneLink> getByArtId(Long id);
    
}
