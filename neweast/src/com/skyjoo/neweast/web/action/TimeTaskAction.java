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
 * ϵͳ��ʱ����
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
     * ȫ�������û����õȼ���Ϣ�������µ����õȼ���Ч��ʱ��
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
            return "�û����õȼ���Ϣ���³ɹ�. Ӱ������:" + result.getResult();
        }
        return "���õȼ�δ������û����õȼ�������¡�";
    }
    
    /**
     * ���ָ����û����õȼ���Ϣ���ռ��Σ�
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
        return "�û����õȼ����³ɹ��� Ӱ������:" + result.getResult();
    }
    
    /**
     * ������Ӫҵ��ͳ��
     * @return
     */
    @RequestMapping(value="statistic_shop_main_biz.htm", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String staticShopMainBiz() {
    	logger.info("staticShopMainBiz start");
    	salesVolumeService.statisticShopMainBiz();
    	logger.info("staticShopMainBiz end");
    	return "������Ӫҵ��ͳ�Ƴɹ���";
    }
}
