/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.web.action.article;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.wudadao.common.util.StringUtil;
import com.skyjoo.neweast.biz.article.domain.ArticlStatistic;
import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.ArticleTemple;
import com.skyjoo.neweast.biz.article.service.ArticleManagerService;
import com.skyjoo.neweast.biz.article.service.ArticleService;
import com.skyjoo.neweast.web.action.BaseAction;

/**
 * @author ywb
 * @version $Id: articleManageAction.java,v 0.1 2017年4月25日 下午5:20:50 Administrator Exp $
 */
@Controller
@RequestMapping("/article")
public class articleManageAction extends BaseAction {
    @Autowired
    private ArticleManagerService articleManagerService;
    @Autowired
    private ArticleService        articleService;
    @Value("${article.html.filePath}")
    private String                filePath ;
    
    @RequestMapping("/statistics.htm")
    public String articleStatistic(@ModelAttribute("articlStatistic") ArticlStatistic ar,
                                   ModelMap map) {
        articleManagerService.getPaginatedStatistic(ar);
        map.put("page", ar);
        return "/article/statistic";
    }
    
    /**
     * 文件自定义修改保存
     * @param temple
     * @return
     */
    @RequestMapping(value = "/articleEdit.htm", method = RequestMethod.POST)
    public String articleEditByUs(@ModelAttribute("temple") ArticleTemple temple,@RequestParam("articleId")Long id,Model model) {
        String url = "/article/articleEdit_init.htm?id="+id;
        
        if (StringUtil.isBlank(temple.getLocalName())) {
            return error(model, url, "文件名不存在！");
		}
        String[] fileNames = temple.getLocalName().split("\\.");
        if (fileNames.length != 2) {
            return error(model, url, "文件名错误！");
        }
        File f = new File(filePath, temple.getLocalName());
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            String html = temple.getContent();
            //若文章内容的meta相关被删除，重新添加相关内容
            if(!(html.contains("<meta") && html.contains("charset="))){
              //对文章内容进行处理
                StringBuilder sb = new StringBuilder();
                sb.append("<!DOCTYPE html><html><head>"+
                        "<meta charset='UTF-8'>"+
                        "<meta name='format-detection' content='telephone=no'/>"+
                        "<meta name='viewport' content='width=device-width,height=device-height,user-scalable=no,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0'/>"+
                        "</head><body><div style='max-width: 640px; margin: 0 auto;'>");
                sb.append(html);
                sb.append("</div><script src='http://code.jquery.com/jquery-1.7.2.min.js'></script>"+
                        "<script>$('img').each(function(){$(this).css({'width':'auto','max-width':'100%'})});"+   
                        "$('h1').css('font-size','16px');"+
                        "$('p').css('text-align','center');"+
                        "$('p').find('span').css('font-size','12px')"+
                        "</script></body></html>");
                html = sb.toString();
            }
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos, "utf-8");
            bw = new BufferedWriter(osw);
            bw.write(html);
        } catch (IOException e) {
        	logger.error("html getContent error：" + e );
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
            	logger.error("close resource error：" + e );
            }
        }
        
        //编辑成功后更新文章状态
        Article article = new Article();
        article.setId(id);
        article.setStatus(0);
        articleService.updateArticle(article);
        
        return success(model, "/article/list.htm", "文章编辑成功");
    }

    /**
     * 文件自定义修改初始化
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/articleEdit_init.htm", method = RequestMethod.GET)
    public String articleEditByUs_init(@RequestParam("id") Long id,ModelMap map) {
		Article ar = articleService.getArticleById(id);
        ArticleTemple temple = new ArticleTemple();
        temple.setId(id);
        temple.setLocalName(ar.getLocalUrl());
        File f = new File(filePath, ar.getLocalUrl());
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(f);
            reader = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(reader);
            sb.setLength(0);
            String text = "";
            while ((text = br.readLine()) != null) {
                sb.append(text);
            }
            temple.setContent(sb.toString().replace("body{overflow:hidden;}", "")
                .replace("&amp;", "&"));
        } catch (FileNotFoundException e) {
        	logger.error("file opt error：" + e );
        } catch (IOException e) {
        	logger.error("file opt error：" + e );
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
            	logger.error("close resource error：" + e );
            }
        }
        map.put("articleId", id);
        map.put("temple", temple);
        return "article/articleEdit_ueditor";
    }

}
