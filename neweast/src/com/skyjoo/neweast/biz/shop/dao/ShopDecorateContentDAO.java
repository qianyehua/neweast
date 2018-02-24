package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;

public interface ShopDecorateContentDAO {
    
    /**
     * 根据用户Id和装修区域，获得装修内容
     * @param userId
     * @param areaType
     * @return
     */
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Map map);
    
    /**
     * 更新商品装修页面
     * @param content
     * @return
     */
    public int editShopDecorateContent(ShopDecorateContent content);

}
