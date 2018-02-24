package com.skyjoo.neweast.web.validator;

import java.util.List;

import org.springframework.validation.Errors;
import org.springmodules.validation.valang.ValangValidator;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevel;
import com.skyjoo.neweast.biz.account.domain.UserAccountCreditLevelResult;


/**
 * 修改会员等级服务器端验证
 * 
 * @author wm
 * @version 
 */
public class AccountLevelValidator extends ValangValidator {

    public void validate(Object target, Errors errors) {
    	UserAccountCreditLevelResult result = (UserAccountCreditLevelResult) target;
        List<UserAccountCreditLevel> list = result.getList();

        for (int i = 0; i < list.size(); i++) {
        	UserAccountCreditLevel level = list.get(i);
            Long levelNo = level.getLevelNo();
            String levelName = level.getLevelName();
            Long lowLimit = level.getLowLimit();
            if (levelNo == null) {
                errors.rejectValue("list[" + i + "].levelNo", "common.error.required");
            } else if (levelNo.toString().length() > 12) {
                errors.rejectValue("list[" + i + "].levelNo", "common.error.overlength");
            }

            if (StringUtil.isBlank(levelName)) {
                errors.rejectValue("list[" + i + "].levelName", "common.error.required");
            } else if (levelName.length() > 15) {
                errors.rejectValue("list[" + i + "].levelName", "common.error.overlength");
            }

            if (lowLimit == null) {
                errors.rejectValue("list[" + i + "].lowLimit", "common.error.required");
            } else if (lowLimit.toString().length() > 17) {
                errors.rejectValue("list[" + i + "].lowLimit", "common.error.overlength");
            }
        }

    }
}
