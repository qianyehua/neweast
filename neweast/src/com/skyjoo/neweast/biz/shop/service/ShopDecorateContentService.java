package com.skyjoo.neweast.biz.shop.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;

public interface ShopDecorateContentService {
    
    /**
     * �༭װ�����ݣ���������޸ģ�
     * @return
     */
    public int editShopDecorateContent(ShopDecorateContent content);
    
    /**
     * ����ģ��ID��ȡװ������Map
     * @param decorateId
     * @return key1 page  key2 area
     */
    public Map<String, Map<String, Object>> getShopDecorateContentMap(Long decorateId);
    
    /**
     * �����û�Id��װ�����򣬻��װ������
     * @param userId
     * @param areaType
     * @return
     */
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Long userId,String areaType);
    

}
