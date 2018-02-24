/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.web.action.media;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.media.domain.SubjectMedia;
import com.skyjoo.neweast.biz.media.domain.enums.EnumResult;
import com.skyjoo.neweast.biz.media.domain.enums.EnumVisitType;
import com.skyjoo.neweast.biz.media.service.MediaManagerService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.validator.MediaValidator;

/**
 * @author ywb
 * @version $Id: mediaManagerAction.java,v 0.1 2017年4月24日 下午2:17:44 Administrator Exp $
 */

@Controller
@RequestMapping("/media")
public class mediaManagerAction extends BaseAction {

    @Autowired
    private MediaValidator      mediaValidator;

    @Value("${upload.server.host}")
    private String              host;
    @Autowired
    private MediaManagerService mediaManagerService;

    @RequestMapping("/list.htm")
    public String list(ModelMap model) {
        List<SubjectMedia> mediaList = mediaManagerService.list();
        model.put("mediaList", mediaList);
        model.put("types", EnumVisitType.values());
        return "/media/list";
    }

    @RequestMapping(value = "create.htm", method = RequestMethod.GET)
    public String create_Init(@ModelAttribute("media") SubjectMedia media, ModelMap map) {
        map.put("types", EnumVisitType.values());
        return "/media/create";
    }

    @RequestMapping(value = "create.htm", method = RequestMethod.POST)
    public String create(@ModelAttribute("media") SubjectMedia media, ModelMap map,
                         BindingResult result) {
        mediaValidator.validate(media, result);
        if (result.hasErrors()) {
            map.put("types", EnumVisitType.values());
            return "/media/create";
        }
        Result<String> res = mediaManagerService.create(media);
        map.put("url", "/media/list.htm");
        if (res.getResult().equals(EnumResult.SUCCESS.getVal())) {
            return "success";
        }
        return "error";
    }

    @RequestMapping(value = "update.htm", method = RequestMethod.GET)
    public String update_init(@RequestParam("id") Long id, ModelMap map) {
        SubjectMedia media = mediaManagerService.findMediaById(id);
        map.put("media", media);
        map.put("types", EnumVisitType.values());
        return "/media/update";
    }

    @RequestMapping(value = "update.htm", method = RequestMethod.POST)
    public String update(@ModelAttribute("media") SubjectMedia media, ModelMap map,
                         BindingResult result) {
        mediaValidator.validate(media, result);
        if (result.hasErrors()) {
            media.setMediaLogo(mediaManagerService.findMediaById(media.getId()).getMediaLogo());
            map.put("media", media);
            map.put("types", EnumVisitType.values());
            return "/media/update";
        }
        Result<String> res = mediaManagerService.updateMedia(media);
        map.put("url", "/media/list.htm");
        if (res.getResult().equals(EnumResult.SUCCESS.getVal())) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("delete.htm")
    public String delete(@RequestParam("id") Long id, ModelMap map) {
        Result<String> res = mediaManagerService.deleteMedia(id);
        map.put("url", "/media/list.htm");
        if (res.getResult().equals(EnumResult.SUCCESS.getVal())) {
            return "success";
        }
        if (StringUtils.isNotBlank(res.getResultInfo())) {
            map.put("message", res.getResultInfo());
        }
        return "error";
    }
}
