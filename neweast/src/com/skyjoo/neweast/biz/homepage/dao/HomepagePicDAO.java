/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao;

import java.util.List;

import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;

/**
 * 首页图片表DAO
 * @author liupc
 * @date 2014-11-12 10:49:47
 */
public interface HomepagePicDAO {
	
	/**
	 * 查询所有图片
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
	 * 根据id查询图片信息
	 * @param homepagePicId
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
