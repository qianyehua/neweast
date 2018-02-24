package com.skyjoo.neweast.web.action.trade;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skyjoo.neweast.biz.trade.service.TradeLogService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeOrderStatus;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeRefundStatus;
@Controller
public class TradeLogAction extends BaseAction {
	
	@Autowired
	private TradeLogService tradeLogService;
	
	/**
	 * 根据订单号得到订单日志
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/trade/log/detail.htm")
	public String list(HttpServletRequest request,Model model){
		Long orderId = null;
		try{
			orderId = Long.parseLong(request.getParameter("orderId"));
		}catch(NumberFormatException e){
			logger.info("NumberFormatException info:" + e);
		}		
		String buyer = request.getParameter("buyer");
		String seller = request.getParameter("seller");
		model.addAttribute("buyer",buyer);
		model.addAttribute("seller",seller);
		model.addAttribute("list_log", tradeLogService.getTradeLogByOrderId(orderId));
		model.addAttribute("tradeStatusMap",TradeOrderStatus.toMap());
		model.addAttribute("refundStatusList",TradeRefundStatus.values());
		return "trade/log/detail";
	}

}
