package com.skyjoo.neweast.biz.shop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.shop.dao.ShopDecorateContentDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;
import com.skyjoo.neweast.biz.shop.service.ShopDecorateContentService;

@Service("shopDecorateContentService")
public class ShopDecorateContentServiceImpl implements ShopDecorateContentService {
    @Autowired
    private ShopDecorateContentDAO shopDecorateContentDAO;

    @Override
    public int editShopDecorateContent(ShopDecorateContent content) {
        return shopDecorateContentDAO.editShopDecorateContent(content);
    }

    @Override
    public Map<String, Map<String, Object>> getShopDecorateContentMap(Long decorateId) {
        return null;
    }

    @Override
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Long userId, String areaType) {
        Map map = new HashMap();
        map.put("userId", userId);
        map.put("areaType", areaType);
        return shopDecorateContentDAO.getShopDecorateContentByUserId(map);
    }

}
