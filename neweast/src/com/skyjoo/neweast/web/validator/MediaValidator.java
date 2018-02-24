/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��24��
 */
package com.skyjoo.neweast.web.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.media.domain.SubjectMedia;
import com.skyjoo.neweast.biz.media.service.MediaManagerService;

/**
 * @author ywb
 * @version $Id: MediaValidator.java,v 0.1 2017��4��24�� ����4:16:25 Administrator Exp $
 */
@Component
public class MediaValidator implements Validator {

    private static long         MAX_SIZE = 1 * 1024 * 1024;
    @Autowired
    private MediaManagerService managerService;
//    private static final String NAME="^[\\sa-z0-9A-Z\u4E00-\u9FFF]+$";
    
    /**
     * @param arg0
     * @return
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> arg0) {
        return SubjectMedia.class.equals(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object obj, Errors err) {
        SubjectMedia media = (SubjectMedia) obj;
        if (StringUtils.isBlank(media.getMediaName())) {
            err.rejectValue("mediaName", null, null, "������ý������");
        } else if (StringUtils.length(media.getMediaName().trim()) > 10) {
            err.rejectValue("mediaName", null, null, "ý������ӦС�ڵ���10���ַ�");
        }/*else if (!Pattern.matches(NAME, media.getMediaName().trim())) {
            err.rejectValue("mediaName", null, null, "��������ȷ������,����Ӣ���ַ�������");
         }*/
        if (media.getVisitType() < 1 || media.getVisitType() > 3) {
            err.rejectValue("visitType", null, null, "������������ȷѡ��");
        }
        //��ǰ�������޸���û�޸�logo
        if (media.getId() != null) {
            if (managerService.findMediaById(media.getId()).getVisitType()!=media.getVisitType()) {
                err.rejectValue("visitType", null, null, "�������Ͳ����޸ģ�");
            }
            if (StringUtils.isBlank(media.getLogo().getOriginalFilename())) {
                return;
            }
        }
        if (StringUtils.isBlank(media.getLogo().getOriginalFilename())) {
            err.rejectValue("logo", null, null, "���ϴ�logoͼƬ");
        } else {
            String name = media.getLogo().getOriginalFilename()
                .substring(media.getLogo().getOriginalFilename().lastIndexOf(".") + 1);
            if (!StringUtils.contains(".jpg.jpeg,.png.bmp.gif.GIF.JPG.JPEG.PNG.BMP", name)) {
                err.rejectValue("logo", null, null, "�ϴ��ļ���֧�ָ�����");
            }
            if (media.getLogo().getSize() > MAX_SIZE) {
                err.rejectValue("logo", null, null, "�ϴ�ͼƬӦС�ڵ���1M");
            }
        }

    }

}
