package com.skyjoo.neweast.web.action.art;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.art.domain.query.ArtConsultingQuery;
import com.skyjoo.neweast.biz.art.service.ArtConsultingService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 * ��ѯ����
 * @author paul
 *
 */
@Controller
@RequestMapping(value="/artConsulting")
public class ArtConsultingAction extends BaseAction {
	@Autowired
	private ArtConsultingService artConsultingService;

	/**
	 * ��ȡ���Է�ҳ
	 * @param request
	 * @param artConsulting
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/consulting_list.htm")
	public String getArtConsultingList(HttpServletRequest request,@ModelAttribute("artConsultingQuery")ArtConsultingQuery artConsulting,Model model){
		if(artConsulting.enable()) {
			artConsultingService.getPaginateArtConsulting(artConsulting);
		} else {
			artConsulting.setData(null);
		}
		return "art/artConsulting/art_consulting_list";
	}
	
	/**
	 * ��ȡ��������
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/detail.htm")
	public String  getArtConsultingDetail(@RequestParam("id")Long id,Model model){
		ArtConsulting artConsulting = artConsultingService.getArtConsultingDetail(id);
		model.addAttribute("artConsulting", artConsulting);
		return "art/artConsulting/detail";
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/delete.htm")
	public String deleteArtConsulting(@RequestParam("id")Long id,Model model){
		artConsultingService.deleteArtConsultingById(id);
		return this.redirect("/artConsulting/consulting_list.htm");
	}
}
