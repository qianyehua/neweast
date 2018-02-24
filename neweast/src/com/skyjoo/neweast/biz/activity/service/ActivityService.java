package com.skyjoo.neweast.biz.activity.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.activity.domain.Activity;

public interface ActivityService {
    /**
     * ��ȡ��б�
     * @param name
     * @return
     */
    public List<Activity> getActivityList(String actName);
    
    /**
     * �ϴ�ͼƬ������ͼƬ��ַ�б�
     * @param fileList
     * @return
     */
    public Result<List<String>> uplpadImgList(MultipartFile[] fileList);
    
    /**
     * ����ͼƬ�б������ƴ�Ӷ�Ӧ�ֶ�
     * @param imgList
     * @param imgOrder
     * @return
     */
    public String getAttachment(List<String> imgList,Long[] imgOrder);
    
    /**
     * �����
     * @param activity
     * @return
     */
    public Long addActivity(Activity activity);
    
    /**
     * �༭�
     * @param activity
     * @return
     */
    public Integer updateActivity(Activity activity);
    
    /**
     * ɾ���
     * @param id
     * @return
     */
    public Integer deleteActivity(Long id);
    
    /**
     * ����id��ȡ�
     * @param id
     * @return
     */
    public Activity getActivityById(Long id);
}
