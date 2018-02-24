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
        	errors.rejectValue("articleTitle", null, null, "���±�����");
        } else if (StringUtils.length(article.getArticleTitle()) > 50) {
        	errors.rejectValue("articleTitle", null, null, "���±��ⳤ��ӦС��50�ַ���");
        }
        if (article.getMediaId() == null) {
            errors.rejectValue("mediaId", null, null, "��������ý���ѡ��");
        }
        if (article.getSubjectIds() == null || article.getSubjectIds().size() == 0) {
            errors.rejectValue("subjectIds", null, null, "��������ר���ѡ��");
        }
        if (StringUtils.isBlank(article.getArticleAbstract())) {
        	errors.rejectValue("articleAbstract", null, null, "����ժҪ���");
        } else if (StringUtils.length(article.getArticleAbstract()) > 200) {
        	errors.rejectValue("articleAbstract", null, null, "����ժҪ����ӦС��200�ַ���");
        }
        if (StringUtils.isBlank(article.getOriginalUrl())) {
            if(StringUtils.isBlank(article.getContent())){
                errors.rejectValue("originalUrl", null, null, "ԭ�����ӱ��");
            }
        } else if (StringUtils.length(article.getOriginalUrl()) > 256) {
        	errors.rejectValue("originalUrl", null, null, "ԭ�����ӳ���ӦС��256�ַ���");
        }
    }

}
