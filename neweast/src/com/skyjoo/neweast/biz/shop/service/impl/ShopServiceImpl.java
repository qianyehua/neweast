package com.skyjoo.neweast.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendShopDAO;
import com.skyjoo.neweast.biz.shop.dao.ShopBusinessHoursDAO;
import com.skyjoo.neweast.biz.shop.dao.ShopDAO;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.ShopBusinessHours;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;
import com.skyjoo.neweast.biz.shop.service.ShopService;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopBizHourType;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private ShopBusinessHoursDAO shopBusinessHoursDAO;
	@Autowired
	private ArtDAO artDAO;
	@Autowired
	private HomepageRecommendShopDAO homepageRecommendShopDAO;
	
	@Override
	public void getShopPage(ShopQuery query) {
		shopDAO.getShopPage(query);
	}

	@Override
	public Shop getShopById(Long id) {
		Shop shop = shopDAO.selectShopById(id);
		if(shop != null) {
			List<ShopBusinessHours> hours = shopBusinessHoursDAO.selectShopBusinessHoursByShopId(shop.getId());
			ShopBusinessHours workday = null, holiday = null;
			for (ShopBusinessHours hour : hours) {
				if(hour.isWorkday()) {
					workday = hour;
				} else {
					holiday = hour;
				}
			}
			if(workday == null) {
				workday = new ShopBusinessHours(shop.getId(), EnumShopBizHourType.WORKDAY);
			}
			if(holiday == null) {
				holiday = new ShopBusinessHours(shop.getId(), EnumShopBizHourType.HOLIDAY);
			}
			
			hours.clear();
			hours.add(workday);
			hours.add(holiday);
			shop.setBusinessHours(hours);
		}
		
		return shop;
	}

	@Override
	public CommResult changeSwtich(Shop shop) {
		Shop r_shop = shopDAO.selectShopById(shop.getId());
		if(r_shop == null) {
			return new CommResult(false, null, "无效ID");
		}
		r_shop.setAtrAuditOn(shop.getAtrAuditOn());
		r_shop.setImgAuditOn(shop.getImgAuditOn());
		shopDAO.updateShop(r_shop);
		return new CommResult(true);
	}

	@Override
	public CommResult closeShop(Shop shop) {
		Shop r_shop = shopDAO.selectShopById(shop.getId());
		if(r_shop == null) {
			return new CommResult(false, null, "无效ID");
		}
		
		if(!r_shop.isNormal()) {
			return new CommResult(false, null, "该店铺不能进行关闭操作");
		}
		
		artDAO.underCarriageArtByUserId(r_shop.getAccountId());
		
		r_shop.setStatus(EnumShopStatus.CLOSED);
		r_shop.setMemo(shop.getMemo());
		shopDAO.updateShop(r_shop);
		
		return new CommResult(true);
	}

	@Override
	public CommResult resumeShop(Shop shop) {
		Shop r_shop = shopDAO.selectShopById(shop.getId());
		if(r_shop == null) {
			return new CommResult(false, null, "无效ID");
		}
		
		if(!r_shop.isClosed()) {
			return new CommResult(false, null, "该店铺不能进行恢复操作");
		}
		
		r_shop.setStatus(EnumShopStatus.NORMAL);
		r_shop.setMemo(shop.getMemo());
		shopDAO.updateShop(r_shop);
		return new CommResult(true);
	}

    @Override
    public Shop getShopByAccountId(Long accountId) {
        Shop shop = shopDAO.selectShopByAccountId(accountId);
        return  shop;
    }

    @Override
    public Result<Shop> createOrUpdateShop(Shop shop) {
        Result<Shop> result = new Result<Shop>(true);
        if (shop.isUpdate()) {
            shopDAO.updateShop(shop);
            //查询是否在推荐店铺
            int num =  homepageRecommendShopDAO.getRecommendShopByID(shop.getId());
            if(num > 0){
               //更新店铺修改时间
                homepageRecommendShopDAO.updateRecommendShop(shop.getId());
            }
           
            shopBusinessHoursDAO.deleteShopBusinessHoursByShopId(shop.getId());
        } else {
            shop.setStatus(EnumShopStatus.NORMAL);
            Long id = shopDAO.insertShop(shop);
            shop.setId(id);
        }

        return result.setResult(shop);
    }

	
}
