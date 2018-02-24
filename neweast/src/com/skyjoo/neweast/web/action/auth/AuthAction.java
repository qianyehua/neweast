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

    /** ���������б�ҳ�� */
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

    /**  ������������չʾ */
    @RequestMapping("/auth/add-init.htm")
    public String addInit(AuthInst systemAuth, Model model) {
        return "/auth/add";
    }

    /**��Ӽ������� */
    @RequestMapping(value = "/auth/add.htm")
    public String add(@ModelAttribute("authInst") AuthInst authInst, BindingResult result,
                      HttpServletRequest request, Model model, SystemUserAgent agent) {
        boolean hasError = false;
        authInst.setOperator(agent.getLoginName());
        
        //��� ���� ��Ϊ��
        if (systemAuthService.checkBlank(authInst.getName())) {
        	hasError = true;
        	model.addAttribute("isNameBlank", true);
        }
        //�����ϵ�绰 ��Ϊ��
        if (systemAuthService.checkBlank(authInst.getTel())) {
            hasError = true;
            model.addAttribute("isTelBlank", true);
        }
        //�����ϵ��ַ ��Ϊ��
//        if (systemAuthService.checkBlank(authInst.getAddress())) {
//            hasError = true;
//            model.addAttribute("isAddressBlank", true);
//        }
        //��� ���� ���ظ� 
        if (systemAuthService.checkNameUnique(authInst)) {
            hasError = true;
            model.addAttribute("hasRegister", true);
        }
        //��� �绰 ��ȷ
        if (systemAuthService.checkcheckTelTrue(authInst)) {
        	hasError = true;
        	model.addAttribute("isTelError", true);
        }
        if (hasError) {
            return "/auth/add";
        }

        Long added = systemAuthService.addAuthInst(authInst);
        String url = "/auth/add-init.htm";
        if(added<=0)error(model, url, "�����������ʧ�ܣ�");
        model.addAttribute("auth", authInst);
        return "/auth/added";
    }

    /**�޸ļ�������ҳ��*/
    @RequestMapping(value = "/auth/edit-init.htm")
    public String editInit(@RequestParam("id") Long authId, @ModelAttribute("authInst") AuthInst authInst, Model model) {
    	authInst = systemAuthService.getAuthInstById(authId);

        model.addAttribute("userId", authId);
        model.addAttribute("authInst", authInst);
        return "/auth/edit";
    }
    
    /**�޸ļ�������**/
    @RequestMapping(value = "/auth/edit.htm")
    public String edit(@ModelAttribute("authInst") AuthInst authInst,
                       HttpServletRequest request, SystemUserAgent agent, Model model) {
    	
    	boolean hasError = false;
        authInst.setOperator(agent.getLoginName());
        
        //��� ���� ��Ϊ��
        if (systemAuthService.checkBlank(authInst.getName())) {
        	hasError = true;
        	model.addAttribute("isNameBlank", true);
        }
        //�����ϵ�绰 ��Ϊ��
        if (systemAuthService.checkBlank(authInst.getTel())) {
            hasError = true;
            model.addAttribute("isTelBlank", true);
        }
        //�����ϵ��ַ ��Ϊ��
//        if (systemAuthService.checkBlank(authInst.getAddress())) {
//            hasError = true;
//            model.addAttribute("isAddressBlank", true);
//        }
        //��� ���� ���ظ� 
        if (systemAuthService.checkNameUnique(authInst)) {
            hasError = true;
            model.addAttribute("hasRegister", true);
        }
        //��� �绰 ��ȷ
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
        return rst>0?success(model, url, "�޸ĳɹ���"):error(model, url, "�޸�ʧ�ܣ�");
    }
    
    /**���� ����*/
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
        if(result<=0)error(model, url, "��������ʧ�ܣ�");
        model.addAttribute("auth", authInst);
        return "/auth/resetpwed";
    }
    
    @RequestMapping(value = "/auth/remove.htm")
    public String remove(@RequestParam("id") Long authId,Model model) {
		
    	int result = systemAuthService.remove(authId);
    	
    	String url = "/auth/list.htm";
    	if(result==-1)return error(model, url, "�û������м���֤�飬����ɾ����");
    	return result>0?success(model, url, "ɾ���ɹ���"):error(model, url, "ɾ��ʧ�ܣ�");
    }
}
