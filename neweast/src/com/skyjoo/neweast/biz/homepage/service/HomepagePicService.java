/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service;

import java.util.List;

import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;

/**
 * 首页图片管理service
 * @author liupc
 * @date 2014-11-12 10:45:53
 */
public interface HomepagePicService {

    /**
     * 获取所有图片
     * @return
     */
    public List<HomepagePic> getHomepagePic();

    /**
     * 获取type为pc的图片
     * @return
     */
    public List<HomepagePic> getPCHomepage();

    /**
     * 获取type为APP的图片
     * @return
     */
    public List<HomepagePic> getAPPHomepage();
    /**
     * 获取type为APP开屏页的图片
     * @return
     */
    public List<HomepagePic> getAPPStartHomepage();

    /**
     * 根据id获取图片信息
     * @param id
     * @return
     */
    public HomepagePic getHomepagePicById(Long homepagePicId);

    /**
     * 添加图片
     * @param homepagePic
     * @return
     */
    public Long addHomepagePic(HomepagePic homepagePic);

    /**
     * 删除图片
     * @param homepagePic
     * @return
     */
    public Integer removeHomepagePic(HomepagePic homepagePic);

    /**
     * 更新图片
     * @param homepagePic
     * @return
     */
    public Integer updateHomepagePic(HomepagePic homepagePic);
}
