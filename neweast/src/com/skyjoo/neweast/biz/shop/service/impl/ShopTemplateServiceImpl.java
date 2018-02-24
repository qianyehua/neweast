package com.skyjoo.neweast.biz.shop.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.shop.dao.ShopTemplateDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;
import com.skyjoo.neweast.biz.shop.service.ShopTemplateService;

@Service
public class ShopTemplateServiceImpl implements ShopTemplateService {

	@Autowired
	private ShopTemplateDAO shopTemplateDAO;
	
	
	@Override
	public void getShopTemplatePage(ShopTemplate template) {
		shopTemplateDAO.getShopTemplatePage(template);
	}

	@Override
	public ShopTemplate getShopTemplateByID(Long id) {
		return shopTemplateDAO.getShopTemplateByID(id);
	}

	@Override
	public boolean hasTitle(String title) {
		Integer count = shopTemplateDAO.getCountByTitle(title);
		
		return count==0?false:true;
	}

	@Override
	public Long addShopTemplate(ShopTemplate template) {
		return shopTemplateDAO.addShopTemplate(template);
	}

	@Override
	public Integer remove(Long id) {
		return shopTemplateDAO.remove(id);
	}
	
}
