/**
 * 信用等级
 */
package com.skyjoo.neweast.web.action.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevelResult;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditLevelService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

/**
 * @author wm
 *
 */
@Controller
public class UserAccountCreditLevelAction extends BaseAction{

	@Autowired
	private UserAccountCreditLevelService creditLevelService;
	
	/**
	 * 信用等级列表
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/creditLevel/list.htm")
	public String list(Model model, HttpServletRequest request){
		String hasNew = request.getParameter("hasNew");
		if(StringUtil.isNotBlank(hasNew)&& Boolean.parseBoolean(hasNew) == true){
			List<UserAccountCreditLevel> newCreditLevel = creditLevelService.getNewUACL();
			model.addAttribute("newLevels", newCreditLevel);
			model.addAttribute("hasNew", true);
		}else{
			List<UserAccountCreditLevel> creditLevel =  creditLevelService.getUACL();
			model.addAttribute("levels", creditLevel);
		}
		
		return "/account/creditLevel/list";
	}
	
	/**
	 * 修改信用等级页面初始化
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping("/account/creditLevel/edit-init.htm")
	public String editInit(@ModelAttribute("result") UserAccountCreditLevelResult result, Model model){
		List<UserAccountCreditLevel> creditLevel =  creditLevelService.getNewestUACL();
		result.setList(creditLevel);
		return "/account/creditLevel/edit";
	}
	
	/**
	 * 修改信用等级
	 * @param result
	 * @param agent
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/account/creditLevel/edit.htm")
	public String edit(@ModelAttribute("result") UserAccountCreditLevelResult result, 
			 SystemUserAgent agent, Model model, HttpServletRequest request){
		String isdel = request.getParameter("isdel");
		List<UserAccountCreditLevel> list = result.getList();
		Map<Integer, UserAccountCreditLevel> map = new HashMap<Integer, UserAccountCreditLevel>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getLevelNo()!=null && list.get(i).getLevelName()!=null &&list.get(i).getLowLimit()!=null )
				map.put(i, list.get(i));
		}
		String[] ids = null;
		if (StringUtil.isNotBlank(isdel)) {
			ids = isdel.split(",");
			for (int i = 0; i < ids.length; i++) {
				if (NumberUtils.isDigits(ids[i])) {
					int id = Integer.parseInt(ids[i]);
					if(id<list.size()){
						map.remove(id);
					}
				}
			}
		}
		if(map.size()>0){
			// 判断是否有相同
			boolean hasSame = false;
			boolean hasSameNo = false;
			boolean hasSameName = false;
			loop:for(int i=0;i<list.size();i++){
				for(int j=0;j<list.size();j++){
					if(map.get(i)!=null && map.get(j)!=null){
						if(i!=j && map.get(i).getLevelNo().compareTo(map.get(j).getLevelNo())==0){
							hasSameNo = true;
							break loop;
						}
						if(i!=j && map.get(i).getLevelName().equals(map.get(j).getLevelName())){
							hasSameName = true;
							break loop;
						}
						if(i!=j && map.get(i).getLowLimit().equals(map.get(j).getLowLimit())){
							hasSame = true;
							break loop;
						}
					}
				}
			}
			
			if(hasSame){
				model.addAttribute("hasSame", true);
				return "/account/creditLevel/edit";
			}
			if(hasSameNo){
				model.addAttribute("hasSameNo", true);
				return "/account/creditLevel/edit";
			}
			if(hasSameName){
				model.addAttribute("hasSameName", true);
				return "/account/creditLevel/edit";
			}
			for(UserAccountCreditLevel level : map.values()){
				if(level!=null){
					level.setOperator(agent.getLoginName());
				}
			}
			Long i = creditLevelService.addNewLevel(map);
			String url = "/account/creditLevel/list.htm";
			return i>0?success(model, url, "修改成功！"):error(model, url, "对不起，操作异常，请重新修改！");
		}else{
			//将所有下一个交易日生效的等级的版本号修改为 当前生效的等级号的版本号-1
			Long validVersion = creditLevelService.getValidVersion()-1;
			List<UserAccountCreditLevel> invalidLevel = creditLevelService.getInvalidUACL();
			if(invalidLevel!=null){
				for(UserAccountCreditLevel level:invalidLevel){
					level.setOperator(agent.getLoginName());
					level.setVersion(validVersion);
					creditLevelService.update(level);
				}
				String url = "/account/creditLevel/list.htm";
				return success(model, url, "修改成功！");
			}
			return null;
		}
	}
}
