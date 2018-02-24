package com.skyjoo.neweast.web.action.trade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hundsun.wudadao.common.Result;
import com.hundsun.wudadao.common.enums.EnumDatadicGroupName;
import com.skyjoo.neweast.biz.account.service.UserAccountService;
import com.skyjoo.neweast.biz.datadic.service.CommDatadicCacheService;
import com.skyjoo.neweast.biz.trade.domain.TradeOrder;
import com.skyjoo.neweast.biz.trade.domain.TradeRefund;
import com.skyjoo.neweast.biz.trade.domain.query.TradeRefundQuery;
import com.skyjoo.neweast.biz.trade.service.TradeLogisticService;
import com.skyjoo.neweast.biz.trade.service.TradeOrderService;
import com.skyjoo.neweast.biz.trade.service.TradeRefundService;
import com.skyjoo.neweast.biz.trade.service.TradeTimeoutService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeLogisticDirection;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeOrderStatus;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeRefundStatus;
import com.skyjoo.wudadao.greenbird.interfaces.RemoteMallTradeService;

@Controller
@RequestMapping(value="refund")
public class TradeRefundAction extends BaseAction {

	@Autowired
	private TradeRefundService tradeRefundService;
	@Autowired
	private TradeOrderService tradeOrderService;
	@Autowired
	private UserAccountService userAccount;
	@Autowired
	private TradeTimeoutService tradeTimeoutService;
	@Autowired
	private TradeLogisticService tradeLogisticService;
	@Autowired
	private CommDatadicCacheService commDatadicCacheService;
	@Autowired
	private RemoteMallTradeService remoteMallTradeService;
	
	/**
	 * 获取退款列表 分页
	 * @param tradeRefund
	 * @param model
	 * @return
	 */
	@RequestMapping("list.htm")
	public String list(@ModelAttribute("query")TradeRefundQuery query, ModelMap model){	
		if(query.enable()) {
			tradeRefundService.getPaginatedRefund(query);
		} else {
			query.setData(null);
		}
		model.put("refundStatusMap", TradeRefundStatus.toMap());
		return "trade/refund/list";
	}
	
	/**
	 * 获取退款的详情
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("detail.htm")
	public String detail(Long orderId, Long refundId,HttpServletRequest request,Model model){
		TradeOrder order = null;
		TradeRefund refund = null;
		if(orderId != null) {
			model.addAttribute("uri", "/order/list.htm");
			order = tradeOrderService.getTradeOrderByOrderId(orderId);
			refund = tradeRefundService.getLastTradeRefundByOrderId(orderId);
		} else if(refundId != null) {
			refund = tradeRefundService.getTradeRefundById(refundId);
			order = tradeOrderService.getTradeOrderByOrderId(refund.getOrderId());
		} else {
			model.addAttribute("message", "无效参数");
			return "error";
		}
		
		if(refund == null || order == null) {
			model.addAttribute("message", "无效参数");
			return "error";
		}
		
		model.addAttribute("refund", refund);	
		model.addAttribute("order", order);
		model.addAttribute("logistic",tradeLogisticService.getTradeLogisticByOrderId(order.getId()));
		model.addAttribute("refundlogistic",tradeLogisticService.getTradeLogistic(order.getId(), refund.getId(), TradeLogisticDirection.buyer2seller));
		model.addAttribute("timeoutList", tradeTimeoutService.getTradeTimeoutByOrderId(order.getId()));
		model.addAttribute("buyer", userAccount.getUserAccountById(order.getBuyerId()));
		model.addAttribute("seller", userAccount.getUserAccountById(order.getSellerId()));
		model.addAttribute("countryList",commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.ACCOUNT_COUNTRY));
		model.addAttribute("orderStatusList", TradeOrderStatus.values());
		model.addAttribute("refundStatusList", TradeRefundStatus.values());
		return "trade/refund/detail";
	}
	
	/**
	 * 仲裁GTE
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="arbitrate.htm", method=RequestMethod.GET)
	public String arbitrate_init(Long id, ModelMap model) {
		TradeRefund refund = tradeRefundService.getTradeRefundById(id);
		if(refund == null) {
			model.put("message", "无效退款单");
			return "error";
		}
		
		TradeOrder order = tradeOrderService.getTradeOrderByOrderId(refund.getOrderId());
		if(order == null) {
			model.put("message", "无效退款单");
			return "error";
		}

		model.put("refund", refund);
		model.put("order", order);
		model.put("logistic",tradeLogisticService.getTradeLogisticByOrderId(order.getId()));
		model.put("refundlogistic",tradeLogisticService.getTradeLogistic(order.getId(), refund.getId(), TradeLogisticDirection.buyer2seller));
		model.put("buyer", userAccount.getUserAccountById(order.getBuyerId()));
		model.put("seller", userAccount.getUserAccountById(order.getSellerId()));
		model.put("countryList",commDatadicCacheService.getCommDatadicsByGroupName(EnumDatadicGroupName.ACCOUNT_COUNTRY));
		model.put("orderStatusList", TradeOrderStatus.values());
		model.put("refundStatusList", TradeRefundStatus.values());
		return "trade/refund/arbitrate";
	}
	
	/**
	 * 仲裁
	 * @param refund
	 * @param judge
	 * @param model
	 * @return
	 */
	@RequestMapping(value="arbitrate.htm", method=RequestMethod.POST)
	public String arbitrate(@ModelAttribute("refund") TradeRefund refund, boolean judge, SystemUserAgent agent, ModelMap model) {
		TradeRefund re_refund = tradeRefundService.getTradeRefundById(refund.getId());
		if(re_refund == null) {
			model.put("message", "无效退款单");
			return "error";
		}
		
		if(judge && !re_refund.getRefundFee().equals(refund.getRefundFee())) {
			re_refund.setRefundFee(refund.getRefundFee());
			if(re_refund.getRefundFee() > re_refund.getTotalFee()) {
				model.put("message", "无效退款金额");
				return "error";
			}
			tradeRefundService.editTradeRefund(re_refund);
		}
		
		Result<Void> result = remoteMallTradeService.judgeRefund(re_refund.getOrderId(), judge, agent.getLoginName(), refund.getJudgeMemo());
		model.put("url", "/refund/list.htm");
		return result.isSuccess() ? "success" : "error";
	}
}
