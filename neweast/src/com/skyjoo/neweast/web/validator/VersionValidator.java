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
        	errors.rejectValue("versionNo", null, null, "�汾�ű��");
        } else if (StringUtils.length(versionInfo.getVersionNo()) > 10) {
        	errors.rejectValue("versionNo", null, null, "�汾��ӦС��10�ַ���");
        }
        if (versionInfo.getVersionNum() == null) {
        	errors.rejectValue("versionNum", null, null, "�汾���ֺű��");
        } else if (String.valueOf(versionInfo.getVersionNum()).length() > 3) {
        	errors.rejectValue("versionNum", null, null, "�汾���ֺų���Ӧ������3��");
        }
        if (versionInfo.getMinSupportVersion() == null) {
            errors.rejectValue("minSupportVersion", null, null, "���֧�ְ汾���ֺű��");
        } else if (String.valueOf(versionInfo.getMinSupportVersion()).length() > 3) {
            errors.rejectValue("minSupportVersion", null, null, "���֧�ְ汾���ֺ�Ӧ������3��");
        }
        if (StringUtils.isBlank(versionInfo.getUrl())) {
            errors.rejectValue("url", null, null, "���ص�ַ���");
        } else if (StringUtils.length(versionInfo.getUrl()) > 300) {
            errors.rejectValue("url", null, null, "���ص�ַ����ӦС��300�ַ���");
        }
        if (StringUtils.isBlank(versionInfo.getSoftBackPic())) {
            errors.rejectValue("url", null, null, "����ͼƬ���");
        } else if (StringUtils.length(versionInfo.getSoftBackPic()) > 300) {
            errors.rejectValue("url", null, null, "����ͼƬ����ӦС��300�ַ���");
        }
        if (!StringUtils.isBlank(versionInfo.getRemark()) && StringUtils.length(versionInfo.getRemark()) > 300) {
            errors.rejectValue("remark", null, null, "��עӦС��300�ַ���");
        }
        if (!StringUtils.isBlank(versionInfo.getSoftDesc()) && StringUtils.length(versionInfo.getSoftDesc()) > 300) {
            errors.rejectValue("remark", null, null, "�������ӦС��300�ַ���");
        }
    }

}
