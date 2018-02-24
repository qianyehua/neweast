package com.skyjoo.neweast.web.action.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eyeieye.melos.util.digest.MessageDigest;
import com.skyjoo.neweast.biz.auth.domain.AuthInst;
import com.skyjoo.neweast.biz.auth.service.AuthInstService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

@Controller
public class AuthAction extends BaseAction {

    @Autowired
    private AuthInstService systemAuthService;
    @Autowired
	private MessageDigest passwordMessageDigest;

    /** 鉴定机构列表页面 */
    @RequestMapping(value = "/auth/list.htm")
    public String list(AuthInst authInst, Model model) {

    	// trim
    	String name = authInst.getName();
//    	if(name!=null)
//    		authInst.setName(name.trim()+'%');
    	String tel = authInst.getTel();
    	if(tel!=null)
    		authInst.setTel(tel.trim());
    	String account = authInst.getAccount();
    	if(name!=null)
    		authInst.setAccount(account.trim());
    	
    	AuthInst page = (AuthInst)systemAuthService.getPaginatedAuthInst(authInst);
    	
        model.addAttribute("page", page);
        model.addAttribute("authInst", authInst);
        
        return "/auth/list";
    }

    /**  鉴定机构新增展示 */
    @RequestMapping("/auth/add-init.htm")
    public String addInit(AuthInst systemAuth, Model model) {
        return "/auth/add";
    }

    /**添加鉴定机构 */
    @RequestMapping(value = "/auth/add.htm")
    public String add(@ModelAttribute("authInst") AuthInst authInst, BindingResult result,
                      HttpServletRequest request, Model model, SystemUserAgent agent) {
        boolean hasError = false;
        authInst.setOperator(agent.getLoginName());
        
        //检查 名字 不为空
        if (systemAuthService.checkBlank(authInst.getName())) {
        	hasError = true;
        	model.addAttribute("isNameBlank", true);
        }
        //检查联系电话 不为空
        if (systemAuthService.checkBlank(authInst.getTel())) {
            hasError = true;
            model.addAttribute("isTelBlank", true);
        }
        //检查联系地址 不为空
//        if (systemAuthService.checkBlank(authInst.getAddress())) {
//            hasError = true;
//            model.addAttribute("isAddressBlank", true);
//        }
        //检查 名字 不重复 
        if (systemAuthService.checkNameUnique(authInst)) {
            hasError = true;
            model.addAttribute("hasRegister", true);
        }
        //检查 电话 正确
        if (systemAuthService.checkcheckTelTrue(authInst)) {
        	hasError = true;
        	model.addAttribute("isTelError", true);
        }
        if (hasError) {
            return "/auth/add";
        }

        Long added = systemAuthService.addAuthInst(authInst);
        String url = "/auth/add-init.htm";
        if(added<=0)error(model, url, "鉴定机构添加失败！");
        model.addAttribute("auth", authInst);
        return "/auth/added";
    }

    /**修改鉴定机构页面*/
    @RequestMapping(value = "/auth/edit-init.htm")
    public String editInit(@RequestParam("id") Long authId, @ModelAttribute("authInst") AuthInst authInst, Model model) {
    	authInst = systemAuthService.getAuthInstById(authId);

        model.addAttribute("userId", authId);
        model.addAttribute("authInst", authInst);
        return "/auth/edit";
    }
    
    /**修改鉴定机构**/
    @RequestMapping(value = "/auth/edit.htm")
    public String edit(@ModelAttribute("authInst") AuthInst authInst,
                       HttpServletRequest request, SystemUserAgent agent, Model model) {
    	
    	boolean hasError = false;
        authInst.setOperator(agent.getLoginName());
        
        //检查 名字 不为空
        if (systemAuthService.checkBlank(authInst.getName())) {
        	hasError = true;
        	model.addAttribute("isNameBlank", true);
        }
        //检查联系电话 不为空
        if (systemAuthService.checkBlank(authInst.getTel())) {
            hasError = true;
            model.addAttribute("isTelBlank", true);
        }
        //检查联系地址 不为空
//        if (systemAuthService.checkBlank(authInst.getAddress())) {
//            hasError = true;
//            model.addAttribute("isAddressBlank", true);
//        }
        //检查 名字 不重复 
        if (systemAuthService.checkNameUnique(authInst)) {
            hasError = true;
            model.addAttribute("hasRegister", true);
        }
        //检查 电话 正确
        if (systemAuthService.checkcheckTelTrue(authInst)) {
        	hasError = true;
        	model.addAttribute("isTelError", true);
        }
        if (hasError) {
            return "/auth/edit";
        }
        
        int rst = systemAuthService.editAuthInst(authInst);
        String url = "/auth/list.htm";
        model.addAttribute("auth", authInst);
        return rst>0?success(model, url, "修改成功！"):error(model, url, "修改失败！");
    }
    
    /**重置 密码*/
    @RequestMapping(value = "/auth/resetpw.htm")
    public String resetpw(@RequestParam("id") Long authId, 
    		@ModelAttribute("authInst") AuthInst authInst, 
    		SystemUserAgent agent,
    		Model model) {
    	
    	authInst = systemAuthService.getAuthInstById(authId);
    	authInst.setOperator(agent.getLoginName());
    	
    	int result = systemAuthService.resetpw(authInst);
    	
        model.addAttribute("userId", authId);
        model.addAttribute("authInst", authInst);
        String url = "/auth/list";
        if(result<=0)error(model, url, "重置密码失败！");
        model.addAttribute("auth", authInst);
        return "/auth/resetpwed";
    }
    
    @RequestMapping(value = "/auth/remove.htm")
    public String remove(@RequestParam("id") Long authId,Model model) {
		
    	int result = systemAuthService.remove(authId);
    	
    	String url = "/auth/list.htm";
    	if(result==-1)return error(model, url, "该机构还有鉴定证书，不能删除！");
    	return result>0?success(model, url, "删除成功！"):error(model, url, "删除失败！");
    }
}
