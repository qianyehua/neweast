package com.skyjoo.neweast.biz.shop.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopDecorateContentDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;

@Repository("shopDecorateContentDAO")
public class ShopDecorateContentDAOImpl extends BaseDaoiBatis implements ShopDecorateContentDAO {
    
    private static final String SQLMAP_SPACE = "SHOP_DECORATE_CONTENT.";
    
  
    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public List<ShopDecorateContent> getShopDecorateContentByUserId(Map map) {
        return getSqlMapClientTemplate().queryForList(SQLMAP_SPACE +"getShopDecorateContentByUserId", map);
    }


    @SuppressWarnings("deprecation")
    @Override
    public int editShopDecorateContent(ShopDecorateContent content) {
        return getSqlMapClientTemplate().update(SQLMAP_SPACE+"update", content);
    }

}
