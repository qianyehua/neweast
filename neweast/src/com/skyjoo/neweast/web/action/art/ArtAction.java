/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.web.action.art;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import com.hundsun.wudadao.common.util.MoneyUtil;
import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtLedger;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;
import com.skyjoo.neweast.biz.art.domain.ArtScene;
import com.skyjoo.neweast.biz.art.domain.ArtSceneLink;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.art.enums.EnumArtType;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.art.service.ArtLedgerService;
import com.skyjoo.neweast.biz.art.service.ArtPropertyValueService;
import com.skyjoo.neweast.biz.art.service.ArtSceneLinkService;
import com.skyjoo.neweast.biz.art.service.ArtSceneService;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.common.service.CacheService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.art.EnumArtStatus;
import com.skyjoo.wudadao.common.enums.mall.art.EnumFreightType;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014��11��6�� ����9:08:48
 */
@Controller
public class ArtAction extends BaseAction {

	@Autowired
	private ArtService artService;
	@Autowired
	private ArtCategoryService artCategoryService;
    @Autowired
    private ArtCategoryPropertyService artCategoryPropertyService;
    @Autowired
    private ArtPropertyValueService artPropertyValueService;
	@Autowired
	private ArtSceneService artSceneService;
	@Autowired
	private ArtSceneLinkService artSceneLinkService;
	@Autowired
	private ArtLedgerService artLedgerService;
	@Autowired
	private CacheService cacheService;
	
