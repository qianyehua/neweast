package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;


/**
 * ART_SCENE_LINK ����Ʒ������ϵ�� Service
 * @author paul
 * @version 2016-2-29 15:45
 **/
public interface ArtSceneLinkService {

    
    /**
     * ��������Ʒid ��ȡ ��¼
     */
	public List<ArtSceneLink> getByArtId(Long id);
    
}
