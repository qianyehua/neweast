package com.skyjoo.neweast.biz.shop.enums;

/**
 * ����װ����������
 * @author lxh
 * @version 2015��7��23�� ����2:18:21
 */
public enum EnumShopDecorateAreaType {
	/**"title", "����"*/
	TITLE("title", "����"),
	/**"guide", "����"*/
	GUIDE("guide", "����"),
	/**"banner", "ͨ��"*/
	BANNER("banner", "ͨ��"),
	/**"seller_recommend", "�ƹ��Ƽ�"*/
	SELLER_RECOMMEND("seller_recommend", "�ƹ��Ƽ�"),
	/**"undefined_recommend", "�Զ����Ƽ�"*/
	UNDEFINED_RECOMMEND("undefined_recommend", "�Զ����Ƽ�"),
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
