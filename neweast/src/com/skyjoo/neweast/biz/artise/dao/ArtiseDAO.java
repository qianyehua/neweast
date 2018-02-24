package com.skyjoo.neweast.biz.artise.dao;

import java.util.List;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.UserFollow;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;

public interface ArtiseDAO {
    /**
     * �������б�
     */
    public void getArtisePage( ArtiseQuery query);
    /**
     * ����������б�
     */
    public void getCheckArtisePage( ArtiseQuery query);
    /**
     *  ����������ID��ȡ����������  
     */
     public  Artise getArtiseById(Long artiseId);
     /**
      * ����������idɾ��������
      */
     public void deleteArtiseById(Long artiseId);
     
     /**
      * ������������Ϣ
     * @param artise
     * @return
     */
    public Long updateArtiseById(Artise artise);
    
    /**
     * ��ȡ��ע�������б�
     * @param userId �������û�ID
     * @return
     */
    public List<UserFollow> getUserFollowListByUserID(Long userId);
}
