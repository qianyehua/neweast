package com.skyjoo.neweast.web.action.portal;


import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteStatus;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteType;
import com.skyjoo.neweast.biz.portal.service.PublicNoteService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;


/**
 * �������
 * @author liupc
 * @version 0.1
 * @date 2014-11-4 18:05:23
 */
@Controller
public class PublicNoteAction extends BaseAction {
	
	@Autowired
	PublicNoteService 				publicNoteManager;
	
	public void enumInit(Model model){
		model.addAttribute("noteStatus_map", EnumPublicNoteStatus.toMap());
		model.addAttribute("noteType_map", EnumPublicNoteType.toMap());
	}
	/**
	 * �����б�
	 * @param publicNote
	 * @param model
	 * @return
	 * @throws ParseException
	 * @author liupc
	 */
	@RequestMapping(value = "portal/publicnote/list.htm")
	public String list(PublicNote publicNote, Model model) throws ParseException{
		//��ȡö���б�
		enumInit(model);
		//û���������������
		if (publicNote.getType()==null && publicNote.getStartDate() == null
				&& publicNote.getEndDate() == null 
				&& publicNote.getStatus()== null) {
			publicNote.setStatus(0);
		}
		publicNote = (PublicNote) publicNoteManager.getPaginatedNote(publicNote);
	    model.addAttribute("page", publicNote);
	    return "publicNote/list";
	}
	
	/**
	 * ��ӹ����ʼҳ��
	 * @param PublicNote
	 * @param model
	 * @return
	 * @author liupc
	 */
    @RequestMapping(value = "portal/publicnote/add-init.htm")
    public String addInit(@ModelAttribute("publicNote") PublicNote publicNote,
                          Model model) {
    	//��ȡö���б�
    	enumInit(model);
    	model.addAttribute("publicNote", publicNote);
    	return "publicNote/add";
    }
    
    /**
     * ��ӹ���
     * @param publicNote
     * @param result
     * @param userAgernt
     * @param model
     * @return
     */
    @RequestMapping(value = "portal/publicnote/add.htm")
    public String add(@ModelAttribute("PublicNote") PublicNote publicNote,
    		BindingResult result,SystemUserAgent userAgernt,Model model) {
        publicNote.setOperator(userAgernt.getLoginName());
    	Long i = publicNoteManager.addPublicNote(publicNote);
    	String url = "/portal/publicnote/list.htm";
    	return i!=null?success(model,url,"��ӹ���ɹ�"):error(model,url,"��ӹ���ʧ��");
    }
    
    /**
     *�鿴����ҳ��
     * @param PublicNote
     * @param result
     * @return
     * @author liupc
     */
    @RequestMapping(value = "portal/publicnote/view.htm")
    public String view(@RequestParam("id") Long PublicNoteId,Model model) {
    	//��ȡö���б�
    	enumInit(model);
    	
    	PublicNote publicNote = publicNoteManager.getPublicNote(PublicNoteId);
        model.addAttribute("publicNote", publicNote);
        String url = "/portal/publicnote/list.htm";
        return publicNote!=null?"publicNote/view":error(model,url,"��ȡ�鿴����ʧ��");
    }
	
    /**
     * ��˹����ʼҳ��
     * @param PublicNoteId
     * @param model
     * @return
     */
	@RequestMapping(value = "portal/publicnote/audit-init.htm")
	public String auditInit(@RequestParam("id") Long PublicNoteId,Model model){
		//��ȡö���б�
    	enumInit(model);
    	
		PublicNote publicNote = publicNoteManager.getPublicNote(PublicNoteId);
		model.addAttribute("publicNote", publicNote);
		String url = "/portal/publicnote/list.htm";
		return publicNote!=null?"publicNote/audit":error(model,url,"��ȡ��˶���ʧ��");
	}
	
	/**
	 * ɾ������---�߼�ɾ��
	 * @param PublicNoteId
	 * @param userAgernt
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "portal/publicnote/remove.htm")
	public String remove(@RequestParam("id") Long PublicNoteId,
			SystemUserAgent userAgernt,Model model){
		String url = "/portal/publicnote/list.htm";
		if (PublicNoteId != null) {
			PublicNote publicNote = new PublicNote();
			publicNote.setId(PublicNoteId);
			publicNote.setOperator(userAgernt.getLoginName());
			Integer i = publicNoteManager.removePublicNote(publicNote);
			return i!=null?success(model,url,"ɾ���ɹ�"):error(model,url,"ɾ��ʧ��");
        } else {
            return error(model,url,"δ��ȡ��Ҫɾ����Ŀ��");
        }
	}

    /**
     * ��˹���
     * @param id
     * @param model
     * @param status
     * @param userAgernt
     * @return
     */
    @RequestMapping(value = "portal/publicnote/verify.htm")
    public String verify(@ModelAttribute("PublicNote") PublicNote publicNote,
    		BindingResult result,SystemUserAgent userAgernt,Model model) {
    	publicNote.setOperator(userAgernt.getLoginName());
    	Integer i = publicNoteManager.verifyPublicNote(publicNote);
    	String url = "/portal/publicnote/list.htm";
    	return i!=null?success(model,url,"��˳ɹ�"):error(model,url,"���ʧ��");
    }
}
