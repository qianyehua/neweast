package com.skyjoo.neweast.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.activity.domain.Activity;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

@Component("activityValidator")
public class ActivityValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return SystemUser.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
	    Activity activity = (Activity) obj;
        if (StringUtils.isBlank(activity.getName())) {
            errors.rejectValue("name", null, null, "����Ʊ��");
        } else if (StringUtils.length(activity.getName()) > 50) {
            errors.rejectValue("name", null, null, "����Ƴ���ӦС��50�ַ���");
        }
        if (StringUtils.isBlank(activity.getIntroduction())) {
            errors.rejectValue("introduction", null, null, "��������");
        } else if (StringUtils.length(activity.getIntroduction()) > 100) {
            errors.rejectValue("introduction", null, null, "���������ӦС��100�ַ���");
        }
        if(activity.getOrdering() == null){
            errors.rejectValue("ordering", null, null, "�������");
        } else if(activity.getOrdering() > 999 || activity.getOrdering() < 0){
            errors.rejectValue("ordering", null, null, "��������ȷ�Ļ����");
        }
	}
}
