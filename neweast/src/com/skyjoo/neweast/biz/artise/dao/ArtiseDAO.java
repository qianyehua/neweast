package com.skyjoo.neweast.biz.artise.dao;

import java.util.List;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.UserFollow;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;

public interface ArtiseDAO {
    /**
     * 艺术家列表
     */
    public void getArtisePage( ArtiseQuery query);
    /**
     * 艺术家审核列表
     */
    public void getCheckArtisePage( ArtiseQuery query);
    /**
     *  根据艺术家ID获取艺术家详情  
     */
     public  Artise getArtiseById(Long artiseId);
     /**
      * 根据艺术家id删除艺术家
      */
     public void deleteArtiseById(Long artiseId);
     
     /**
      * 更新艺术家信息
     * @param artise
     * @return
     */
    public Long updateArtiseById(Artise artise);
    
    /**
     * 获取关注艺术家列表
     * @param userId 艺术家用户ID
     * @return
     */
    public List<UserFollow> getUserFollowListByUserID(Long userId);
}
