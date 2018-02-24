package com.skyjoo.neweast.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.app.domain.VersionInfo;
import com.skyjoo.neweast.biz.article.domain.Article;

/**
 * @author cjj
 */
@Component
public class VersionValidator implements Validator {

    @Override
	public boolean supports(Class<?> clazz) {
		return VersionInfo.class.equals(clazz);
	}

    @Override
    public void validate(Object object, Errors errors) {
        VersionInfo versionInfo = (VersionInfo) object;
        if (StringUtils.isBlank(versionInfo.getVersionNo())) {
        	errors.rejectValue("versionNo", null, null, "版本号必填！");
        } else if (StringUtils.length(versionInfo.getVersionNo()) > 10) {
        	errors.rejectValue("versionNo", null, null, "版本号应小于10字符！");
        }
        if (versionInfo.getVersionNum() == null) {
        	errors.rejectValue("versionNum", null, null, "版本数字号必填！");
        } else if (String.valueOf(versionInfo.getVersionNum()).length() > 3) {
        	errors.rejectValue("versionNum", null, null, "版本数字号长度应不大于3！");
        }
        if (versionInfo.getMinSupportVersion() == null) {
            errors.rejectValue("minSupportVersion", null, null, "最低支持版本数字号必填！");
        } else if (String.valueOf(versionInfo.getMinSupportVersion()).length() > 3) {
            errors.rejectValue("minSupportVersion", null, null, "最低支持版本数字号应不大于3！");
        }
        if (StringUtils.isBlank(versionInfo.getUrl())) {
            errors.rejectValue("url", null, null, "下载地址必填！");
        } else if (StringUtils.length(versionInfo.getUrl()) > 300) {
            errors.rejectValue("url", null, null, "下载地址长度应小于300字符！");
        }
        if (StringUtils.isBlank(versionInfo.getSoftBackPic())) {
            errors.rejectValue("url", null, null, "背景图片必填！");
        } else if (StringUtils.length(versionInfo.getSoftBackPic()) > 300) {
            errors.rejectValue("url", null, null, "背景图片长度应小于300字符！");
        }
        if (!StringUtils.isBlank(versionInfo.getRemark()) && StringUtils.length(versionInfo.getRemark()) > 300) {
            errors.rejectValue("remark", null, null, "备注应小于300字符！");
        }
        if (!StringUtils.isBlank(versionInfo.getSoftDesc()) && StringUtils.length(versionInfo.getSoftDesc()) > 300) {
            errors.rejectValue("remark", null, null, "软件描述应小于300字符！");
        }
    }

}
