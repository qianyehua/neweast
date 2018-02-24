package com.skyjoo.neweast.biz.shop.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopTemplateDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;

@Repository
@SuppressWarnings("deprecation")
public class ShopTemplateDAOImpl extends BaseDaoiBatis implements ShopTemplateDAO {

	private static final String SQLMAP_SPACE = "SHOP_TEMPLATE.";

	@Override
	public void getShopTemplatePage(ShopTemplate template) {
		this.paginate(template, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}

	@Override
	public ShopTemplate getShopTemplateByID(Long id) {
		return (ShopTemplate) getSqlMapClientTemplate().
				queryForObject(SQLMAP_SPACE + "getShopTemplateByID", id);
	}

	@Override
	public Integer getCountByTitle(String title) {
		return  (Integer)getSqlMapClientTemplate().
				queryForObject(SQLMAP_SPACE + "getCountByTitle", title);
	}

	@Override
	public Long addShopTemplate(ShopTemplate template) {
		return  (Long) getSqlMapClientTemplate().
				insert(SQLMAP_SPACE + "addShopTemplate", template);
	}
	
	@Override
	public Integer remove(Long id) {
		return  (Integer) getSqlMapClientTemplate().
				update(SQLMAP_SPACE + "remove", id);
	}
	

}
