/**
 * 
 */
package com.skyjoo.neweast.web.action.trade;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRate;
import com.skyjoo.neweast.biz.trade.domain.TradeCommisionRateResult;
import com.skyjoo.neweast.biz.trade.service.TradeCommisionRateService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 * @author wm
 *
 */
@Controller
public class TradeCommisionRateAction extends BaseAction{

	@Autowired
	private TradeCommisionRateService commisionRateService;

	/**
	 * Ӷ��ȼ��б�
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/trade/commision/list.htm")
	public String list(Model model, HttpServletRequest request){
		String hasNew = request.getParameter("hasNew");
		if(StringUtil.isNotBlank(hasNew)&& Boolean.parseBoolean(hasNew) == true){
			List<TradeCommisionRate> newLevel = commisionRateService.getNewTCR();
			if(newLevel!=null && newLevel.size()>0){//��->Ԫ
				for (TradeCommisionRate rate : newLevel) {
					rate.setMinCommision( rate.getMinCommision().divide(new BigDecimal("100")) );
				}
			}
			model.addAttribute("newLevels", newLevel);
			model.addAttribute("hasNew", true);
		}else{
			List<TradeCommisionRate> level =  commisionRateService.getTCR();
			if(level!=null && level.size()>0){//��->Ԫ
				for (TradeCommisionRate rate : level) {
					rate.setMinCommision( rate.getMinCommision().divide(new BigDecimal("100")) );
				}
			}
			model.addAttribute("levels", level);
		}
		return "/trade/commision/list";
	}
	
	/**
	 * �޸�Ӷ��ȼ�ҳ���ʼ��
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/trade/commision/edit-init.htm")
	public String editInit(@ModelAttribute("result") TradeCommisionRateResult result, Model model){
		List<TradeCommisionRate> level =  commisionRateService.getNewestTCR();
		if(level!=null && level.size()>0){//��->Ԫ
			for (TradeCommisionRate rate : level) {
				rate.setMinCommision( rate.getMinCommision().divide(new BigDecimal("100")) );
			}
		}
		result.setList(level);
		return "/trade/commision/edit";
	}
	
	/**
	 * �޸�Ӷ��ȼ�
	 * @param result
	 * @param agent
	 * @param model
	 * @return
	 */
	@RequestMapping("/trade/commision/edit.htm")
	public String edit(@ModelAttribute("result") TradeCommisionRateResult result, 
			 SystemUserAgent agent, Model model){
			List<TradeCommisionRate> list = result.getList();
			for(TradeCommisionRate level : list){
				level.setOperator(agent.getLoginName());
				level.setMinCommision( level.getMinCommision().multiply(new BigDecimal("100")) );//Ԫ->��
			}
			Long i = commisionRateService.addNewLevel(list);
			String url = "/trade/commision/list.htm";
			return i>0?success(model, url, "�޸ĳɹ���"):error(model, url, "�Բ��𣬲����쳣���������޸ģ�");
	}
}
