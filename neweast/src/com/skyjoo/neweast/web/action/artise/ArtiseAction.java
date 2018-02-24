package com.skyjoo.neweast.web.action.artise;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.account.domain.UserAccount;
import com.skyjoo.neweast.biz.account.enums.EnumRoleType;
import com.skyjoo.neweast.biz.account.service.UserAccountService;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.enums.EnumArtType;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseRecord;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;
import com.skyjoo.neweast.biz.artise.service.ArtiseRecordService;
import com.skyjoo.neweast.biz.artise.service.ArtiseService;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.service.ShopAuthApplyService;
import com.skyjoo.neweast.biz.shop.service.ShopService;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.cookyjar.SystemUserAgent;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;

/**
 * 
 * @author qgm
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("artise/")
public class ArtiseAction extends BaseAction {
     @Autowired
     private ArtiseService artiseService;
     @Autowired
     private ArtiseRecordService artiseRecordService;
     @Autowired
     private ArtService artService;  
     @Autowired
     private UserAccountService userAccountService;
     @Autowired
     private ShopAuthApplyService shopAuthApplyService;
     @Autowired
     private ShopService shopService;
     
     private static final String baseVMPath = "artise/";
     private String getReturnPage(String page) {
         return baseVMPath.concat(page);
     }
     
     /**
      * 获取全部艺术家
      */
     @RequestMapping(value="list.htm")
     public String artiselist(HttpServletRequest request,@ModelAttribute ("query") ArtiseQuery query, ModelMap model){
        artiseService.getArtisePage(query);
        model.addAttribute("artise", query);
        model.addAttribute("page", query);
        return getReturnPage("list");
           
     }
     /**
      * 获取艺术家详情
      */
     @RequestMapping(value="detail.htm")
     public String artisedetail(@RequestParam("artiseId") Long artiseId, ModelMap model){
             Artise artise = artiseService.getArtiseById(artiseId);
             List<ArtiseRecord> list = artiseRecordService.getRecordList(artise);
             model.addAttribute("artise", artise);
             model.addAttribute("record",list);
             String attach= artise.getArtWorks();
             if(attach != null && !"".equals(attach)){
                 String[] imgStr = attach.split("\\|");
                 model.addAttribute("imgStr",imgStr);
             }
             String arrach= artise.getCertifications();
             if(arrach != null && !"".equals(arrach)){
                 String[] cimgStr = arrach.split("\\|");
                 model.addAttribute("cimgStr",cimgStr);
             }
            return"artise/detail";
     }
     
     /**
      * 艺术家审核列表
      */
     @RequestMapping("/check_list.htm")
     public String artiseCheckQuery_list(HttpServletRequest request,@ModelAttribute("query")ArtiseQuery query,Model model){
         if(query.getStatus() == null){
             query.setStatus(-1);
         }
         artiseService.getCheckArtisePage(query);
         model.addAttribute("page", query);  
         return "artise/check_list";            
     }
     
     /**
      * 艺术家删除
      */
     @RequestMapping(value="delete.htm")
     public String deleteArtiseById(HttpServletRequest request,@RequestParam("artiseId")Long artiseId,Model model){
        
         artiseService.deleteArtiseById(artiseId);
         return  this.redirect("/artise/list.htm");
     
     }

     @RequestMapping(value="recommend.htm")
     public String addHomepageRecommendArtiseById(HttpServletRequest request,@ModelAttribute ("query") ArtiseQuery query,@RequestParam("artiseId") Long artiseId, ModelMap model,SystemUserAgent agent) {
        artiseService.addHomepageRecommendArtiseById(artiseId,agent.getLoginName());
        return  this.redirect("/artise/list.htm");
     }
     @RequestMapping(value="offrecommend.htm")
     public String offHomepageRecommendArtiseById(HttpServletRequest request,@ModelAttribute ("query") ArtiseQuery query,@RequestParam("artiseId") Long artiseId, ModelMap model,SystemUserAgent agent) {
         artiseService.offHomepageRecommendArtiseById(artiseId,agent.getLoginName());
         return  this.redirect("/artise/list.htm");
     }
     
     /**
      * 初始化艺术家审核
      * @param request
      * @param model
      * @return
      */
     @RequestMapping("/check_editIni.htm")
     public String check_editIni(HttpServletRequest request,Model model){
         Artise artise = artiseService.getArtiseById(Long.parseLong(request.getParameter("artiseId")));
         List<ArtiseRecord> list = artiseRecordService.getRecordList(artise);
         List<Art> artList = artService.getArtListByArtiseId(artise.getArtiseId());
         model.addAttribute("artise", artise);
         model.addAttribute("record",list);
         model.addAttribute("art",artList);
         model.addAttribute("artTypeList", EnumArtType.values());
         return "artise/check_edit";
     }    
     
     /**
      * 修改艺术家信息
      * @param request
      * @param art
      * @param model
      * @return
      */
     @RequestMapping("/edit.htm")
     public String check_edit(SystemUserAgent agent,HttpServletRequest request,@ModelAttribute("artise")Artise artise,Model model){
         artise.setArtiseId(Long.parseLong(request.getParameter("artiseId")));
         artise.setStatus(Integer.parseInt(request.getParameter("checkResult")));
         artise.setOperator(agent.getLoginName());
         if(artise.getTitle()!=null){
             artise.setTitle(artise.getTitle().replace(",", "|"));
         }
//         if(EnumRoleType.AGENT.getValue().equals(artise.getRoleType())&&Integer.parseInt(request.getParameter("checkResult"))==2){
//             artise.setArtist(artise.getArtiseName());
//         }
         Long editResult = artiseService.updateArtiseById(artise);
         
         //如果是机构用户，需要创建店铺
         if(EnumRoleType.AGENT.getValue().equals(artise.getRoleType())&&Integer.parseInt(request.getParameter("checkResult"))==1){
            Result<Boolean> res =  CreateShop(artise.getUserId(),artise.getArtiseId());
            if(!res.isSuccess())  return "error";
         }
         
         //在审核流水表里面记录审核日志
         AuditLog log = new AuditLog();
         log.setType("artise");//审核类型
         log.setRelatedID(artise.getArtiseId());//关联ID
         // STATUS  状态
         String status = "R";// R：拒绝
         if(Integer.parseInt(request.getParameter("checkResult"))==1){
             status = "P";//P 通过
         }
         log.setStatus(status);
         log.setAuditContent("");//审核内容,暂时为空
         log.setMemo(artise.getMemo());// 备注 主要是审核不通过原因
         log.setAuditor(agent.getLoginName());// 审核人

         Long result = artService.addAuditLog(log);
         if(result==0) return "error";
         //-------
         
         String url = "/artise/check_list.htm";     
         return editResult == 0 ? "error":success(model,url,"操作成功");
     }  
     
     
     //创建机构店铺
     public Result<Boolean> CreateShop(Long Id,Long artiseId){
         Result<Boolean> res = new Result<Boolean>(true);
         //获取该用户个人信息，在未升级之前，只能到USERACCOUNT表里面去拿数据，以后到认证表里面去拿数据
         UserAccount userAccount = userAccountService.getUserAccountById(Id);
         Artise artise = artiseService.getArtiseById(artiseId);
         //为了保证当前版本的逻辑继续进行，这里保持原来逻辑向申请表插入数据，申请的STATUS为通过状态，只是在初始化开店的时候，所有的权限都是关闭状态
         ShopAuthApply  apply = new ShopAuthApply();
         apply.setAccountId(userAccount.getId());
         apply.setLoginId(userAccount.getStockAccount());
         apply.setType(EnumShopAuthType.PERSONAL);
         apply.setRegion(userAccount.getCountry()==null?"CN":userAccount.getCountry());
         apply.setRealName(artise.getArtist());
         apply.setLicenseType(userAccount.getLicenseType() == null?"P01":userAccount.getLicenseType()); //后期需要到审核表里面去拿数据
         apply.setLicense(userAccount.getLicense() == null?"0":userAccount.getLicense());//后期需要去审核表同步数据
         apply.setGender(userAccount.getGender());
         apply.setAddress("中国");//后期需要改进
         apply.setMobile(userAccount.getMobile()==null?"0":userAccount.getMobile());
         apply.setAttachment("0");
         apply.setStatus(EnumShopAuthStatus.AUDIT_SUCCESS);
         apply.setMemo("改版非完全数据,等待用户审核数据");
  
         
         Result<ShopAuthApply> result  = shopAuthApplyService.createShopAuthApply(apply);        
         
         //由于要跳过店铺流程，所以用户申请开店(即成为卖家),申请店铺成功以后,还要创建店铺信息
         if(result.isSuccess()) {
             //插入或者更新店铺信息
             Shop shop = shopService.getShopByAccountId(Id);
             if(shop == null) {
                 shop = new Shop();
                 shop.setName(apply.getRealName());
                 shop.setName(userAccount.getRealName() +"的店铺");
                 shop.setAccountId(userAccount.getId());
                 shop.setLogoPath(userAccount.getPortrait() != null ? userAccount.getPortrait() : "portrait/10301/2c9582fd57e66d230157e67cef7c0001.png");
                 shop.setMobile(userAccount.getMobile()==null?"0":userAccount.getMobile());
                 shop.setStatus(EnumShopStatus.NORMAL);              
             }
             
             Result<Shop> result1 = shopService.createOrUpdateShop(shop);
             if(result1.isSuccess()) {
                 res.setSuccess(true);
             } else {
                 res.setSuccess(false);
             }
         } 
         return res.setResult(true);
     }
}