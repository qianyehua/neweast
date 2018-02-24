/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.service;

import java.util.List;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.media.domain.SubjectMedia;

/**
 * @author ywb
 * @version $Id: MediaManagerService.java,v 0.1 2017年4月24日 下午2:40:53 Administrator Exp $
 */
public interface MediaManagerService {
    //媒体列表
    public List<SubjectMedia> list();

    //创建媒体
    public Result<String> create(SubjectMedia media);

    //通过id找媒体
    public SubjectMedia findMediaById(Long id);

    //更新媒体
    public Result<String> updateMedia(SubjectMedia media);

    //删除媒体
    public Result<String> deleteMedia(Long id);
}
