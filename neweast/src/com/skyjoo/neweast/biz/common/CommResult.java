package com.skyjoo.neweast.biz.common;

import com.hundsun.wudadao.common.DomainBase;

public class CommResult extends DomainBase{
	
	private static final long serialVersionUID = -4925348143583836788L;
	private boolean success;
	private String errorCode;
	private String errorMsg;
	
	public CommResult() {
	}
	
	public CommResult(Boolean success) {
		this.success = success;
	}
	
	public CommResult(boolean success, String errorCode, String errorMsg) {
		this.success = success;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
