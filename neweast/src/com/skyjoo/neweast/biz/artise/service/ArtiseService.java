package com.skyjoo.neweast.biz.artise.service;

import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;

public interface ArtiseService {

    /**
     * ��ȡ�������б�
     */
    public void getArtisePage(ArtiseQuery query);

    /**
     * ��ȡ����������б�
     */
    public void getCheckArtisePage(ArtiseQuery query);

    /**
     *  ����������ID��ȡ����������  
     */
    public Artise getArtiseById(Long id);

    /**
     * ����������idɾ��������
     */
    public void deleteArtiseById(Long artiseId);

    /**
     * ����������id�����Ƽ�������
     */
    public Artise addHomepageRecommendArtiseById(Long artiseId,String operator);

    /**
     * ����������idȡ���Ƽ�������
     */
    public int offHomepageRecommendArtiseById(Long artiseId,String operator);
    
    /**
     * ������������Ϣ
     * @param artise
     * @return
     */
    public Long updateArtiseById(Artise artise);
}
