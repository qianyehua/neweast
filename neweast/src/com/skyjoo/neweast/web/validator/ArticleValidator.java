package com.skyjoo.neweast.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.article.domain.Article;

/**
 * @author cjj
 */
@Component
public class ArticleValidator implements Validator {

    private static long         MAX_SIZE = 2 * 1024 * 1024;
    private static final String    WXHost          = "mp.weixin.qq.com";

    @Override
	public boolean supports(Class<?> clazz) {
		return Article.class.equals(clazz);
	}

    @Override
    public void validate(Object object, Errors errors) {
        Article article = (Article) object;
        if (StringUtils.isBlank(article.getArticleTitle())) {
        	errors.rejectValue("articleTitle", null, null, "文章标题必填！");
        } else if (StringUtils.length(article.getArticleTitle()) > 50) {
        	errors.rejectValue("articleTitle", null, null, "文章标题长度应小于50字符！");
        }
        if (article.getMediaId() == null) {
            errors.rejectValue("mediaId", null, null, "文章所属媒体必选！");
        }
        if (article.getSubjectIds() == null || article.getSubjectIds().size() == 0) {
            errors.rejectValue("subjectIds", null, null, "文章所属专题必选！");
        }
        if (StringUtils.isBlank(article.getArticleAbstract())) {
        	errors.rejectValue("articleAbstract", null, null, "文章摘要必填！");
        } else if (StringUtils.length(article.getArticleAbstract()) > 200) {
        	errors.rejectValue("articleAbstract", null, null, "文章摘要长度应小于200字符！");
        }
        if (StringUtils.isBlank(article.getOriginalUrl())) {
            if(StringUtils.isBlank(article.getContent())){
                errors.rejectValue("originalUrl", null, null, "原文链接必填！");
            }
        } else if (StringUtils.length(article.getOriginalUrl()) > 256) {
        	errors.rejectValue("originalUrl", null, null, "原文链接长度应小于256字符！");
        }
    }

}
