package com.skyjoo.neweast.web.action.message;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.domain.query.MessageQuery;
import com.skyjoo.neweast.biz.message.service.MessageService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 * 消息管理
 * @author paul
 *
 */
@Controller
@RequestMapping(value="/message")
public class MessageAction extends BaseAction {
	
	@Autowired
	private MessageService messageSerivce;
	
	/**
	 * 获取评论分页
	 * @param request
	 * @param messageQuery
	 * @param model
	 * @return
	 */
	@RequestMapping(value="message_list.htm")
	public String getMessageList(HttpServletRequest request,@ModelAttribute("messageQuery")MessageQuery messageQuery,Model model){
		if(messageQuery.enable()) {
			messageSerivce.getPaginateMessage(messageQuery);
		} else {
			messageQuery.setData(null);
		}
		return "message/list";
	}
	
	/**
	 * 获取评论详情
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="detail.htm")
	public String getMessageDetail(HttpServletRequest request,@RequestParam("id")Long id,Model model){
		Message message = messageSerivce.getMessageDetailById(id);
		model.addAttribute("message", message);
		return "message/detail";
	}
	
	/**
	 * 删除评论
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="delete.htm")
	public String deleteMessageById(HttpServletRequest request,@RequestParam("id")Long id,Model model){
		messageSerivce.deleteMessageById(id);
		return this.redirect("/message/message_list.htm");
	}

}
