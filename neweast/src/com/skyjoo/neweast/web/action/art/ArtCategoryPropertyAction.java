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
     * 获取指定类目的属性
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
     * 获取全局属性
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
     * 初始化修改
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
     * 修改指定类目的属性
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
        //判断新属性名是否已经存在
        Long IsnameId = artCategoryProperty.selectPropertyIdByName(property.getContent());
        //如果存在,肯定是私有属性
        if(IsnameId!=null && !IsnameId.equals(propertyId)){
            //修改关联表
            int edResult =artCategoryProperty.editCategoryXProperty(categoryId, IsnameId, propertyId);
            ArtCategoryProperty categoryProperty = artCategoryProperty.selectPropertyNameById(propertyId);
            if(!property.getContent().equals(categoryProperty.getContent()) && artCategoryProperty.getOtherCategoryProperty(propertyId, categoryId)==0){
                //删除原属性值
                artCategoryProperty.removeCategoryProperty(propertyId,categoryId);
            }else{
                //删除元属性选项
                artPropertyOptionService.deleteOptionByPropertyID(propertyId, categoryId);
            }         
        }else if((IsnameId!=null && IsnameId.equals(propertyId))){
            //仅修改排序
            int editPnameResult = artCategoryProperty.editCategoryProperty(property);
        }else {
        //判断其他类目是否有同名属性,如果有则新增属性名
        int count = artCategoryProperty.getOtherCategoryProperty(propertyId, categoryId);
        //区分是全局属性还是私有属性
        if(categoryId != null) {
            //删除元属性选项
            artPropertyOptionService.deleteOptionByPropertyID(propertyId, categoryId);
            
        }
        ArtCategoryProperty artCategoryPropertye = new ArtCategoryProperty();
        artCategoryPropertye.setContent(property.getContent());
        artCategoryPropertye.setOperator(agent.getLoginName());
        if(count == 0){
            artCategoryPropertye.setId(propertyId);
            //修改属性名
            int editPnameResult = artCategoryProperty.editCategoryProperty(artCategoryPropertye);
            if(editPnameResult == 0){
                return error(model, url, "修改失败");
            }
        }else if(count > 0){
            artCategoryPropertye.setOrdering(property.getOrdering());
            artCategoryPropertye.setType(EnumArtCategoryPropertyType.Private.getValue());
            artCategoryPropertye.setPropertyType(property.getPropertyType());
            //新增属性名 
            Long PnameId = artCategoryProperty.addnewCategoryProperty(artCategoryPropertye);
            if(PnameId == null){
                return error(model, url, "修改失败");
                }
            //修改关联表
            int edResult =artCategoryProperty.editCategoryXProperty(categoryId, PnameId, propertyId);      
            if(edResult == 0){
                return error(model, url, "修改关联表失败");
                }
            }
        }                
            return  success(model, url, "修改成功");
        
    }

    /**
     * 初始化添加属性操作
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
     * 添加私有属性
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
        //限制一个类目最多只能添加5个属性
        if (artCategoryProperty.getCategoryPropertyByCatId(categoryId).size() >= 5) {
            return error(model, "/art/artCategoryProperty/list.htm?categoryId=" + categoryId,
                "最多只能为该类目添加5个属性");
        }
        property.setOperator(agent.getLoginName());
        //私有属性
        property.setType(EnumArtCategoryPropertyType.Private.getValue());
        //是否存在同名属性名
        Long nameId = artCategoryProperty.selectPropertyIdByName(property.getContent());
        String msg = "添加成功";
        CategoryProperty  categoryProperty =  new CategoryProperty();
        if (nameId == null) {
            Long Id = artCategoryProperty.addnewCategoryProperty(property);
            categoryProperty.setPropertyId(Id);
        } else {
            //判断其他类目是否有同名属性,如果有属性类型不做变化
           int count = artCategoryProperty.getartCategoryPropertyCount(nameId, null, null);
           if(count != 0){
               msg ="属性添加成功,但由于该属性名已经存在其他类目,故属性类型不发生变化!";
           } 
           categoryProperty.setPropertyId(nameId);
        }       
        categoryProperty.setCategoryId(categoryId);

        Long addResult = artCategoryProperty.addCategoryProperty(categoryProperty);
        String url = "/art/artCategoryProperty/list.htm?categoryId=" + categoryId + "&parentId="
                     + request.getParameter("parentId");
        return addResult == null ? error(model, url, "添加失败") : success(model, url, msg);
    }

    /**
     * 添加全局属性初始化
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
     * 添加全局属性
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
        //全局属性
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
        return addResult == null ? error(model, url, "添加失败") : success(model, url, "添加成功");
    }

    /**
     * 删除指定的类目属性
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
        //2:表示该属性被引用无法被删除
        if (removeResult == 2) {
            return error(model,url, "删除失败,该属性被引用");
        }
        return removeResult == 0 ? error(model, url, "操作失败") : success(model, url, "操作成功");
    }

    /**
     * 属性内容的ajax唯一性校验
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
                    response.getWriter().write("该属性已经存在");
                    return;
                }
            }
        } else {
            for (ArtCategoryProperty property : properties) {
                if (property.getContent().equals(content)) {
                    response.getWriter().write("该属性已经存在");
                    return;
                }
            }
        }

        response.getWriter().write("该属性可以使用");
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
        //私有属性
        if (cateID != null && !cateID.equals("")) {
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            if (nameId != null) {
                //判断是编辑还是添加
                if (propertyId != null && !propertyId.equals("")) {
                    //编辑    
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, categoryId,
                        Long.parseLong(propertyId));
                } else {
                    //添加
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, categoryId,
                        null);
                }
                if (count != 0) {
                    response.getWriter().write("该属性已经存在");
                } else {
                    ArtCategoryProperty CategoryProperty = artCategoryProperty.selectPropertyNameById(nameId);
                    if (propertyTpye == null) {
                        response.getWriter().write("该属性可以使用");
                    } else if (CategoryProperty.getPropertyType().equals(Integer.valueOf(propertyTpye))) {
                        response.getWriter().write("该属性可以使用");
                    } else {
                        response.getWriter().write("该属性名不可用");
                    }
                }
                   
            } else {
                response.getWriter().write("该属性可以使用");
            }

        } else {
            //全局属性
            if (nameId != null) {
                if (propertyId != null && !propertyId.equals("")) {
                    //编辑
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, null,
                        Long.parseLong(propertyId));
                    if (count != 0) {
                        response.getWriter().write("该属性已经存在");
                    } else {
                        response.getWriter().write("该属性可以使用");
                    }
                } else {
                    //添加
                    count = artCategoryProperty.getartCategoryPropertyCount(nameId, null, null);
                    if (count != 0) {
                        response.getWriter().write("该属性已经存在");
                    } else {
                        response.getWriter().write("该属性可以使用");
                    }
                }
            } else {
                response.getWriter().write("该属性可以使用");
            }
        }
    }

}
