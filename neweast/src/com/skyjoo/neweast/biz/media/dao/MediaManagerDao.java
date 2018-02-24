/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.dao;

import java.util.List;

import com.skyjoo.neweast.biz.media.domain.SubjectMedia;

/**
 * @author ywb
 * @version $Id: MediaManagerDao.java,v 0.1 2017年4月24日 下午2:47:34 Administrator Exp $
 */
public interface MediaManagerDao {
    //媒体列表
    public List<SubjectMedia> list();

    //创建媒体
    public Object create(SubjectMedia media);

    //更新媒体
    public int updateMedia(SubjectMedia media);

    //通过id找媒体
    public SubjectMedia findMediaById(Long id);

    //删除媒体
    public int deleteMedia(Long id);
    
    //查询当前媒体下的文章为待审核、正常的数量
    public long getCountArticleByMedia(Long id);
}
