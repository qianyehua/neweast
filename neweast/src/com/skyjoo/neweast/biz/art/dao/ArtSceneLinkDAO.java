package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;


public interface ArtSceneLinkDAO {
    
    /**
     * ��������Ʒid ��ȡ ��¼
     */
	public List<ArtSceneLink> getByArtId(Long id);
    
}
