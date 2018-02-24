package com.skyjoo.neweast.biz.artise.service;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;

public interface ArtiseService {

    /**
     * 获取艺术家列表
     */
    public void getArtisePage(ArtiseQuery query);

    /**
     * 获取艺术家审核列表
     */
    public void getCheckArtisePage(ArtiseQuery query);

    /**
     *  根据艺术家ID获取艺术家详情  
     */
    public Artise getArtiseById(Long id);

    /**
     * 根据艺术家id删除艺术家
     */
    public void deleteArtiseById(Long artiseId);

    /**
     * 根据艺术家id增加推荐艺术家
     */
    public Artise addHomepageRecommendArtiseById(Long artiseId,String operator);

    /**
     * 根据艺术家id取消推荐艺术家
     */
    public int offHomepageRecommendArtiseById(Long artiseId,String operator);
    
    /**
     * 更新艺术家信息
     * @param artise
     * @return
     */
    public Long updateArtiseById(Artise artise);
}
