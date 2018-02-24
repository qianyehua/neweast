package com.skyjoo.neweast.web.action.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.account.service.UserAccountService;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeOrderQuery;
import com.skyjoo.neweast.biz.trade.service.TradeLogisticService;
import com.skyjoo.neweast.biz.trade.service.TradeOrderService;
import com.skyjoo.neweast.biz.trade.service.TradeRefundService;
import com.skyjoo.neweast.biz.trade.service.TradeTimeoutService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticDirection;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeOrderStatus;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeRefundStatus;

@Controller
@RequestMapping("order")
public class TradeOrderAction extends BaseAction {
	
	@Autowired
	private TradeOrderService tradeOrderService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private TradeRefundService tradeRefundService;
	@Autowired
	private TradeTimeoutService tradeTimeoutService;
	@Autowired
	private TradeLogisticService tradeLogisticService;
	@Autowired
	private CommDatadicCacheService commDatadicCacheService;
	/**
	 * ��ҳ��ʾ������Ϣ
	 * @param tradeOrder
	 * @param model
	 * @return
	 */
	@RequestMapping("list.htm")
	public String list(@ModelAttribute("query") TradeOrderQuery query, ModelMap model){
		if(query.enable()) {
			tradeOrderService.getPageTradeOrder(query);
		} else {
			query.setData(null);
		}
		model.put("tradeStatusMap",TradeOrderStatus.toMap());
		return "trade/order/list";
	}
	
	/**
	 * ��ȡ��������ϸ��Ϣ
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail.htm")
	public String detail(Long orderId,ModelMap model){
		TradeOrder order = tradeOrderService.getTradeOrderByOrderId(orderId);
		if(orderId == null) {
			model.put("message", "��Ч����");
			return "error";
		}
		//�õ�������Ϣ
		model.addAttribute("order", order);
		//�õ���ʱ��Ϣ
		model.addAttribute("timeoutList",tradeTimeoutService.getTradeTimeoutByOrderId(orderId));
		//�õ�������Ϣ
		model.addAttribute("logistic", tradeLogisticService.getTradeLogisticByOrderId(orderId));
		//�õ������Ϣ
		model.addAttribute("buyer", userAccountService.getUserAccountById(order.getBuyerId()));
		//�õ�������Ϣ
		model.addAttribute("seller", userAccountService.getUserAccountById(order.getSellerId()));
		//�õ��˿���Ϣ
		TradeRefund refund = tradeRefundService.getLastTradeRefundByOrderId(orderId);
		model.addAttribute("refund", refund);
		if(refund != null) {
			model.addAttribute("refundlogistic",tradeLogisticService.getTradeLogistic(order.getId(), refund.getId(), TradeLogisticDirection.buyer2seller));
		}
		model.addAttribute("countryList",commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.ACCOUNT_COUNTRY));
		model.addAttribute("orderStatusList", TradeOrderStatus.values());
		model.addAttribute("refundStatusList", TradeRefundStatus.values());
		return "trade/order/detail";
	}
}
