/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��24��
 */
package com.skyjoo.neweast.biz.media.dao;

import java.util.List;

import com.skyjoo.neweast.biz.media.domain.SubjectMedia;

/**
 * @author ywb
 * @version $Id: MediaManagerDao.java,v 0.1 2017��4��24�� ����2:47:34 Administrator Exp $
 */
public interface MediaManagerDao {
    //ý���б�
    public List<SubjectMedia> list();

    //����ý��
    public Object create(SubjectMedia media);

    //����ý��
    public int updateMedia(SubjectMedia media);

    //ͨ��id��ý��
    public SubjectMedia findMediaById(Long id);

    //ɾ��ý��
    public int deleteMedia(Long id);
    
    //��ѯ��ǰý���µ�����Ϊ����ˡ�����������
    public long getCountArticleByMedia(Long id);
}
