package com.skyjoo.neweast.biz.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.shop.dao.ShopPicDAO;
import com.skyjoo.neweast.biz.shop.domain.ShopPic;
import com.skyjoo.neweast.biz.shop.domain.query.ShopPicQuery;
import com.skyjoo.neweast.biz.shop.service.ShopPicService;

@Service
public class ShopPicServiceImpl implements ShopPicService {

	@Autowired
	private ShopPicDAO shopPicDAO;

	@Override
	public void getShopPicPage(ShopPicQuery query) {
		shopPicDAO.getShopPicPage(query);
	}

	@Override
	public Integer audit(ShopPic sp) {
		return shopPicDAO.audit(sp);
	}


}
