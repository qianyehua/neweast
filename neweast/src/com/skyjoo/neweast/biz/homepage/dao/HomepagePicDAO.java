/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao;

import java.util.List;

import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;

/**
 * ��ҳͼƬ��DAO
 * @author liupc
 * @date 2014-11-12 10:49:47
 */
public interface HomepagePicDAO {
	
	/**
	 * ��ѯ����ͼƬ
	 * @return
	 */
	public List<HomepagePic> getHomepagePic();
	/**
     * ��ȡtypeΪpc��ͼƬ
     * @return
     */
    public List<HomepagePic> getPCHomepage();
    /**
     * ��ȡtypeΪAPP��ͼƬ
     * @return
     */
    public List<HomepagePic> getAPPHomepage();
    /**
     * ��ȡtypeΪAPP����ҳ��ͼƬ
     * @return
     */
    public List<HomepagePic> getAPPStartHomepage();
	/**
	 * ����id��ѯͼƬ��Ϣ
	 * @param homepagePicId
	 * @return
	 */
	public HomepagePic getHomepagePicById(Long homepagePicId);
	
	/**
	 * ���ͼƬ
	 * @param homepagePic
	 * @return
	 */
	public Long addHomepagePic(HomepagePic homepagePic);
	
	/**
	 * ɾ��ͼƬ
	 * @param homepagePic
	 * @return
	 */
	public Integer removeHomepagePic(HomepagePic homepagePic);
	
	/**
	 * ����ͼƬ
	 * @param homepagePic
	 * @return
	 */
	public Integer updateHomepagePic(HomepagePic homepagePic);
}
