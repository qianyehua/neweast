package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;

public interface ArtPropertyValueDAO {

    /**
     * ��������Ʒid��ȡ����Ʒ����ֵ
     * @return List
     */
    public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId);

    /**
     * ����������id��ȡ����Ʒ����ֵ
     * @param proId
     * @return
     */
    public List<ArtPropertyValue> getArtPropertyValuesByProId(Long proId);

    /**
     * @param proId
     * @return
     */
    public Integer checkArtPropertyValue(String proId,Long propertyID,Long categoryID);

    /**
     * ͨ������id ɾ������ֵ
     * @param PropertyId
     * @return
     */
    public int removeArtPropertyValue(Long propertyId);

    /**
     * ɾ������ѡ��֮��ɾ������ֵ
     * @param PropertyId
     * @return
     */
    public int removeArtPropertyValueByDeleteOption(String optionId, Long propertyID,
			Long categoryID);

    /**
     * ͨ��null������idɾ��
     * @param propertyId
     * @return
     */
    public int deleteArtPropertyValueByNull(long propertyId);

    /**
     * �޸�����ɾ��������Ʒ����
     * @param optionId
     * @return
     */
    public int updateArtPropertyValue(String optionId, Long propertyID,
			Long categoryID);
    
    /**
     * ��������Ʒ����ֵ
     * @return 
     */
    public void addArtPropertyValues(ArtPropertyValue artPropertyValue);
    
    /**
     * ɾ������Ʒ����ֵ
     * @return 
     */
    public void deleteArtPropertyValuesByArtId(Long id);
}
