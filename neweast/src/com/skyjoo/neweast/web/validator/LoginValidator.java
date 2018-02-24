package com.skyjoo.neweast.web.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.system.domain.SystemUser;

@Component("loginValidator")
public class LoginValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return SystemUser.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		SystemUser user = (SystemUser) obj;
		if (StringUtils.isBlank(user.getLoginName())) {
			errors.rejectValue("loginName", null, null, "«Î ‰»Îµ«¬º’À∫≈");
		}
		if (StringUtils.isBlank(user.getPassword())) {
			errors.rejectValue("password", null, null, "«Î ‰»Îø⁄¡Ó");
		}
	}
}
