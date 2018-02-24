package com.skyjoo.neweast.biz.activity.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.activity.dao.ActivityDAO;
import com.skyjoo.neweast.biz.activity.dao.ActivityXArtDAO;
import com.skyjoo.neweast.biz.activity.domain.Activity;
import com.skyjoo.neweast.biz.activity.service.ActivityService;
import com.skyjoo.neweast.biz.common.enums.EnumImagePath;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDAO activityDao;
    @Autowired
    private ActivityXArtDAO activityXArtDAO;
    @Autowired
    private UploadManager          uploadManager;
    @Autowired
    TransactionTemplate transactionTemplate;
    
    //为了调用上传图片方法加上的
    private static final String[]  DEFAULT_IMAGE_SUFFIXS  = new String[] { "jpg", "jpeg", "png",
            "gif", "JPG", "JPEG", "PNG", "GIF", "bmp", "BMP" };
    private static final long      DEFAULT_IMAGE_MAX_SIZE = 5 * 1024 * 1024;                 //图片最大限制为5M
    
    @Override
    public List<Activity> getActivityList(String actName) {
        return activityDao.getActivityList(actName);
    }

    public Result<List<String>> uplpadImgList(MultipartFile[] fileList){
        Result<List<String>> result = new Result<>();
        
        for(MultipartFile file : fileList){
            if (file == null || file.getSize() > DEFAULT_IMAGE_MAX_SIZE){
                result.setError("0", "上传图片不存在或大于5M");
                return result;
            }
        }
        
        try{
            List<String> imgList = new ArrayList();//存储上传后的图片路径
            for(MultipartFile file : fileList){
                UploadFileResult ufr = uploadManager.uploadImage(file, false,
                    EnumImagePath.ACTIVITY.getValue(), DEFAULT_IMAGE_SUFFIXS, DEFAULT_IMAGE_MAX_SIZE);
                if (!ufr.isSuccess()) {
                    //如果上传失败，删除所有之前上传的图片
                    for (String img : imgList) {
                        uploadManager.deleteFile("", img);
                    }
                    result.setError("0", "图片上传失败");
                    return result;
                }
                imgList.add(ufr.getFilePath());   
            }
            
            if(imgList.isEmpty() || imgList.size() != fileList.length){
                result.setError("0", "图片上传出现问题");  
            }else{
                result.setSuccess(true);
                result.setResult(imgList);
            }
        }catch(Exception e){
            result.setError("0", e.getMessage());
        }
        
        return result;
    }
    
    public String getAttachment(List<String> imgList,Long[] imgOrder){
        class Image implements Comparable<Image>{
            String name;
            Long order;
            Image(String name,Long order){
                this.name = name;
                this.order = order;
            }
            public int compareTo(Image arg0) {
                return this.getOrder().compareTo(arg0.getOrder());
            }
            public String getName(){
                return this.name;
            }
            public Long getOrder(){
                return this.order;
            }
        }
        String atta = "";
        
        //现将图片列表和排序合成一个list
        List<Image> list = new ArrayList();
        for(int i = 0;i<imgList.size();i++){
            Image img = new Image(imgList.get(i),imgOrder[i]);
            list.add(img);
        }
        Collections.sort(list);
        for(Image img : list){
            atta += img.getName() + "|";
        }
        if(atta.length() > 0){
            atta = atta.substring(0, atta.length()-1);
        }
        
        return atta;
    }
    
    public Long addActivity(Activity activity){
        return activityDao.addActivity(activity);
    }
    
    public Integer updateActivity(Activity activity){
        return activityDao.updateActivity(activity);
    }
    
    public Integer deleteActivity(final Long id){
        Integer result= transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus arg0) {
                if(activityDao.deleteActivity(id) > 0){
                    return activityXArtDAO.deleteByActivityId(id);
                }else{
                    return 0;
                }
            }
        });
        
        return result;
    }
    
    public Activity getActivityById(Long id){
        return activityDao.getActivityById(id);
    }
}
