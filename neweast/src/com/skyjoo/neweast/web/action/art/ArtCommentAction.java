package com.skyjoo.neweast.web.action.art;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.art.domain.query.ArtCommentQuery;
import com.skyjoo.neweast.biz.art.service.ArtCommentService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 * 评论管理
 * @author paul
 *
 */
@Controller
@RequestMapping(value="/artcomment")
public class ArtCommentAction extends BaseAction {
	
	@Autowired
	private ArtCommentService artCommentSerivce;
	
	/**
	 * 获取评论分页
	 * @param request
	 * @param messageQuery
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list.htm")
	public String getArtCommentList(HttpServletRequest request,@ModelAttribute("artCommentQuery")ArtCommentQuery artCommentQuery,Model model){
		if(artCommentQuery.enable()) {
			artCommentSerivce.getPaginateArtComment(artCommentQuery);
		} else {
			artCommentQuery.setData(null);
		}
		return "art/artComment/list";
	}
	
	/**
	 * 获取评论详情
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail.htm")
	public String getMessageDetail(HttpServletRequest request,@RequestParam("id")Long id,Model model){
		ArtComment artComment = artCommentSerivce.getArtCommentDetailById(id);
		model.addAttribute("artComment", artComment);
		return "art/artComment/detail";
	}
	
	/**
	 * 删除评论
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete.htm")
	public String deleteMessageById(HttpServletRequest request,@RequestParam("id")Long id,Model model){
		artCommentSerivce.deleteArtCommentById(id);
		return this.redirect("/artcomment/list.htm");
	}

}