	/**
	 * ��ȡδ��˵�����Ʒ ��ҳ
	 * @param art
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/check_list.htm")
	public String artCheckQuery_list(HttpServletRequest request,@ModelAttribute("artCheckQuery")ArtCheckQuery art,Model model){
		art.setIsAll(2);
		Long categoryId = art.getCategoryId();
		if(categoryId != null){
			ArtCategory artCategory = artCategoryService.getCategoryListbyId(categoryId);
			if(artCategory.getParentId() == 0){
				art.setArtParentCategoryId(categoryId);
				art.setCategoryId(null);
			}
		}
		//art.setIsArtiseWork(true);
		ArtCheckQuery artCheckQuery = (ArtCheckQuery) artService.getPaginatedArt(art);
		artCheckQuery.setCategoryId(categoryId);
		model.addAttribute("page", artCheckQuery);	
		model.addAttribute("list_menus", cacheService.getArtCategoryNames());
		model.addAttribute("artStatusList", EnumArtStatus.values());
		model.addAttribute("freightTypeList", EnumFreightType.values());
		model.addAttribute("artTypeList", EnumArtType.values());
		return "art/art/check_list";			
	}
	
	/**
	 * ��ȡȫ������Ʒ
	 * @param request
	 * @param art
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/list.htm")
	public String artList(HttpServletRequest request,@ModelAttribute("artCheckQuery")ArtCheckQuery art,Model model){
		art.setIsAll(1);		
		Long categoryId = art.getCategoryId();
		if(categoryId != null){
			ArtCategory artCategory = artCategoryService.getCategoryListbyId(categoryId);
			if(artCategory.getParentId() == 0){
				art.setArtParentCategoryId(categoryId);
				art.setCategoryId(null);
			}
		}	
		//art.setIsArtiseWork(true);
		ArtCheckQuery artCheckQuery = (ArtCheckQuery) artService.getPaginatedAllArt(art);
		artCheckQuery.setCategoryId(categoryId);
		model.addAttribute("page", artCheckQuery);	
		model.addAttribute("list_menus", cacheService.getArtCategoryNames());
		model.addAttribute("artStatusList", EnumArtStatus.values());
		model.addAttribute("freightTypeList", EnumFreightType.values());
		model.addAttribute("artTypeList", EnumArtType.values());
		return "art/art/art_list";		
	}
	
	/**
	 * ��ʼ������Ʒ���
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/check_editIni.htm")
	public String check_editIni(HttpServletRequest request,Model model){
		List<Art> list_art = artService.getArtInformById(Long.parseLong(request.getParameter("artId")));
		if(list_art != null && list_art.size() > 0){
			Art art = list_art.get(0);
			model.addAttribute("art", art);
			model.addAttribute("propertyContent", art.getProperty().split(";"));
			String attach = art.getAttachment();
			if(attach != null && !"".equals(attach)){
				String[] imgStr = attach.split("\\|");
				model.addAttribute("imgStr",imgStr);
			}
		}
		
        List<ArtScene> sceneList = artSceneService.getArtAllSceneList();
        List<ArtSceneLink> sceneLinkList = artSceneLinkService.getByArtId(Long.parseLong(request.getParameter("artId")));
        
        //ȥ����ͼ����
        for (int i=0;i<sceneList.size();i++){
        	ArtScene scene = sceneList.get(i);
        	int j=0;
        	for(;j<sceneLinkList.size();j++){
        		ArtSceneLink link = sceneLinkList.get(j);
        		if(link.getSceneId().equals(scene.getId())){
					break;
				}
        	}
			if(j>=sceneLinkList.size()){
				sceneList.remove(i);
				i--;
			}
		}		
        
        model.addAttribute("sceneList", sceneList);
        model.addAttribute("sceneLinkList", sceneLinkList);
        
		return "art/art/check_edit";
	}
	
	/**
	 * �޸�����Ʒ��Ϣ
	 * @param request
	 * @param art
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unused")
    @RequestMapping("/art/edit.htm")
	public String check_edit(SystemUserAgent agent,HttpServletRequest request,Model model,@ModelAttribute("art") Art art){
        List<Art> list_art  = artService.getArtInformById(Long.parseLong(request.getParameter("artId")));
        if(list_art != null && list_art.size() > 0){
           art = list_art.get(0);
        }else{
            return "error";
        }
        
        if(EnumArtStatus.DELETE.getValue().equals(art.getStatus())||EnumArtStatus.DOWN.getValue().equals(art.getStatus())){
            model.addAttribute("message","����Ʒ/��Ʒ�Ѿ�ɾ�������¼ܣ�������ˢ���б�");
            model.addAttribute("url","/art/check_list.htm");
            return "error";
        }
        
        if(Integer.parseInt(request.getParameter("checkResult")) == 1){
            if(EnumArtType.ARTUNSELL.getValue().equals(art.getType())){
                art.setStatus(5);
            }else{
                art.setStatus(Integer.parseInt(request.getParameter("checkResult")));
            }
        }else{
            art.setStatus(Integer.parseInt(request.getParameter("checkResult"))); 
        }

        art.setOperator(agent.getLoginName());
        if(art==null) return "error";
        int editResult = artService.editArt(art);
        
        //�������ˮ�������¼�����־
        AuditLog log = new AuditLog();
        log.setType("art");//�������
        log.setRelatedID(art.getId());//����ID
//      log.setAuditContent(art.getMemo());//�������
//      STATUS  ״̬
        String status = "R";// R���ܾ�
        if(Integer.parseInt(request.getParameter("checkResult"))==1){
            status = "P";//P ͨ��
        }
        log.setStatus(status);
        log.setAuditContent("");//�������,��ʱΪ��
        log.setMemo(art.getMemo());// ��ע ��Ҫ����˲�ͨ��ԭ��
        log.setAuditor(agent.getLoginName());// �����

        Long result = artService.addAuditLog(log);
        if(result==0) return "error";
        //-------
        
        String url = "/art/check_list.htm";     
        return editResult == 0 ? "error":success(model,url,"�����ɹ�");
	}
	
	/**
	 * ��ȡ����Ʒ����
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/art/detail.htm")
	public String artDetail(@RequestParam("come")String come,HttpServletRequest request,Model model){	
		String uri = "";
		if(come.equals("1")){
			uri="/art/list.htm";
		}else{
			uri="/order/list.htm";
		}
		model.addAttribute("uri", uri);
		//��ȡ����Ʒ���� 
		List<Art> list_art = artService.getArtInformById(Long.parseLong(request.getParameter("artId")));
		if(list_art != null && list_art.size() > 0){
			Art art = list_art.get(0);
			model.addAttribute("art", art);	
			String[] propertyContent = art.getProperty().split(";");	
			model.addAttribute("propertyContent", propertyContent);
			String attach = list_art.get(0).getAttachment();
				if(attach != null && !"".equals(attach)){
				String[] imgStr = attach.split("\\|");
				model.addAttribute("imgStr",imgStr);
			}
		}
		
		
        List<ArtScene> sceneList = artSceneService.getArtAllSceneList();
        List<ArtSceneLink> sceneLinkList = artSceneLinkService.getByArtId(Long.parseLong(request.getParameter("artId")));
        
        //ȥ����ͼ����
        for (int i=0;i<sceneList.size();i++){
        	ArtScene scene = sceneList.get(i);
        	int j=0;
        	for(;j<sceneLinkList.size();j++){
        		ArtSceneLink link = sceneLinkList.get(j);
        		if(link.getSceneId().equals(scene.getId())){
					break;
				}
        	}
			if(j>=sceneLinkList.size()){
				sceneList.remove(i);
				i--;
			}
		}		
        
        model.addAttribute("sceneList", sceneList);
        model.addAttribute("sceneLinkList", sceneLinkList);
        
		return "art/art/detail";
	}
	
	
	/**ǿ���¼�ҳ�� By LZW**/
	@RequestMapping("/art/offshelf.htm")
	public String offshelf(@RequestParam("artId") long artId,SystemUserAgent agent,Model model){
		List<Art> artList = artService.getArtListById(artId);
		model.addAttribute("art", artList.get(0));
		return "art/art/offshelf";
	}
	
