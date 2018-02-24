package com.skyjoo.neweast.biz.account.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.eyeieye.melos.util.DateUtil;
import com.skyjoo.neweast.biz.account.service.SalesVolumeService;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.shop.dao.ShopDAO;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.trade.dao.SalesVolumeDAO;
import com.skyjoo.neweast.biz.trade.domain.SalesVolume;

@Service
public class SalesVolumeServiceImpl implements SalesVolumeService {

	@Autowired
	private SalesVolumeDAO salesVolumeDAO;
	@Autowired
	private ArtDAO artDAO;
	@Autowired
	private ShopDAO shopDAO;
	@Autowired
	private TransactionTemplate transactionTemplate;
	

	@Override
	public void statisticShopMainBiz() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -0);
		String entDate = DateUtil.getDateTime("yyyyMMdd", calendar.getTime());
		calendar.add(Calendar.DAY_OF_MONTH, -30);
		final String startDate = DateUtil.getDateTime("yyyyMMdd", calendar.getTime());
		
		Map<Long, List<Long>> mainBizMap = new HashMap<Long, List<Long>>();

		List<SalesVolume> salesVolumes = salesVolumeDAO.groupSalesVolumeByShopAndCategory(startDate, entDate);
		for (SalesVolume salesVolume : salesVolumes) {
			List<Long> mainBiz = mainBizMap.get(salesVolume.getShopId());
			if(mainBiz == null) {
				mainBiz = new ArrayList<Long>();
				mainBizMap.put(salesVolume.getShopId(), mainBiz);
				mainBiz.add(salesVolume.getCategoryId());
			} else if(mainBiz.size() < 5) {
				mainBiz.add(salesVolume.getCategoryId());
			}
		}
		
		List<Shop> shopList = new ArrayList<Shop>();
		for (Entry<Long, List<Long>> entry : mainBizMap.entrySet()) {
			Shop shop = new Shop();
			shop.setId(entry.getKey());
			shop.setMainBiz(entry.getValue().toString());
			shopList.add(shop);
		}
		//更新主营业务
		shopDAO.batchUpdateShop(shopList);
		//迁移数据
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				salesVolumeDAO.dealMoveToHis(startDate);
				salesVolumeDAO.deleteAfterMove(startDate);
			}
		});
		
	}
	
}
