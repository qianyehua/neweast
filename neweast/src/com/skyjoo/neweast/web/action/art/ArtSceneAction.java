package com.skyjoo.neweast.web.action.art;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.art.service.ArtSceneService;
import com.skyjoo.neweast.web.action.BaseAction;

@Controller
@RequestMapping("/art/artScene")
public class ArtSceneAction extends BaseAction {
	
	@Autowired
	private ArtSceneService    artSceneService; 
	
	
	/**
	 * ��ȡ�����б�
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/scene_list.htm",method=RequestMethod.GET)
	public String senceList(HttpServletRequest request,Model model,@ModelAttribute("artScene")ArtScene artScene){
		artSceneService.getPaginatedScene(artScene);
		model.addAttribute("page", artScene);	
		//model.addAttribute("list_menus", artCategoryService.getArtCategoryNames());
		return "art/artScene/scene_list";
	} 
	
	
	/**
	 * ��ת����б�
	 * @param artScene
	 * @param result
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/scene_add.htm",method=RequestMethod.GET)
	private String toaddScene(@ModelAttribute("artScene")ArtScene artScene,BindingResult result,Model model){
		model.addAttribute("artScene", artScene);
		return "art/artScene/add";
	}
	
	/**
	 * ��������Ʒ����
	 * @param artScene
	 * @param result
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="/scene_add.htm",method=RequestMethod.POST)
	private String addScene(@ModelAttribute("artScene")ArtScene artScene,BindingResult result,Model model){
		model.addAttribute("artScene", artScene);
		String url = "/art/artScene/scene_list.htm";
		Long addResult = artSceneService.saveArtScene(artScene);
		return addResult.compareTo(0L) == 0 ? error(model,url,"���ʧ��") : success(model,url,"��ӳɹ�");

	}
	
	/**
	 * ��ת����Ʒ�����޸�
	 * @param artScene
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/scene_edit.htm",method=RequestMethod.GET)
	public String toeditScene(@ModelAttribute("artScene")ArtScene artScene,BindingResult result,Model model){
		artScene = artSceneService.getArtSceneById(artScene.getId());
		model.addAttribute("artScene", artScene);
		return "art/artScene/edit";
	}
	
	/**
	 * ��������Ʒ�޸�
	 * @param artScene
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/scene_edit.htm",method=RequestMethod.POST)
	public String editScene(@ModelAttribute("artScene")ArtScene artScene,BindingResult result,Model model){
		String url = "/art/artScene/scene_list.htm";
		int editResult =  artSceneService.editScene(artScene);
		return editResult == 0 ? error(model,url,"�޸�ʧ��") : success(model,url,"�޸ĳɹ�");
	}
	
	@RequestMapping(value="/scene_disable.htm",method=RequestMethod.GET)
	public String sceneDisable(@ModelAttribute("artScene")ArtScene artScene,BindingResult result,Model model){
		String url = "/art/artScene/scene_list.htm";
		int editResult =  artSceneService.editScene(artScene);
		return editResult == 0 ? error(model,url,"�޸�ʧ��") : success(model,url,"�޸ĳɹ�");	
	}
	
	/**
	 * jQuery ajax��֤��������Ψһ��
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/checkSceneName.htm")
	public void checkCategoryName(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String sceneName = request.getParameter("sceneName");
		if(sceneName == null || "".equals(sceneName)){
			return ;
		}
		ArtScene pagescene = new ArtScene();
		List<ArtScene> scenes= artSceneService.getArtSceneAll(pagescene);
		for(ArtScene scene : scenes){
			if(sceneName.equals(scene.getName())){
				response.getWriter().write("�ó������Ѿ�����");
				return;
			}
		} 
		response.getWriter().write("�ó���������ʹ��");
	}

}