	/**ǿ���¼� By LZW**/
	@RequestMapping("/art/off.htm")
	public String off(@ModelAttribute("art") Art art,SystemUserAgent agent,Model model){

		if(StringUtil.isBlank(art.getMemo())){
			model.addAttribute("errorMessage", "�������¼�ԭ��");
//			model.addAttribute("art", art);
			return "art/art/offshelf";
		}
		art.setOperator(agent.getLoginName());
		int i = artService.offshelf(art);
		String url=  "/art/list.htm";
		return i == 0 ? "error":success(model,url,"�����ɹ�");
	}
	
	@RequestMapping(value= "art/ledger.htm",method=RequestMethod.GET)
	public String initLedger(@RequestParam("artId")String artId,@RequestParam("ledgerId")Long ledgerId, SystemUserAgent agent,Model model){
        if(artId==null || artId == ""){
            model.addAttribute("errorMessage", "û�иò�Ʒ");
            redirect("/art/list.htm");
        }
        
        ArtLedger artLedger = null;
        if(ledgerId !=null && ledgerId != 0){
            artLedger  = artLedgerService.getArtLedgerById(ledgerId);
        }
        
	    List<Art> art = artService.getArtInformById(Long.parseLong(artId));
	    model.addAttribute("artId",artId);
	    model.addAttribute("price", MoneyUtil.getMoneyDesc((art.get(0).getPrice())));
	    model.addAttribute("ledgerId", ledgerId);
	    model.addAttribute("artLedger",artLedger);
	    return "art/art/ledger"; 
	}
	
	@RequestMapping(value="art/ledger.htm",method=RequestMethod.POST)
	public String addLedger(@ModelAttribute("ledger")ArtLedger artLedger,SystemUserAgent agent,Model model){
	    if(artLedger.getArtId()==null){
	        model.addAttribute("errorMessage", "û�иò�Ʒ");
	        return "art/art/ledger";
	    }
	    //Ϊ������������Ϊ�������
	    if(artLedger.getId()==null){
	        artLedger.setOperator(agent.getLoginName());
	        artLedgerService.insertArtLedger(artLedger);
	    }else{
	        artLedgerService.updateArtLedger(artLedger);
	    }
	    return redirect("/art/list.htm");
	}
	
