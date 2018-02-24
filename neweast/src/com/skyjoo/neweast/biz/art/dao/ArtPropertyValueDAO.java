package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;

public interface ArtPropertyValueDAO {

    /**
     * 根据艺术品id获取艺术品属性值
     * @return List
     */
    public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId);

    /**
     * 根据类属性id获取艺术品属性值
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
     * 通过属性id 删除属性值
     * @param PropertyId
     * @return
     */
    public int removeArtPropertyValue(Long propertyId);

    /**
     * 删除属性选项之后删除属性值
     * @param PropertyId
     * @return
     */
    public int removeArtPropertyValueByDeleteOption(String optionId, Long propertyID,
			Long categoryID);

    /**
     * 通过null、属性id删除
     * @param propertyId
     * @return
     */
    public int deleteArtPropertyValueByNull(long propertyId);

    /**
     * 修改属性删除后艺术品属性
     * @param optionId
     * @return
     */
    public int updateArtPropertyValue(String optionId, Long propertyID,
			Long categoryID);
    
    /**
     * 新增艺术品属性值
     * @return 
     */
    public void addArtPropertyValues(ArtPropertyValue artPropertyValue);
    
    /**
     * 删除艺术品属性值
     * @return 
     */
    public void deleteArtPropertyValuesByArtId(Long id);
}
