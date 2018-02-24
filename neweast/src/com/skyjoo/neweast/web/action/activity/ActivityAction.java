package com.skyjoo.neweast.web.action.activity;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.activity.domain.Activity;
import com.skyjoo.neweast.biz.activity.service.ActivityService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.validator.ActivityValidator;

/**
 *  活动管理
 *  @author cjj
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityAction extends BaseAction {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private ActivityValidator activityValidator;

    @RequestMapping("/list.htm")
    public String articleList(String actName, Model model) {
        List<Activity> list = activityService.getActivityList(actName);

        model.addAttribute("list", list);
        model.addAttribute("actName", actName);

        return "activity/list";
    }

    @RequestMapping("/add-init.htm")
    public String addInit(Model model) {
        model.addAttribute("activity", new Activity());

        return "activity/add";
    }

    @RequestMapping("/add.htm")
    public String addActivity(@ModelAttribute("activity")
    final Activity activity, BindingResult result, Model model,@RequestParam Long[] imgOrder, @RequestParam MultipartFile[] fileList) {
        String url = "/activity/add";
        
        activityValidator.validate(activity, result);
        if(result.hasErrors()){
            return url;
        }
        
        //排序数量和图片数量不一致
        if(imgOrder.length != fileList.length){
            return error(model,url,"上传图片排序有问题");
        }
        
        Result<List<String>> rs = activityService.uplpadImgList(fileList);
        
        if(!rs.isSuccess()){
            return error(model,url,rs.getResultInfo());
        }
        
        activity.setAttachment(activityService.getAttachment(rs.getResult(),imgOrder));
        
        if(activityService.addActivity(activity) > 0){
            return success(model, "/activity/list.htm", "添加活动成功");
        }else{
            return error(model,url,"添加失败");
        }
    }

    @RequestMapping("/edit-init.htm")
    public String editInit(@RequestParam("id")Long id,Model model) {
        Activity activity = activityService.getActivityById(id);
        
        if(activity == null){
            return error(model,"activity/list","对应活动不存在");
        }

        //拆分图片
        String[] imgList = activity.getAttachment().split("[|]");
        activity.setImgList(Arrays.asList(imgList));
        
        model.addAttribute("activity",activity);
        
        return "activity/edit";
    }
    
    @RequestMapping("/edit.htm")
    public String editActivity(@ModelAttribute("activity")
    final Activity activity, BindingResult result, Model model,@RequestParam Long[] imgOrder,String[] img, @RequestParam MultipartFile[] fileList) {
        String url = "/activity/edit";
        
        activityValidator.validate(activity, result);
        if(result.hasErrors()){
            return url;
        }
        
        //判断排序数量和图片数量是否一致
        if((img != null && img.length != imgOrder.length) || (img == null && fileList.length != imgOrder.length)){
            return error(model,url,"上传图片排序有问题");
        }
        
        List<String> imgList = null;
        
        //img存储的是原先的图片路径，若不为空，则表示图片未做修改，只需重新排序，无需上传图片
        if(img != null){
            imgList = Arrays.asList(img);
        }else{//需要重新上传图片
            Result<List<String>> rs = activityService.uplpadImgList(fileList);
            
            if(!rs.isSuccess()){
                return error(model,url,rs.getResultInfo());
            }
            imgList = rs.getResult();
        }
        
        activity.setAttachment(activityService.getAttachment(imgList,imgOrder));
        
        if(activityService.updateActivity(activity) > 0){
            return success(model, "/activity/list.htm", "编辑活动成功");
        }else{
            return error(model,url,"编辑失败");
        }
    }
    
    @RequestMapping("/delete.htm")
    public String delete(@RequestParam("id")Long id, Model model) {
        activityService.deleteActivity(id);
        
        return success(model, "/activity/list.htm", "删除成功");
    }
}
