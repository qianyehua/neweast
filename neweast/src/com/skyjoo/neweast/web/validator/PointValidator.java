package com.skyjoo.neweast.web.validator;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.skyjoo.neweast.biz.point.domain.PointGainRule;

@Component
public class PointValidator implements Validator {
	private final static String TIMES = "^[0-9]{1,10}$";
	private final static String POINT = "^[0-9]{1,6}+(.[0-9]{1,6})0?$";
	private final static String AMOUNT= "^[0-9]{1,6}+(.0)?$";
    @Override
	public boolean supports(Class<?> clazz) {
		return PointGainRule.class.equals(clazz);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
		PointGainRule rule = (PointGainRule) obj;
		if (StringUtils.isNotBlank(rule.getEventDesc())) {
			if (StringUtils.length(rule.getEventDesc())>83) {
				errors.rejectValue("eventDesc", null, null, "积分说明长度过长，不要超过83");
			}
		}
		if (rule.getBasePointType()==2) {
		    if (rule.getBasePoint()!=null&&!Pattern.matches(POINT, new BigDecimal(rule.getBasePoint().toString()).toPlainString())) {
		        errors.rejectValue("basePoint", null, null, "大于零，整数最多6位，小数精确6位");
		    }
        }else{
            if (rule.getBasePoint()!=null&&!Pattern.matches(AMOUNT, rule.getBasePoint().toString())) {
                errors.rejectValue("basePoint", null, null, "请输入正整数,最大长度为六位");
            }
        }
		if (rule.getFirstPointType()==2) {
		    if (rule.getFirstPoint()!=null&&!Pattern.matches(POINT, rule.getFirstPoint().toString())) {
		        errors.rejectValue("firstPoint", null, null, "大于零，整数最多6位，小数精确6位");
		    }
        }else {
            if (rule.getFirstPoint()!=null&&!Pattern.matches(AMOUNT, rule.getFirstPoint().toString())) {
                errors.rejectValue("firstPoint", null, null, "请输入正整数,最大长度为六位");
            }
        }
		if (rule.getDailyTimes()!=null&&!Pattern.matches(TIMES, rule.getDailyTimes().toString())) {
			errors.rejectValue("dailyTimes", null, null, "请输入整数且最多10位数字");
		}
		if (rule.getTotalTimes()!=null&&!Pattern.matches(TIMES, rule.getTotalTimes().toString())) {
			errors.rejectValue("totalTimes", null, null, "请输入整数且最多10位数字");
		}
		if (rule.getLoginPeriod()!=null&&(rule.getLoginPeriod()<0)) {
			errors.rejectValue("loginPeriod", null, null, "连续登录加成应为正整数");
		}
	}
}
