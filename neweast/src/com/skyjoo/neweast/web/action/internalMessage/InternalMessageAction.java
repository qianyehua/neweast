package com.skyjoo.neweast.web.action.internalMessage;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.internalMessage.domain.CommInternalMessage;
import com.skyjoo.neweast.biz.internalMessage.enums.InternalMessageReplyStatus;
import com.skyjoo.neweast.biz.internalMessage.service.InternalMessageService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
@Controller
public class InternalMessageAction extends BaseAction {
	
	@Autowired
	private InternalMessageService internalMessageService;
	
	/**
	 * 获取站内信列表  分页
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/internalMessage/list.htm")
	public String list(@ModelAttribute("message")CommInternalMessage message,Model model){
		String addressee = message.getAddressee();
		//收件人为“客户服务”
		if( StringUtil.isNotBlank(message.getAddressee()) &&"客户服务".equals(message.getAddressee().trim())){
			message.setAddressee("");
			message.setAddressType(0);
		}
		CommInternalMessage page = (CommInternalMessage) internalMessageService.getPaginateInternalMessage(message);
		page.setAddressee(addressee);//addressee 回填
		model.addAttribute("page",page);
		model.addAttribute("replyStatusMap", InternalMessageReplyStatus.toMap());
		return "internalMessage/list";
	}
	
	/**
	 * 初始化站内信回复
	 * @param request
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/internalMessage/replyIni.htm")
	public String replyIni(HttpServletRequest request,Model model){
		Long messageId = Long.parseLong(request.getParameter("messageId"));
	//	internalMessageService.setHaveRead(messageId);
		model.addAttribute("message", internalMessageService.getInternalMessageById(messageId));
		return "internalMessage/reply";
	}
	
	/**
	 * 站内信回复
	 * @param agent
	 * @param request
	 * @param message
	 * @param model
	 * @return
	 */
	@RequestMapping("/internalMessage/reply.htm")
	public String reply(SystemUserAgent agent, HttpServletRequest request,@ModelAttribute("message")CommInternalMessage message,Model model){
		String pid = request.getParameter("pid");
		//message.setTheme(message.getContent().substring(0, message.getContent().length()>30?30:message.getContent().length()));
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			logger.info("reply message info:" + e);
		}
		String replyTheme = internalMessageService.getInternalMessageById(Long.parseLong(pid)).getTheme();
		if(replyTheme.length() >= 30){
			replyTheme = replyTheme.substring(0, 25);
		}
		message.setTheme("回复:"+replyTheme);
		message.setMessageId(pid);
		message.setUserId(agent.getId());
		Integer addResult = internalMessageService.addInternalMessage(message);
		if(addResult != null){
			return success(model,"/internalMessage/list.htm","回复成功");
		}else{
			return error(model,"/internalMessage/list.htm","");
		}
	}

}
