package com.skyjoo.neweast.biz.shop.enums;

/**
 * 店铺装修区域类型
 * @author lxh
 * @version 2015年7月23日 下午2:18:21
 */
public enum EnumShopDecorateAreaType {
	/**"title", "店招"*/
	TITLE("title", "店招"),
	/**"guide", "导航"*/
	GUIDE("guide", "导航"),
	/**"banner", "通栏"*/
	BANNER("banner", "通栏"),
	/**"seller_recommend", "掌柜推荐"*/
	SELLER_RECOMMEND("seller_recommend", "掌柜推荐"),
	/**"undefined_recommend", "自定义推荐"*/
	UNDEFINED_RECOMMEND("undefined_recommend", "自定义推荐"),
	;
	private String value;
	private String desp;
	
	private EnumShopDecorateAreaType(String value, String desp) {
		this.value = value;
		this.desp = desp;
	}

	public String getValue() {
		return value;
	}

	public String getDesp() {
		return desp;
	}
	
}
