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
            errors.rejectValue("name", null, null, "活动名称必填！");
        } else if (StringUtils.length(activity.getName()) > 50) {
            errors.rejectValue("name", null, null, "活动名称长度应小于50字符！");
        }
        if (StringUtils.isBlank(activity.getIntroduction())) {
            errors.rejectValue("introduction", null, null, "活动描述必填！");
        } else if (StringUtils.length(activity.getIntroduction()) > 100) {
            errors.rejectValue("introduction", null, null, "活动描述长度应小于100字符！");
        }
        if(activity.getOrdering() == null){
            errors.rejectValue("ordering", null, null, "活动排序必填！");
        } else if(activity.getOrdering() > 999 || activity.getOrdering() < 0){
            errors.rejectValue("ordering", null, null, "请输入正确的活动排序！");
        }
	}
}
