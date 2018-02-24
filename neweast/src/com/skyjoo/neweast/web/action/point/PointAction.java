package com.skyjoo.neweast.web.action.point;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hundsun.wudadao.common.util.DateUtil;
import com.skyjoo.neweast.biz.common.util.ExcelPOIUtil;
import com.skyjoo.neweast.biz.point.domain.ExcelCell;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;
import com.skyjoo.neweast.biz.point.domain.query.PointChangeLogQuery;
import com.skyjoo.neweast.biz.point.domain.query.PointGainRuleQuery;
import com.skyjoo.neweast.biz.point.domain.query.UserPointQuery;
import com.skyjoo.neweast.biz.point.enums.EnumBadReasons;
import com.skyjoo.neweast.biz.point.enums.EnumEventType;
import com.skyjoo.neweast.biz.point.enums.EnumOccurChannel;
import com.skyjoo.neweast.biz.point.service.PointChangeLogServer;
import com.skyjoo.neweast.biz.point.service.PointConfigServer;
import com.skyjoo.neweast.biz.point.service.UserPointServer;
import com.skyjoo.neweast.web.action.BaseAction;
import com.skyjoo.neweast.web.validator.PointValidator;
import com.skyjoo.wudadao.greenbird.dto.PointChangeDTO;

@Controller
@RequestMapping("/point/")
public class PointAction extends BaseAction {
    @Autowired
    private PointConfigServer    pointConfigServer;
    @Autowired
    private PointValidator       pointValidator;
    @Autowired
    private UserPointServer      userPointServer;
    @Autowired
    private PointChangeLogServer changeLogServer;
    private static String        regexNumber = "^[0-9]{1,10}";

    @RequestMapping("list.htm")
    public String list(@ModelAttribute("query") PointGainRuleQuery query, ModelMap model) {
        model.put("eventType", EnumEventType.values());
        model.put("occChal", EnumOccurChannel.values());
        pointConfigServer.list(query);
        return "/point/list";
    }

    @RequestMapping(value = "config.htm", method = RequestMethod.GET)
    public String config_init(@RequestParam("type") String type,
                              @RequestParam("chann") String chann, ModelMap model) {
        PointGainRule gainRule = pointConfigServer.getPointGainRuleByType(type, chann);//查询积分规则
        model.put("flag", gainRule == null);//判断配置是否存在
        if (gainRule == null) {
            gainRule = pointConfigServer.getThreeSynparameter(type);
        }
        int index = EnumOccurChannel.getDesc(chann).getIndex();//渠道索引
        model.put("index", index);//渠道选项
        model.put("type", type);//类型
        model.put("chann", chann);//渠道
        model.put("gainRule", gainRule);
        model.put("eventType", EnumEventType.values());//事件类型
        model.put("occChal", EnumOccurChannel.values());//渠道类型

        return "/point/config";
    }

    @RequestMapping(value = "config.htm", method = RequestMethod.POST)
    public String config(@ModelAttribute("gainRule") PointGainRule rule,
                         @RequestParam("flag") boolean flag, @RequestParam("index") int index,
                         BindingResult result, ModelMap model) {
        pointValidator.validate(rule, result);
        if (result.hasErrors()) {
            model.put("index", index);
            model.put("flag", rule == null);
            model.put("type", rule.getEventType());
            model.put("chann", rule.getOccurChannel());
            model.put("eventType", EnumEventType.values());
            model.put("occChal", EnumOccurChannel.values());
            return "/point/config";
        }
        // 三个参数 各渠道同步
        pointConfigServer.updateAll(rule);
        if (flag) {
            pointConfigServer.add(rule);
        } else {
            pointConfigServer.edit(rule);
        }
        model.put("url", "/point/list.htm");
        return "success";
    }

    @RequestMapping(value = "import.htm", method = RequestMethod.GET)
    public String importExcel() {
        return "/point/import";
    }

