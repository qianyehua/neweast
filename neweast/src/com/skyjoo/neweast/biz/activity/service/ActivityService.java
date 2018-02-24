package com.skyjoo.neweast.biz.activity.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.activity.domain.Activity;

public interface ActivityService {
    /**
     * 获取活动列表
     * @param name
     * @return
     */
    public List<Activity> getActivityList(String actName);
    
    /**
     * 上传图片，返回图片地址列表
     * @param fileList
     * @return
     */
    public Result<List<String>> uplpadImgList(MultipartFile[] fileList);
    
    /**
     * 根据图片列表和排序拼接对应字段
     * @param imgList
     * @param imgOrder
     * @return
     */
    public String getAttachment(List<String> imgList,Long[] imgOrder);
    
    /**
     * 新增活动
     * @param activity
     * @return
     */
    public Long addActivity(Activity activity);
    
    /**
     * 编辑活动
     * @param activity
     * @return
     */
    public Integer updateActivity(Activity activity);
    
    /**
     * 删除活动
     * @param id
     * @return
     */
    public Integer deleteActivity(Long id);
    
    /**
     * 根据id获取活动
     * @param id
     * @return
     */
    public Activity getActivityById(Long id);
}
