/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��24��
 */
package com.skyjoo.neweast.biz.media.service;

import java.util.List;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.media.domain.SubjectMedia;

/**
 * @author ywb
 * @version $Id: MediaManagerService.java,v 0.1 2017��4��24�� ����2:40:53 Administrator Exp $
 */
public interface MediaManagerService {
    //ý���б�
    public List<SubjectMedia> list();

    //����ý��
    public Result<String> create(SubjectMedia media);

    //ͨ��id��ý��
    public SubjectMedia findMediaById(Long id);

    //����ý��
    public Result<String> updateMedia(SubjectMedia media);

    //ɾ��ý��
    public Result<String> deleteMedia(Long id);
}
