package com.skyjoo.neweast.web.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.service.SalesVolumeService;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditLevelService;
import com.skyjoo.neweast.biz.account.service.UserAccountCreditService;
import com.skyjoo.wudadao.common.enums.mall.account.EnumUserAccountType;

/**
 * 系统定时任务
 */
@Controller
@RequestMapping("/timetask/")
public class TimeTaskAction extends BaseAction {
    @Autowired
    private UserAccountCreditLevelService userAccountCreditLevelService;
    @Autowired
    private UserAccountCreditService userAccountCreditService;
    @Autowired
    private SalesVolumeService salesVolumeService;
    
	/**
     * 全部更新用户信用等级信息（当有新的信用等级生效的时候）
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "update_credit_level_all.htm" , produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateAllCredit() {
        if(userAccountCreditLevelService.isHasValidVersion()){
            Result<Integer> result = userAccountCreditService.updateCreditLevelAll(EnumUserAccountType.SELLER);
            if(result.isSuccess()){
                logger.info("creditLevel update success. effect count:" + result.getResult());
            }else{
                logger.error("creditLevel update fail:" + result.getResultInfo());
            }
            return "用户信用等级信息更新成功. 影响条数:" + result.getResult();
        }
        return "信用等级未变更，用户信用等级无需更新。";
    }
    
    /**
     * 部分更新用户信用等级信息（日间多次）
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "update_credit_level_part.htm", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String updateCredit() {
    	Result<Integer> result = userAccountCreditService.updateCreditLevelPart(EnumUserAccountType.SELLER);
        if(result.isSuccess()){
        	logger.info("creditLevel update success. effect count:" + result.getResult());
        }else{
        	logger.error("creditLevel update fail:" + result.getResultInfo());
        }
        return "用户信用等级更新成功。 影响条数:" + result.getResult();
    }
    
    /**
     * 店铺主营业务统计
     * @return
     */
    @RequestMapping(value="statistic_shop_main_biz.htm", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String staticShopMainBiz() {
    	logger.info("staticShopMainBiz start");
    	salesVolumeService.statisticShopMainBiz();
    	logger.info("staticShopMainBiz end");
    	return "店铺主营业务统计成功。";
    }
}
