package com.skyjoo.neweast.web.cookyjar;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.eyeieye.melos.web.cookyjar.SelfDependence;
import com.eyeieye.melos.web.cookyjar.util.SelfUtil;
import com.skyjoo.neweast.biz.system.domain.SystemUser;

public class SystemUserAgent implements SelfDependence {
	
	private Long id;
	private String loginName;
	private BigInteger functions;// 以2进制位纪录管理员用户的权限
	
	public SystemUserAgent() {}
	
	public SystemUserAgent(SystemUser systemUser) {
		this.id = systemUser.getId();
		this.loginName = systemUser.getLoginName();
	}
	
	public void setFunctions(List<Integer> funs) {
		this.functions = new BigInteger("0");
		for (int en : funs) {
			this.functions = this.functions.setBit(en);
		}
	}
	
	public void setFunctions(int pos) {
		if (this.functions == null) {
			this.functions = new BigInteger("0");
		}
		this.functions = this.functions.setBit(pos);
	}
	
	/**
	 * 在指定的2进制位上是否有权限
	 * 
	 * @param index
	 * @return
	 */
	public boolean haveFunction(int index) {
		return this.functions.testBit(index);
	}
	
	private String base64Functions() {
		if (this.functions == null) {
			return null;
		}
		byte[] bs = this.functions.toByteArray();
		return Base64.encodeBase64String(bs);
	}

	private BigInteger debase64Functions(String v) {
		if (v == null) {
			return null;
		}
		byte[] bs = Base64.decodeBase64(v);
		return new BigInteger(bs);
	}

	@Override
	public String lieDown() {
		return SelfUtil.format(String.valueOf(this.id), this.loginName, base64Functions());
	}

	@Override
	public SelfDependence riseUp(String value) {
		String[] values = SelfUtil.recover(value);
		this.id = Long.valueOf(values[0]);
		this.loginName = values[1];
		this.functions = debase64Functions(values[2]);
		return this;
	}

	public Long getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public BigInteger getFunctions() {
		return functions;
	}
	
}