    /**
     * 管理员从后台强行通过导入excel的方式为某些用户增加积分。
     * 
     * @param infoExcel
     * @param model
     * @return
     */
    @RequestMapping(value = "import.htm", method = RequestMethod.POST)
    public String importExcel(@RequestParam(value = "infoExcel") MultipartFile infoExcel,
                              ModelMap model) {
        String[] prefix = { "", "0", "00", "000", "0000", "00000", "000000", "0000000" };
        String excelName = infoExcel.getOriginalFilename();
        String suffix = excelName.substring(excelName.lastIndexOf(".") + 1);
        if (!suffix.equals("xls") && !suffix.equals("xlsx")) {
            model.put("infoError", "请上传Excel文件(*.xls、*.xlsx)");
            return "/point/import";
        }
        ExcelPOIUtil poiUtil = new ExcelPOIUtil();
        List<ArrayList<String>> dataLst = poiUtil.read(infoExcel);
        List<ExcelCell> listCell = new ArrayList<ExcelCell>();
        List<ExcelCell> badCellList = new ArrayList<ExcelCell>();
        int blank = 0;//空的个数，便于后面计算
        Pattern pattern = Pattern.compile(regexNumber);
        int index = 0;//显示坏数据序列
        for (ArrayList<String> arrayList : dataLst) {
            ExcelCell cell = new ExcelCell();
            //判断在Excel中是文本格式还是自定义格式
            String tradeAccount = ((arrayList.get(0).length() < 8) && (arrayList.get(0).length() > 0)) ? prefix[8 - arrayList
                .get(0).length()] + arrayList.get(0)
                : arrayList.get(0);
            cell.setIndex(++index);

            // 只有第一列
            if (arrayList.size() == 1) {
                cell.setTradeAccount(arrayList.get(0));
                cell.setBadReason(EnumBadReasons.BAD_DATA.getValue());
                badCellList.add(cell);
                continue;
            } else if (arrayList.size() == 2) {
                // 第一列为空
                if (StringUtils.isBlank(arrayList.get(0))) {
                    if (StringUtils.isBlank(arrayList.get(1))) {
                        ++blank;
                        continue;
                    }
                    cell.setTradeAccount(arrayList.get(0));
                    cell.setBadAmount(arrayList.get(1));
                    cell.setBadReason(EnumBadReasons.BAD_DATA.getValue());
                    badCellList.add(cell);
                    continue;
                } else {
                    
                    //判断是否处于销户状态
                    if (!userPointServer.checkAccount(tradeAccount)) {
                        cell.setTradeAccount(arrayList.get(0));
                        cell.setBadAmount(arrayList.get(1));
                        cell.setBadReason(EnumBadReasons.BAD_ACCOUNT.getValue());
                        badCellList.add(cell);
                        continue;
                    }
                    if (pattern.matcher(arrayList.get(1)).matches()) {
                        cell.setTradeAccount(tradeAccount);
                        cell.setAmount(Long.valueOf(arrayList.get(1)));
                        ++index;
                        listCell.add(cell);
                        continue;
                    } else {
                        cell.setTradeAccount(arrayList.get(0));
                        cell.setBadAmount(arrayList.get(1));
                        cell.setBadReason(EnumBadReasons.BAD_AMOUNT.getValue());
                        badCellList.add(cell);
                        continue;
                    }
                }
            } else {
                if (StringUtils.isBlank(arrayList.get(0)) && StringUtils.isBlank(arrayList.get(1))
                    && StringUtils.isBlank(arrayList.get(2))) {
                    ++blank;
                    continue;
                }
                if (StringUtils.isBlank(arrayList.get(0))) {
                    cell.setTradeAccount(arrayList.get(0));
                    cell.setBadAmount(arrayList.get(1));
                    cell.setReason(arrayList.get(2));
                    cell.setBadReason(EnumBadReasons.BAD_DATA.getValue());
                    badCellList.add(cell);
                    continue;
                }
                //判断是否处于销户状态
                else if (!userPointServer.checkAccount(tradeAccount)) {
                    cell.setTradeAccount(arrayList.get(0));
                    cell.setReason(arrayList.get(2));
                    cell.setBadAmount(arrayList.get(1));
                    cell.setBadReason(EnumBadReasons.BAD_ACCOUNT.getValue());
                    badCellList.add(cell);
                    continue;
                } else if (StringUtils.isBlank(arrayList.get(1))
                           || StringUtils.length(arrayList.get(2)) > 50) {
                    cell.setTradeAccount(arrayList.get(0));
                    cell.setBadAmount(arrayList.get(1));
                    cell.setReason(arrayList.get(2));
                    if (StringUtils.isBlank(arrayList.get(1))){
                        cell.setBadReason(EnumBadReasons.BAD_DATA.getValue());
                    }else {
                        cell.setBadReason(EnumBadReasons.REASON_TOLONG.getValue());
                    }
                    badCellList.add(cell);
                    continue;
                } else {
                    if (pattern.matcher(arrayList.get(1)).matches()) {
                        cell.setTradeAccount(tradeAccount);
                        cell.setAmount(Long.valueOf(arrayList.get(1)));
                        cell.setReason(arrayList.get(2));
                        ++index;
                        listCell.add(cell);
                        continue;
                    } else {
                        cell.setTradeAccount(arrayList.get(0));
                        cell.setReason(arrayList.get(2));
                        cell.setBadAmount(arrayList.get(1));
                        cell.setBadReason(EnumBadReasons.BAD_AMOUNT.getValue());
                        badCellList.add(cell);
                        continue;
                    }
                }
            }
        }

        for (PointChangeDTO pcd : userPointServer.edit(listCell)) {
            ExcelCell cell = new ExcelCell();
            cell.setBadAmount(pcd.getPointAmount().toString());
            cell.setTradeAccount(pcd.getTradeAccount());
            cell.setReason(pcd.getMemo());
            cell.setIndex(++index);
            badCellList.add(cell);
        }
        model.put("suc", dataLst.size()-badCellList.size()-blank);
        model.put("fail", badCellList.size());
        model.put("badData", badCellList);
        model.put("url", "/point/import.htm");
        return "/point/import";
    }

    /*
     * 会员积分查询
     */
    @RequestMapping(value = "userpointsearch.htm")
    public String UserPointSearch(@ModelAttribute("query") UserPointQuery query, ModelMap model) {
        userPointServer.list(query);
        return "/point/userPointSearch";
    }

    /*
     * 积分流水查询
     */
    @RequestMapping(value = "pointlogsearch.htm")
    public String PointLogSearch(@ModelAttribute("query") PointChangeLogQuery query,
                                 ModelMap model,
                                 @RequestParam(value = "account", required = false) String tradeAccount) {
        if (StringUtils.isBlank(query.getStartTime())) {
            query.setStartTime(DateUtil.convertDateToString(new Date()));
        }
        if (StringUtils.isBlank(query.getEndTime())) {
            query.setEndTime(DateUtil.convertDateToString(new Date()));
        }
        if (StringUtils.isNotBlank(tradeAccount)) {
            query.setTradeAccount(tradeAccount);
        }
        changeLogServer.list(query);
        return "/point/pointLogSearch";
    }
}
