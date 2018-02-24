package com.skyjoo.neweast.web.action.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.shop.domain.ShopPic;
import com.skyjoo.neweast.biz.shop.domain.query.ShopPicQuery;
import com.skyjoo.neweast.biz.shop.service.ShopPicService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

@Controller
@RequestMapping("shop/pic/")
public class ShopPicAction extends BaseAction {
	
	@Autowired
	private ShopPicService shopPicService;
	@Autowired
	private ArtService artService;

	
	private static final String baseVMPath = "shop/pic/";
	private String getReturnPage(String page) {
		return baseVMPath.concat(page);
	}
	
	/**图片审核列表 */
	@RequestMapping(value="list.htm")
	public String list(@ModelAttribute("query") ShopPicQuery query, ModelMap model) {
		
		shopPicService.getShopPicPage(query);
		
		return getReturnPage("list");
	}
	
	/**审核 */
	@RequestMapping(value="audit.htm",method = RequestMethod.GET)
	public String audit(@RequestParam("id") Long id,@RequestParam("status") Integer status,
			SystemUserAgent agent, ModelMap model) {
		
		model.put("url", "/shop/pic/list.htm");
		
		//status
		ShopPic sp = new ShopPic();
		sp.setId(id);
		sp.setStatus(status);
		
		Integer rst = shopPicService.audit(sp);
		if(rst==0) return "error";
		
		//log
		AuditLog log = new AuditLog();
		log.setType("shop_img");//审核类型
		log.setRelatedID(id);//关联ID
		log.setStatus( status.equals(1)?"P":"R" );
		log.setAuditContent("");//审核内容,暂时为空
		log.setMemo("");// 备注 主要是审核不通过原因
		log.setAuditor(agent.getLoginName());//	审核人

		Long result = artService.addAuditLog(log);
		if(result==0) return "error";
		
		return "success";
	}
	
	@RequestMapping(value = "audit", method = RequestMethod.POST )
	public @ResponseBody String deleteMore(HttpServletRequest request, HttpServletResponse response, 
			SystemUserAgent agent,ModelMap model) {
		
		String items = request.getParameter("items");
		Integer status = Integer.valueOf(request.getParameter("status"));
		String[] item = items.split(",");
		
		for (int i = 0; i < item.length; i++) {
			//status
			ShopPic sp = new ShopPic();
			sp.setId(Long.valueOf(item[i]));
			sp.setStatus(status);
			
			Integer rst = shopPicService.audit(sp);
			if(rst==0) return "error";
			
			//log
			AuditLog log = new AuditLog();
			log.setType("shop_img");//审核类型
			log.setRelatedID(Long.valueOf(item[i]));//关联ID
			log.setStatus( status.equals(1)?"P":"R" );
			log.setAuditContent("");//审核内容,暂时为空
			log.setMemo("");// 备注 主要是审核不通过原因
			log.setAuditor(agent.getLoginName());//	审核人

			Long result = artService.addAuditLog(log);
			if(result==0) return "error";
		}
		
		return "success";
	}
	
}
