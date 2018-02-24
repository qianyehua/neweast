package com.skyjoo.neweast.web.action.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.domain.query.UserAccountQuery;
import com.skyjoo.neweast.biz.account.service.CreditAppraiseService;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditService;
import com.skyjoo.neweast.biz.account.service.UserAccountService;
import com.skyjoo.neweast.biz.common.enums.EnumCountry;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountStatus;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

/**
 * 会员管理
 */
@Controller
@RequestMapping("account/")
public class UserAccountAction extends BaseAction {
	
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserAccountCreditService userAccountCreditService;
	@Autowired
    private CreditAppraiseService creditAppraiseService;
	
	private static final String baseVMPath = "account/";
	private String getReturnPage(String page) {
		return baseVMPath.concat(page);
	}
	
	/**
	 * 会员列表
	 */
	@RequestMapping("list.htm")
	public String list(@ModelAttribute("query") UserAccountQuery query, ModelMap model){
		model.put("countryList", EnumCountry.values());
		model.put("statusList", EnumUserAccountStatus.values());
		userAccountService.getUserAccountPage(query);
		return getReturnPage("list");
	}
	
	/**
	 * 查看详细 
	 */
	@RequestMapping("detail.htm")
	public String accountInfo(@RequestParam("id") Long id, ModelMap model){
		UserAccount account = userAccountService.getUserAccountById(id);
		
		//TODO 处理卖家记录
		
		model.addAttribute("account", account);
		return getReturnPage("detail");
	}
	
	@RequestMapping("appraise.htm")
    public String creditAppraiseList(Long id, ModelMap model) {
		model.put("account", userAccountService.getUserAccountById(id));
		model.put("appraise", creditAppraiseService.statisticCreditAppraiseCount(id));
        model.put("buyerCredit", userAccountCreditService.getByAccountIdAndType(id, EnumUserAccountType.BUYER));
        model.put("sellerCredit", userAccountCreditService.getByAccountIdAndType(id, EnumUserAccountType.SELLER));
		return getReturnPage("credit_appraise");
    }
}
