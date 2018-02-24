package com.skyjoo.neweast.biz.common.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.hundsun.wudadao.common.Money;

/**
 * ��������
 * @author peng
 *
 */
public class MoneyUtils {

    /**
     * ת������ʽ����ԪΪ��λ0.00Ԫ
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
     * ��ȡ���111,000,000��ʽ
     * @param money
     * @return
     */
	public static String getMoneyFormatDesc(Long money) {
		if (money == null){
    		return "0.00";
    	}
		if (money == 0){
    		return "�� 0.00";
    	}
		NumberFormat numberformat = NumberFormat.getCurrencyInstance(Locale.CHINA);
		DecimalFormat decimalformat = (DecimalFormat) numberformat;
		decimalformat.setMinimumFractionDigits(2);
		decimalformat.setMaximumFractionDigits(2);
		decimalformat.setDecimalSeparatorAlwaysShown(true);
		String s = "��###,###.00";
		decimalformat.applyPattern(s);
		double d = money.doubleValue();
		return decimalformat.format(d);
	}
}
