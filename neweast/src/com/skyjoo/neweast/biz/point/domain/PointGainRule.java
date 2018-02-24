package com.skyjoo.neweast.biz.point.domain;

import java.text.DecimalFormat;
import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/*
 * ���ֻ�ȡ����
 */
public class PointGainRule extends DomainBase {

    private static final long serialVersionUID = -7906291802126167893L;

    private long              id;
    /*
     * �����¼����� login��¼ trade���� comment���� concern��ע trade_appraise��������
     * certificationʵ����֤ bank_bind������
     */

    private String            eventType;
    /*
     * �����¼�˵��
     */
    private String            eventDesc;
    /*
     * �������� unit�ݶ�� online_pc�ֻ�pc online_app�ֻ�app
     */
    private String            occurChannel;
    /*
     * �����������ͣ� 1������2����
     */
    private byte              basePointType    = 1;
    /*
     * ��������/����
     */
    private Double            basePoint;
    /*
     * �״λ������� 1������2����
     */
    private byte              firstPointType   = 1;
    /*
     * �״�����/����
     */
    private Double            firstPoint;
    /*
     * ��¼�ӳ�����
     */
    private Integer           loginPeriod;
    /*
     * ����Ч����
     */
    private Long              totalTimes;
    /*
     * ������Ч����
     */
    private Long              dailyTimes;

    private Date              GMTCreate;
    private Date              GMTModify;

    private DecimalFormat df = new DecimalFormat("######.######");
    
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getOccurChannel() {
        return occurChannel;
    }

    public void setOccurChannel(String occurChannel) {
        this.occurChannel = occurChannel;
    }

    public byte getBasePointType() {
        return basePointType;
    }

    public void setBasePointType(byte basePointType) {
        this.basePointType = basePointType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGMTCreate(Date gMTCreate) {
        GMTCreate = gMTCreate;
    }

    public void setGMTModify(Date gMTModify) {
        GMTModify = gMTModify;
    }

    public Long getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(Long totalTimes) {
        this.totalTimes = totalTimes;
    }

    public Long getDailyTimes() {
        return dailyTimes;
    }

    public void setDailyTimes(Long dailyTimes) {
        this.dailyTimes = dailyTimes;
    }

    public Double getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Double firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Integer getLoginPeriod() {
        return loginPeriod;
    }

    public void setLoginPeriod(Integer loginPeriod) {
        this.loginPeriod = loginPeriod;
    }

    public byte getFirstPointType() {
        return firstPointType;
    }

    public void setFirstPointType(byte firstPointType) {
        this.firstPointType = firstPointType;
    }

    public long getId() {
        return id;
    }

    public Date getGMTCreate() {
        return GMTCreate;
    }

    public Date getGMTModify() {
        return GMTModify;
    }

    public Double getBasePoint() {
        return basePoint;
    }

    public void setBasePoint(Double basePoint) {
        this.basePoint = basePoint;
    }

    public String showFirstPoint(){
        if (this.firstPoint == null) {
            return "";
        } else {
            if (this.firstPointType == 1)
                return new DecimalFormat("######").format(firstPoint);
            else
                return df.format( this.firstPoint);
        }
    }
    
    public String showBasePoint() {
        if (this.basePoint == null) {
            return "";
        } else {
            if (this.basePointType == 1)
                return new DecimalFormat("######").format(basePoint);
            else
                return df.format( this.basePoint);
        }
    }
    
    public String getFirstPointShow() {
        if (this.firstPoint == null) {
            return "";
        } else {
            if (this.firstPointType == 1)
                return new DecimalFormat("######").format(firstPoint) + "/����";
            else
                return df.format( this.firstPoint) + "/����";
        }
    }

    public String getBasePointShow() {
        if (this.basePoint == null) {
            return "";
        } else {
            if (this.basePointType == 1)
                return new DecimalFormat("######").format(basePoint) + "/����";
            else
                return df.format( this.basePoint)+ "/����";
        }
    }
}
