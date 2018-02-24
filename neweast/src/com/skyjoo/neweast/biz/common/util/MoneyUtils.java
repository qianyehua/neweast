package com.skyjoo.neweast.biz.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.hundsun.wudadao.common.Money;

/**
 * 金额处理工具类
 * @author peng
 *
 */
public class MoneyUtils {

    /**
     * 转化金额格式，以元为单位0.00元
     * @param money
     * @return
     */
    public static String getMoneyDesc(Long money){
    	if (money == null){
    		return "0.00";
    	}
        Money costPriceM = new Money();
        costPriceM.setCent(money);
        return costPriceM.toString();
    }

    /**
     * 获取金额111,000,000格式
     * @param money
     * @return
     */
	public static String getMoneyFormatDesc(Long money) {
		if (money == null){
    		return "0.00";
    	}
		if (money == 0){
    		return "￥ 0.00";
    	}
		NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.CHINA);
		DecimalFormat decimalformat = (DecimalFormat) numberformat;
		decimalformat.setMinimumFractionDigits(2);
		decimalformat.setMaximumFractionDigits(2);
		decimalformat.setDecimalSeparatorAlwaysShown(true);
		String s = "￥###,###.00";
		decimalformat.applyPattern(s);
		double d = money.doubleValue();
		return decimalformat.format(d);
	}
}
