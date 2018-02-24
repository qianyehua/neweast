package com.skyjoo.neweast.web.action.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.auth.domain.query.AuthCertQurty;
import com.skyjoo.neweast.biz.auth.service.AuthCertService;
import com.skyjoo.neweast.web.action.BaseAction;

@Controller
public class AuthCertAction extends BaseAction {

    @Autowired
    private AuthCertService authCertService;
    @Autowired
	private MessageDigest passwordMessageDigest;

    /** 鉴定证书列表页面 */
    @RequestMapping(value="/auth_cert/list.htm")
    public String list(@ModelAttribute("query") AuthCertQurty query,
    	ModelMap model) {
    	
    	// trim
    	String certNo = query.getCertNo();
    	if(certNo!=null){
    		query.setCertNo(certNo.trim());
    	}
    	if(!StringUtil.isBlank(query.getInst_id())){
    		query.setInstID(Long.valueOf(query.getInst_id()));
    	}

    	AuthCertQurty page = (AuthCertQurty)authCertService.getPaginatedAuthCertQuery(query);
        model.addAttribute("page", page);
        model.addAttribute("query", query);
        
        return "/auth/cert/list";
    }
    
    /** 鉴定证书详情页面 */
    @RequestMapping(value="/auth_cert/detail.htm")
    public String detail(@RequestParam("id") long id, ModelMap model) {
    	
    	AuthCertQurty query = authCertService.getAuthCertQueryById(id);
    	
    	model.addAttribute("query", query);
    	return "/auth/cert/detail";
    }
    
    /** 删除 */
    @RequestMapping(value="/auth_cert/remove.htm")
    public String remove(@RequestParam("id") long id, Model model) {
		int result = authCertService.remove(id);
		
		String url = "/auth_cert/list.htm";
		return result>0?success(model, url, "删除成功！"):error(model, url, "删除失败！");
    }
    
}
