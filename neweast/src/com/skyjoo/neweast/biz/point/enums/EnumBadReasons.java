package com.skyjoo.neweast.biz.point.enums;

public enum EnumBadReasons {
    BAD_DATA("���ݲ�ȫ"), BAD_AMOUNT("������ĿӦΪ�������Ҳ�����10λ"),REASON_TOLONG("�������ɲ��ܳ���50��"), BAD_ACCOUNT("���˻�״̬�����ڻ�������"),

    ;
    private EnumBadReasons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
