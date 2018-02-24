package com.skyjoo.neweast.web.action.art;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;
import com.skyjoo.neweast.biz.art.enums.EnumArtCategoryPropertyType;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtPropertyOptionService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;

@Controller
public class ArtCategoryPropertyAction extends BaseAction {

    @Autowired
    private ArtCategoryPropertyService artCategoryProperty;
    @Autowired
    private ArtPropertyOptionService artPropertyOptionService;
 
    /**
     * ��ȡָ����Ŀ������
     * @param request
     * @param model
     * @return  
     */
    @RequestMapping("/art/artCategoryProperty/list.htm")
    public String getCategoryPropertyByCatId(HttpServletRequest request, Model model) {
        String categoryId = request.getParameter("categoryId");
        String parentId = request.getParameter("parentId");
        String propertyId = request.getParameter("propertyId");

        if (StringUtils.isBlank(categoryId) && StringUtils.isBlank(parentId)
            && StringUtils.isNotBlank(propertyId)) {
            return redirect("/art/wholeCategoryProperty/list.htm");
        }
        Long catId = Long.parseLong(categoryId);
        List<ArtCategoryProperty> list_property = artCategoryProperty
            .getCategoryPropertyByCatId(catId);
        model.addAttribute("categoryId", catId);
        model.addAttribute("parentId", parentId);
        model.addAttribute("list_property", list_property);
        return "art/artCategoryProperty/list";
    }

    /**
     * ��ȡȫ������
     * @param request
     * @param mode
     * @return
     */
    @RequestMapping("/art/wholeCategoryProperty/list.htm")
    public String getWholeCategoryProperty(HttpServletRequest request, Model model) {
        List<ArtCategoryProperty> wholeProperty = artCategoryProperty.getWholeProperty();
        model.addAttribute("list_wholeProperty", wholeProperty);
        return "/art/wholeCategoryProperty/list";

    }

    /**
     * ��ʼ���޸�
     * @param request
     * @param property
     * @param model
     * @return
     */
    @RequestMapping("/art/artCategoryProperty/editIni.htm")
    public String editCategoryPropertyIni(HttpServletRequest request,
                                          @ModelAttribute("property") ArtCategoryProperty property,
                                          Model model) {
        Long propertyId = Long.parseLong(request.getParameter("propertyId"));
        String cateID = request.getParameter("categoryId");
        Long categoryId= null;
        if (cateID != null && !cateID.equals("")){
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }        
        ArtCategoryProperty categoryProperty = artCategoryProperty.getNewCategoryPropertyById(propertyId,categoryId);
        model.addAttribute("categoryId", request.getParameter("categoryId"));
        model.addAttribute("property", categoryProperty);
        model.addAttribute("parentId", request.getParameter("parentId"));
        if(categoryId==null){
            model.addAttribute("artCount", 0);
        }else{
        model.addAttribute("artCount", artCategoryProperty.getartCountByCategoryProperty(propertyId, categoryId));
        }
        return "art/artCategoryProperty/edit";
    }

    /**
     * �޸�ָ����Ŀ������
     * @param request
     * @param property
     * @param model
     * @return
     */
    @RequestMapping("/art/artCategoryProperty/edit.htm")
    public String editCategoryProperty(SystemUserAgent agent, HttpServletRequest request,
                                       @ModelAttribute("property") ArtCategoryProperty property,
                                       Model model) {
        String cateID = request.getParameter("categoryId");
        Long propertyId = Long.parseLong(request.getParameter("propertyId"));
        property.setId(propertyId);
        property.setOperator(agent.getLoginName());
        String url = "/art/wholeCategoryProperty/list.htm";
        Long categoryId =null;
        if (cateID != null && !cateID.equals("")) {
             categoryId = Long.parseLong(request.getParameter("categoryId"));
            url = "/art/artCategoryProperty/list.htm?categoryId="
                  + request.getParameter("categoryId") + "&parentId="
                  + request.getParameter("parentId");
        }
        //�ж����������Ƿ��Ѿ�����
        Long IsnameId = artCategoryProperty.selectPropertyIdByName(property.getContent());
        //�������,�϶���˽������
        if(IsnameId!=null && !IsnameId.equals(propertyId)){
            //�޸Ĺ�����
            int edResult =artCategoryProperty.editCategoryXProperty(categoryId, IsnameId, propertyId);
            ArtCategoryProperty categoryProperty = artCategoryProperty.selectPropertyNameById(propertyId);
            if(!property.getContent().equals(categoryProperty.getContent()) && artCategoryProperty.getOtherCategoryProperty(propertyId, categoryId)==0){
                //ɾ��ԭ����ֵ
                artCategoryProperty.removeCategoryProperty(propertyId,categoryId);
            }else{
                //ɾ��Ԫ����ѡ��
                artPropertyOptionService.deleteOptionByPropertyID(propertyId, categoryId);
            }         
        }else if((IsnameId!=null && IsnameId.equals(propertyId))){
            //���޸�����
            int editPnameResult = artCategoryProperty.editCategoryProperty(property);
        }else {
        //�ж�������Ŀ�Ƿ���ͬ������,�����������������
        int count = artCategoryProperty.getOtherCategoryProperty(propertyId, categoryId);
        //������ȫ�����Ի���˽������
        if(categoryId != null) {
            //ɾ��Ԫ����ѡ��
            artPropertyOptionService.deleteOptionByPropertyID(propertyId, categoryId);
            
        }
        ArtCategoryProperty artCategoryPropertye = new ArtCategoryProperty();
        artCategoryPropertye.setContent(property.getContent());
        artCategoryPropertye.setOperator(agent.getLoginName());
        if(count == 0){
            artCategoryPropertye.setId(propertyId);
            //�޸�������
            int editPnameResult = artCategoryProperty.editCategoryProperty(artCategoryPropertye);
            if(editPnameResult == 0){
                return error(model, url, "�޸�ʧ��");
            }
        }else if(count > 0){
            artCategoryPropertye.setOrdering(property.getOrdering());
            artCategoryPropertye.setType(EnumArtCategoryPropertyType.Private.getValue());
            artCategoryPropertye.setPropertyType(property.getPropertyType());
            //���������� 
            Long PnameId = artCategoryProperty.addnewCategoryProperty(artCategoryPropertye);
            if(PnameId == null){
                return error(model, url, "�޸�ʧ��");
                }
            //�޸Ĺ�����
            int edResult =artCategoryProperty.editCategoryXProperty(categoryId, PnameId, propertyId);      
            if(edResult == 0){
                return error(model, url, "�޸Ĺ�����ʧ��");
                }
            }
        }                
            return  success(model, url, "�޸ĳɹ�");
        
    }

