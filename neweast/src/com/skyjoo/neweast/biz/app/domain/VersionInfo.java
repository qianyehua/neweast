package com.skyjoo.neweast.biz.app.domain;

public class VersionInfo {
	/**
	 * pk,seq
	 */
	private Long id;
	//版本号
	private String versionNo;
	//版本数字号
	private Long versionNum;
	//版本类型
	private String type;
	//是否强制更新
	private String isForce;
	//下载地址
	private String url;
	//备注
	private String remark;
	//软件描述
	private String softDesc;
	//背景图片
	private String softBackPic;
	//最低支持版本号
	private Long minSupportVersion;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getVersionNo() {
        return versionNo;
    }
    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }
    public Long getVersionNum() {
        return versionNum;
    }
    public void setVersionNum(Long versionNum) {
        this.versionNum = versionNum;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getIsForce() {
        return isForce;
    }
    public void setIsForce(String isForce) {
        this.isForce = isForce;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getSoftDesc() {
        return softDesc;
    }
    public void setSoftDesc(String softDesc) {
        this.softDesc = softDesc;
    }
    public String getSoftBackPic() {
        return softBackPic;
    }
    public void setSoftBackPic(String softBackPic) {
        this.softBackPic = softBackPic;
    }
    public Long getMinSupportVersion() {
        return minSupportVersion;
    }
    public void setMinSupportVersion(Long minSupportVersion) {
        this.minSupportVersion = minSupportVersion;
    }
}
