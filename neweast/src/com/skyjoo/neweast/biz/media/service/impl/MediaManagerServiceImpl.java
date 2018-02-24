/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;
import com.skyjoo.neweast.biz.common.upload.UploadFileResult;
import com.skyjoo.neweast.biz.common.upload.UploadManager;
import com.skyjoo.neweast.biz.media.dao.MediaManagerDao;
import com.skyjoo.neweast.biz.media.domain.SubjectMedia;
import com.skyjoo.neweast.biz.media.domain.enums.EnumResult;
import com.skyjoo.neweast.biz.media.service.MediaManagerService;

/**
 * @author ywb
 * @version $Id: MediaManagerServiceImpl.java,v 0.1 2017年4月24日 下午2:45:55 Administrator Exp $
 */
@Service
public class MediaManagerServiceImpl extends BaseManager implements MediaManagerService {

    @Autowired
    private MediaManagerDao mediaManagerDao;
    @Autowired
    private UploadManager   uploadManager;

    /**
     * 
     * @see com.skyjoo.neweast.biz.wellchosen.service.MediaManagerService#list()
     */
    @Override
    public List<SubjectMedia> list() {
        return mediaManagerDao.list();
    }

    /**
     * @param media
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.service.MediaManagerService#create(com.skyjoo.neweast.biz.wellchosen.domain.SubjectMedia)
     */
    @Override
    public Result<String> create(SubjectMedia media) {
        try {
            UploadFileResult res = uploadManager.uploadImage(media.getLogo(), false, "logo");
            media.setMediaLogo(res.getFilePath());
        } catch (UploadFileException e) {
            log.error("Upload Logo faile", e);
        }
        Result<String> result = new Result<String>();
        if (mediaManagerDao.create(media) != null) {
            result.setResult(EnumResult.SUCCESS.getVal());
        } else {
            result.setResult(EnumResult.FAILE.getVal());
        }
        return result;
    }

    /**
     * @param media
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.service.MediaManagerService#updateMedia(com.skyjoo.neweast.biz.wellchosen.domain.SubjectMedia)
     */
    @Override
    public Result<String> updateMedia(SubjectMedia media) {
        if (media.getLogo() != null && media.getLogo().getSize()>0) {
            String path = mediaManagerDao.findMediaById(media.getId()).getMediaLogo();
            try {
                UploadFileResult fileResult = uploadManager.uploadImage(media.getLogo(), false,
                    "logo");
                media.setMediaLogo(fileResult.getFilePath());
            } catch (UploadFileException e) {
                log.error("Upload Logo faile", e);
            }
            uploadManager.deleteFile("", path);
        }
        Result<String> result = new Result<String>();
        if (mediaManagerDao.updateMedia(media) > 0) {
            result.setResult(EnumResult.SUCCESS.getVal());
        } else {
            result.setResult(EnumResult.FAILE.getVal());
        }
        return result;
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.service.MediaManagerService#deleteMedia(java.lang.Long)
     */
    @Override
    public Result<String> deleteMedia(Long id) {
        Result<String> result = new Result<String>();

        if (mediaManagerDao.getCountArticleByMedia(id) > 0) {
            result.setResult(EnumResult.FAILE.getVal());
            result.setResultInfo("当前媒体下有待审核、正常的文章，不可删除！");
            return result;
        }
        //删除服务器logo图片
        uploadManager.deleteFile("", mediaManagerDao.findMediaById(id).getMediaLogo());
        if (mediaManagerDao.deleteMedia(id) > 0) {
            result.setResult(EnumResult.SUCCESS.getVal());
        } else {
            result.setResult(EnumResult.FAILE.getVal());
        }
        return result;
    }

    /**
     * @param id
     * @return
     * @see com.skyjoo.neweast.biz.wellchosen.service.MediaManagerService#findMediaById(java.lang.Long)
     */
    @Override
    public SubjectMedia findMediaById(Long id) {
        return mediaManagerDao.findMediaById(id);
    }

}