    /**
     * ��ʼ��������Բ���
     * @param request
     * @param property
     * @param model
     * @return
     */
    @RequestMapping("/art/artCategoryProperty/addIni.htm")
    public String addCategoryPropertyIni(HttpServletRequest request,
                                         @ModelAttribute("property") ArtCategoryProperty property,
                                         Model model) {
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("parentId", request.getParameter("parentId"));
        return "art/artCategoryProperty/add";
    }

    /**
     * ���˽������
     * @param request
     * @param property
     * @param model
     * @return
     */
    @RequestMapping("/art/artCategoryProperty/add.htm")
    public String addCategoryProperty(SystemUserAgent agent, HttpServletRequest request,
                                      @ModelAttribute("property") ArtCategoryProperty property,
                                      Model model) {
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));
        //����һ����Ŀ���ֻ�����5������
        if (artCategoryProperty.getCategoryPropertyByCatId(categoryId).size() >= 5) {
            return error(model, "/art/artCategoryProperty/list.htm?categoryId=" + categoryId,
                "���ֻ��Ϊ����Ŀ���5������");
        }
        property.setOperator(agent.getLoginName());
        //˽������
        property.setType(EnumArtCategoryPropertyType.Private.getValue());
        //�Ƿ����ͬ��������
        Long nameId = artCategoryProperty.selectPropertyIdByName(property.getContent());
        String msg = "��ӳɹ�";
        CategoryProperty  categoryProperty =  new CategoryProperty();
        if (nameId == null) {
            Long Id = artCategoryProperty.addnewCategoryProperty(property);
            categoryProperty.setPropertyId(Id);
        } else {
            //�ж�������Ŀ�Ƿ���ͬ������,������������Ͳ����仯
           int count = artCategoryProperty.getartCategoryPropertyCount(nameId, null, null);
           if(count != 0){
               msg ="������ӳɹ�,�����ڸ��������Ѿ�����������Ŀ,���������Ͳ������仯!";
           } 
           categoryProperty.setPropertyId(nameId);
        }       
        categoryProperty.setCategoryId(categoryId);

        Long addResult = artCategoryProperty.addCategoryProperty(categoryProperty);
        String url = "/art/artCategoryProperty/list.htm?categoryId=" + categoryId + "&parentId="
                     + request.getParameter("parentId");
        return addResult == null ? error(model, url, "���ʧ��") : success(model, url, msg);
    }

    /**
     * ���ȫ�����Գ�ʼ��
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/art/wholeCategoryProperty/addIni.htm")
    public String addwholeCategoryPropertyIni(HttpServletRequest request,
                                              @ModelAttribute("property") ArtCategoryProperty property,
                                              Model model) {
        return "/art/wholeCategoryProperty/add";
    }

    /**
     * ���ȫ������
     * @param agent
     * @param request
     * @param property
     * @param model
     * @return
     */
    @RequestMapping("/art/wholeCategoryProperty/add.htm")
    public String addwholeCategoryProperty(SystemUserAgent agent,
                                           HttpServletRequest request,
                                           @ModelAttribute("property") ArtCategoryProperty property,
                                           Model model) {
        property.setOperator(agent.getLoginName());
        //ȫ������
        property.setType(EnumArtCategoryPropertyType.Global.getValue());
//        Long nameId = artCategoryProperty.selectPropertyIdByName(property.getContent());
//        ArtCategoryPropertyName artCategoryPropertyName = new ArtCategoryPropertyName();
//        if (nameId == null) {
//            artCategoryPropertyName.setName(property.getContent());
//            artCategoryPropertyName.setOperator(agent.getLoginName());
//            artCategoryPropertyName.setPropertyType(property.getPropertyType());
//            Long PnameId = artCategoryProperty.addCategoryPropertyName(artCategoryPropertyName);
//            property.setPropertyNameId(PnameId);
//        } else {
//            artCategoryPropertyName.setPropertyType(property.getPropertyType());
//            artCategoryPropertyName.setId(nameId);
//            artCategoryProperty.editCategoryPropertyName(artCategoryPropertyName);
//            property.setPropertyNameId(nameId);
//        }
        
        Long addResult = artCategoryProperty.addnewCategoryProperty(property);
        String url = "/art/wholeCategoryProperty/list.htm";
        return addResult == null ? error(model, url, "���ʧ��") : success(model, url, "��ӳɹ�");
    }

    /**
     * ɾ��ָ������Ŀ����
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/art/artCategoryProperty/remove.htm")
    public String removeCategoryProperty(HttpServletRequest request, Model model) {
        String cateID = request.getParameter("categoryId");
        Long categoryId = null;
        if (cateID != null && !cateID.equals("")){
            categoryId = Long.parseLong(request.getParameter("categoryId"));
        }  
        int removeResult = artCategoryProperty.removeCategoryProperty(Long.parseLong(request
            .getParameter("propertyId")),categoryId);
        String url = null;
        //2:��ʾ�����Ա������޷���ɾ��
        if (removeResult == 2) {
            return error(model,url, "ɾ��ʧ��,�����Ա�����");
        }
        return removeResult == 0 ? error(model, url, "����ʧ��") : success(model, url, "�����ɹ�");
    }

    /**
     * �������ݵ�ajaxΨһ��У��
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/checkProperty.htm")
    public void checkProperty(HttpServletRequest request, HttpServletResponse response)
                                                                                       throws IOException {
        Long categoryId = Long.parseLong(request.getParameter("categoryId"));
        String content = request.getParameter("content").replaceAll(" ", ""); ;
        String propertyId = request.getParameter("propertyId");
        List<ArtCategoryProperty> properties = artCategoryProperty
            .getCategoryPropertyByCatId(categoryId);
        if (propertyId != null && !"".equals(propertyId)) {
            Long id = Long.parseLong(propertyId);
            for (ArtCategoryProperty property : properties) {
                if (property.getContent().equals(content) && id.compareTo(property.getId()) != 0) {
                    response.getWriter().write("�������Ѿ�����");
                    return;
                }
            }
        } else {
            for (ArtCategoryProperty property : properties) {
                if (property.getContent().equals(content)) {
                    response.getWriter().write("�������Ѿ�����");
                    return;
                }
            }
        }

        response.getWriter().write("�����Կ���ʹ��");
    }

    @RequestMapping("/checkIsProperty.htm")
    public void checkIsProperty(HttpServletRequest request, HttpServletResponse response)
                                                                                         throws IOException {
        String cateID = request.getParameter("categoryId");
        String content = request.getParameter("content").replaceAll(" ", ""); 
        String propertyId = request.getParameter("propertyId");
        String propertyTpye =request.getParameter("propertyType");
        Long nameId = artCategoryProperty.selectPropertyIdByName(content);
        int count =0;
        //˽������
        if (cateID != null && !cateID.equals("")) {
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            if (nameId != null) {
                //�ж��Ǳ༭�������
                if (propertyId != null && !propertyId.equals("")) {
                    //�༭    
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, categoryId,
                        Long.parseLong(propertyId));
                } else {
                    //���
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, categoryId,
                        null);
                }
                if (count != 0) {
                    response.getWriter().write("�������Ѿ�����");
                } else {
                    ArtCategoryProperty CategoryProperty = artCategoryProperty.selectPropertyNameById(nameId);
                    if (propertyTpye == null) {
                        response.getWriter().write("�����Կ���ʹ��");
                    } else if (CategoryProperty.getPropertyType().equals(Integer.valueOf(propertyTpye))) {
                        response.getWriter().write("�����Կ���ʹ��");
                    } else {
                        response.getWriter().write("��������������");
                    }
                }
                   
            } else {
                response.getWriter().write("�����Կ���ʹ��");
            }

        } else {
            //ȫ������
            if (nameId != null) {
                if (propertyId != null && !propertyId.equals("")) {
                    //�༭
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, null,
                        Long.parseLong(propertyId));
                    if (count != 0) {
                        response.getWriter().write("�������Ѿ�����");
                    } else {
                        response.getWriter().write("�����Կ���ʹ��");
                    }
                } else {
                    //���
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, null, null);
                    if (count != 0) {
                        response.getWriter().write("�������Ѿ�����");
                    } else {
                        response.getWriter().write("�����Կ���ʹ��");
                    }
                }
            } else {
                response.getWriter().write("�����Կ���ʹ��");
            }
        }
    }

}
