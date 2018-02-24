/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service;

import java.util.List;

import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;

/**
 * ��ҳͼƬ����service
 * @author liupc
 * @date 2014-11-12 10:45:53
 */
public interface HomepagePicService {

    /**
     * ��ȡ����ͼƬ
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
     * ����id��ȡͼƬ��Ϣ
     * @param id
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
