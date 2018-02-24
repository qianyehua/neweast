package com.skyjoo.neweast.biz.shop.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;

public interface ShopDecorateContentService {
    
    /**
     * 编辑装修内容（插入或者修改）
     * @return
     */
    public int editShopDecorateContent(ShopDecorateContent content);
    
    /**
     * 根据模版ID获取装修内容Map
     * @param decorateId
     * @return key1 page  key2 area
     */
    public Map<String, Map<String, Object>> getShopDecorateContentMap(Long decorateId);
    
    /**
     * 根据用户Id和装修区域，获得装修内容
     * @param userId
     * @param areaType
     * @return
     */
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Long userId,String areaType);
    

}
