/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.media.dao.MediaManagerDao;
import com.skyjoo.neweast.biz.media.domain.SubjectMedia;

/**
 * @author ywb
 * @version $Id: MediaManagerDaoIbatis.java,v 0.1 2017年4月24日 下午2:48:44 Administrator Exp $
 */
@Repository
public class MediaManagerDaoIbatis extends BaseDaoiBatis implements MediaManagerDao {

    private static String SPACE = "MEDIAMANAGER.";

    /**
     * 
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#list()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SubjectMedia> list() {
        return (List<SubjectMedia>) this.getSqlMapClientTemplate().queryForList(SPACE + "list");
    }

    /**
     * @param media
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#create(com.skyjoo.neweast.biz.wellchosen.domain.SubjectMedia)
     */
    @SuppressWarnings("deprecation")
    @Override
    public Object create(SubjectMedia media) {
        return this.getSqlMapClientTemplate().insert(SPACE + "createMedia", media);

    }

    /**
     * @param media
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#updateMedia(com.skyjoo.neweast.biz.wellchosen.domain.SubjectMedia)
     */
    @SuppressWarnings("deprecation")
    @Override
    public int updateMedia(SubjectMedia media) {
        return this.getSqlMapClientTemplate().update(SPACE + "updateMedia", media);
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#deleteMedia(java.lang.Long)
     */
    @SuppressWarnings("deprecation")
    @Override
    public int deleteMedia(Long id) {
        return this.getSqlMapClientTemplate().delete(SPACE + "deleteById", id);
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#findMediaById(java.lang.Long)
     */
    @SuppressWarnings("deprecation")
    @Override
    public SubjectMedia findMediaById(Long id) {
        return (SubjectMedia) this.getSqlMapClientTemplate().queryForObject(
            SPACE + "findMediaById", id);
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.dao.MediaManagerDao#getCountArticleByMedia(java.lang.Long)
     */
    @Override
    public long getCountArticleByMedia(Long id) {
        return (long) this.getSqlMapClientTemplate().queryForObject(SPACE+"getSumMediaArticle", id);
    }

}
