package com.skyjoo.neweast.web.validator.shop;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;

@Component("shopTemplateValidator")
public class ShopTemplateValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return ShopTemplate.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ShopTemplate template = (ShopTemplate) obj;
		if (StringUtils.isBlank(template.getTitle().toString())) {
			errors.rejectValue("title", null, null, "请输入模版标题");
		}
		if (StringUtils.isBlank(template.getTemplateName())) {
			errors.rejectValue("templateName", null, null, "请输入模版名称");
		}
//		if (StringUtils.isBlank(template.getPreviewPic())) {
//			errors.rejectValue("previewPic", null, null, "请选择预览图");
//		}
		if (StringUtils.isBlank(template.getPreviewUrl())) {
			errors.rejectValue("previewUrl", null, null, "请输入首页预览URL");
		}
	}
}
