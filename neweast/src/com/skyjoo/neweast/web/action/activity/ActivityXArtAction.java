package com.skyjoo.neweast.web.action.activity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyjoo.neweast.biz.activity.domain.Activity;
import com.skyjoo.neweast.biz.activity.domain.ActivityXArt;
import com.skyjoo.neweast.biz.activity.domain.ActivityXArtResult;
import com.skyjoo.neweast.biz.activity.service.ActivityService;
import com.skyjoo.neweast.biz.activity.service.ActivityXArtService;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.common.service.CacheService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 *  活动艺术品管理
 *  @author cjj
 */
@Controller
@RequestMapping(value = "/axa")
public class ActivityXArtAction extends BaseAction {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private ArtService artService;
    @Autowired
    private ArtCategoryService artCategoryService;
    @Autowired
    private ActivityXArtService activityXArtService;
    @Autowired
    private ActivityService activityService;
    
    @RequestMapping("/list.htm")
    public String artList(@RequestParam("activityId")Long activityId, Model model,@ModelAttribute("result") ActivityXArtResult result) {
        Activity activity = activityService.getActivityById(activityId);
        
        if(activity == null){
            return error(model,"/activity/list","对应活动不存在");
        }
        
        result.setList(activityXArtService.getActivityXArt(activityId));
        
        model.addAttribute("activityId", activityId);
        model.addAttribute("activityName", activity.getName());
        
        return "activity/axaList";
    }
    
    @RequestMapping("/editOrder.htm")
    public String editOrder(@RequestParam("activityId")Long activityId, Model model,@ModelAttribute("result") ActivityXArtResult result) {
        if(result == null || result.getList() == null){
            return "redirect:" + "/axa/list.htm?activityId="+activityId;
        }
        
        activityXArtService.batchEditOrder(result.getList());
        
        return success(model, "/activity/list.htm", "更新艺术品排序成功");
    }
    
    @RequestMapping("/add-init.htm")
    public String addArtInit(@RequestParam("activityId")Long activityId,@ModelAttribute("artCheckQuery")ArtCheckQuery art, Model model) {
        model.addAttribute("list_menus", cacheService.getArtCategoryNames());
        model.addAttribute("activityId", activityId);  
        
        return "activity/artList";
    }
    
    /**
     * 返回不在对应活动中的艺术品列表
     * @param activityId
     * @param art
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchArt.htm")
    public String addRecommendArt(@RequestParam("activityId")Long activityId,@ModelAttribute("artCheckQuery")ArtCheckQuery art, Model model) {
        art.setActivityId(activityId);
        Long categoryId = art.getCategoryId();
        if(categoryId != null){
            ArtCategory artCategory = artCategoryService.getCategoryListbyId(categoryId);
            if(artCategory.getParentId() == 0){
                art.setArtParentCategoryId(categoryId);
                art.setCategoryId(null);
            }
        }   
        //art.setIsArtiseWork(true);
        ArtCheckQuery artCheckQuery = (ArtCheckQuery) artService.getPaginatedActivityXArt(art);
        artCheckQuery.setCategoryId(categoryId);
        model.addAttribute("activityId", activityId);  
        model.addAttribute("page", artCheckQuery);  
        model.addAttribute("list_menus", cacheService.getArtCategoryNames());
        return "activity/artList";
        
    }
    
    /**
     * 批量添加艺术品
     * @param ids
     * @param activityId
     * @param model
     * @return
     */
    @RequestMapping("/batchAddActivityXArt.htm")
    public String batchAddActivityXArt(@RequestParam("ids") String ids,@RequestParam("activityId") Long activityId, Model model) {
        String[] str = ids.split(",");
        List<ActivityXArt> activityXArtList =  new ArrayList<ActivityXArt>();
        for (int i = 0; i < str.length; i++) {
            ActivityXArt activityXArt = new ActivityXArt();
            activityXArt.setActivityId(activityId);
            activityXArt.setArtId(Long.valueOf(str[i]).longValue());           
            activityXArtList.add(activityXArt);
        }
        activityXArtService.batchInsertActivityXArt(activityXArtList);

        return success(model, "/axa/list.htm?activityId="+activityId, "添加成功");
    } 
    
    /**
     * 根据关联表id删除信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/delete.htm")
    public String delete(@RequestParam("id")Long id,@RequestParam("activityId")Long activityId, Model model) {
        if(activityXArtService.deleteActivityXArt(id) == 0){
            return error();
        }
        
        return success(model, "/axa/list.htm?activityId="+activityId, "删除成功");
    }
}