	/**
	 * ����Ǩ��
	 * @param art
	 * @param id
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/art/edit-init.htm", method = RequestMethod.GET)
    public String editInit(Art art, Long id, Model model) {
        List<Art> a = artService.getArtListById(id);

        if (a == null || a.size() == 0 || a.get(0) == null) {
            model.addAttribute("errorMessage", "����Ʒ������");
            return redirect("/art/list.htm");
        }

        art = a.get(0);

        List<ArtCategory> artCategories = cacheService.getArtCategories();
        //��ȡ����Ʒ����
        Iterator<ArtCategory> iterator = artCategories.iterator();
        ArtCategory category = null;
        while (iterator.hasNext()) {
            ArtCategory ac = iterator.next();
            if (ac.getId().equals(art.getCategoryId())) {
                category = ac;
                break;
            }
        }
        if (category == null) {
            model.addAttribute("errorMessage", "����Ʒ��Ŀ������");
            return redirect("/art/list.htm");
        }
        art.setFirstCategory(category.getParentId());
        
        //���˶���Ϊ�յķ���
        for (int i = 0; i < artCategories.size(); i++) {
            if (StringUtil.isBlank(artCategories.get(i).getArtCode())
                && artCategories.get(i).getCatLevel() == 2) {
                artCategories.remove(i);
            }
        }
        //����һ����Ŀ
        for (int i = 0; i < artCategories.size(); i++) {
            if (artCategories.get(i).getParentId() == 0) {
                for (int j = 0; j < artCategories.size(); j++) {
                    if (artCategories.get(i).getId().equals(artCategories.get(j).getParentId())) {
                        break;
                    } else {
                        if (j + 1 == artCategories.size()) {
                            artCategories.remove(i);
                            i--;
                        }
                    }
                }
            }
        }

        StringBuilder cateInfo = new StringBuilder("");
        for(ArtCategory ac : artCategories){
            if(ac.getId().equals(art.getFirstCategory())){
                cateInfo.insert(0, ac.getName()+"-->");
            }
            if(ac.getId().equals(art.getCategoryId())){
                cateInfo.append(ac.getName());
            }
        }
        
        // ��ȡ��������ֵ
        List<ArtCategoryProperty> artProperty = artCategoryPropertyService
            .getArtCategoryPropertyListForHomepage();
        List<ArtPropertyValue> artPropertyValues = artPropertyValueService
            .getArtPropertyValuesByArtId(art.getId());

        //ƴװ����Ʒ����ֵ
        List<String> artOption = new ArrayList();
        if(category != null && category.getProperties() != null){
            for(ArtCategoryProperty acp : category.getProperties()){
                String s = acp.getContent() + "��";
                if(acp.getPropertyType() == 3 || acp.getPropertyType() == 4){
                     for(ArtPropertyValue apv : artPropertyValues){
                         if(apv.getPropertyId().equals(acp.getId())){
                             s += apv.getArtOption();
                         }
                     }
                }else if(acp.getPropertyType() == 1){
                    for(ArtPropertyOption apo : acp.getOptions()){
                        for(ArtPropertyValue apv : artPropertyValues){
                            if(apv.getArtOption().equals(apo.getId().toString())){
                                s += apo.getContent();
                            }
                        }
                    }
                }else{
                    for(ArtPropertyOption apo : acp.getOptions()){
                        for(ArtPropertyValue apv : artPropertyValues){
                            if(!apv.checkOption(apo.getId())){
                                s += apo.getContent()+" ";
                            }
                        }
                    } 
                }
                artOption.add(s);
            }
        }
        
        model.addAttribute("cateInfo", cateInfo);
        model.addAttribute("artOption", artOption);
        model.addAttribute("artCategories", artCategories);
        model.addAttribute("art", art);
        model.addAttribute("artProperty", artProperty);
        model.addAttribute("artPropertyValues", artPropertyValues);

        return "art/art/edit";
    }
 
    @RequestMapping(value = "/art/editCat.htm", method = RequestMethod.POST)
    public String edit(Art art, HttpServletRequest request, Model model) {
        //��ȡ����������Լ�����ֵ
        List<ArtPropertyValue> artPropertyValues = getArtPropertyValues(art, request);
        art.setArtPropertyValues(artPropertyValues);

        Integer res = artService.editCategory(art);

        if (res < 0) {
            model.addAttribute("errorMessage", "����ʧ��");
            return redirect("/art/edit-init.htm?id=" + art.getId());
        }

        return success(model, "/art/list.htm", "�����ɹ�");
    }
	
    public List<ArtPropertyValue>  getArtPropertyValues(Art art,HttpServletRequest request ){
        // ��ȡ����ֵ
        List<ArtPropertyValue> artPropertyValues = new ArrayList<ArtPropertyValue>();
        List<ArtCategoryProperty> categoryProperties = cacheService.getArtCategoryProperties();
        for (int i = 0; i < categoryProperties.size(); i++) {
            String value = null;
            String s = ""+ categoryProperties.get(i).getId();
            if(categoryProperties.get(i).getCategoryId() != null){
                s += categoryProperties.get(i).getCategoryId();
            }
            if (categoryProperties.get(i).getPropertyType() == 2) {
                String[] values = (String[]) request.getParameterValues(s);
                if (values != null) {
                    if (values.length != 1) {
                        value = values[0] + ",";
                        for (int j = 1; j < values.length - 1; j++) {
                            value = value + values[j] + ",";
                        }
                        value = value + values[values.length - 1];
                    } else {
                        value = values[0];
                    }
                }
            } else {
                value = request.getParameter(s);
            }

            if (value != null) {
                ArtPropertyValue artPropertyValue = new ArtPropertyValue();
                artPropertyValue.setPropertyId(categoryProperties.get(i).getId());
                artPropertyValue.setArtOption(value);
                artPropertyValues.add(artPropertyValue);
            }
        }
        
        return artPropertyValues;
    };  
}
