package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;

public interface ShopDecorateContentDAO {
    
    /**
     * �����û�Id��װ�����򣬻��װ������
     * @param userId
     * @param areaType
     * @return
     */
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Map map);
    
    /**
     * ������Ʒװ��ҳ��
     * @param content
     * @return
     */
    public int editShopDecorateContent(ShopDecorateContent content);

}
