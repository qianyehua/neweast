package com.skyjoo.neweast.biz.homepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendShopDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendShop;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendShopService;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.service.ShopService;

@Service
public class HomepageRecommendShopServiceImpl extends BaseManager implements
		HomepageRecommendShopService {

	@Autowired
	private HomepageRecommendShopDAO homepageRecommendShopDAO;
	@Autowired
	private ShopService shopService;
	
	@Value("${recommend.shop.max}")
	private Integer maxRecommendShop = 30;
	
	@Override
	public CommResult chRecommend(Long shopId, boolean isRecommend, String operator) {
		CommResult result = new CommResult(true);
		
		HomepageRecommendShop recommendShop = homepageRecommendShopDAO.selectHomepageRecommendShopByShopId(shopId);
		if(isRecommend) {//推荐
			int totalCount = homepageRecommendShopDAO.selectTotalHomepageRecommendShopCount();
			if(totalCount >= maxRecommendShop) {
				result.setSuccess(false);
				result.setErrorMsg("推荐数量到达上限");
				return result;
			}
			
			Shop shop = shopService.getShopById(shopId);
			if(shop == null || !shop.isNormal()) {
				result.setSuccess(false);
				result.setErrorMsg("店铺异常");
				return result;
			}
			
			if(recommendShop == null) {
				recommendShop = new HomepageRecommendShop();
				recommendShop.setShopId(shopId);
				recommendShop.setStatus(HomepageRecommendShop.STATUS_NORMAL);
				recommendShop.setOperator(operator);
				homepageRecommendShopDAO.insertHomepageRecommendShop(recommendShop);
			} else {
				if(!recommendShop.isNormal()) {
					recommendShop.setStatus(HomepageRecommendShop.STATUS_NORMAL);
					recommendShop.setOperator(operator);
					homepageRecommendShopDAO.updateHomepageRecommendShop(recommendShop);
				}
			}
		} else {//撤销推荐
			if(recommendShop == null) {
				result.setSuccess(false);
				result.setErrorMsg("无效参数");
			} else {
				recommendShop.setStatus(HomepageRecommendShop.STATUS_DELETE);
				recommendShop.setOperator(operator);
				homepageRecommendShopDAO.updateHomepageRecommendShop(recommendShop);
			}
		}
		
		return result;
	}

}
