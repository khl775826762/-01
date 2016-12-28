package com.atguigu.jf.console.user.bean.bo;

import java.util.List;

/**
 * @包名 com.atguigu.jf.console.user.bean.bo
 * @类名 SysFuncBean.java
 * @作者 zlt
 * @创建日期 2016年11月7日
 * @描述 菜单需要业务实体
 * @版本 V 1.0
 */
public class SysFuncBean {
	private List<SysFuncBean> children;
	
	public List<SysFuncBean> getChildren() {
		return children;
	}

	public void setChildren(List<SysFuncBean> children) {
		this.children = children;
	}

	private Long funcId;

	private Short funcType;

	private Long supFuncId;

	private Short funcLevel;

	private String funcCode;

	private String funcName;

	private Integer funcOrder;

	private String funcUrl;

	private String funcImg;

	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

	public Short getFuncType() {
		return funcType;
	}

	public void setFuncType(Short funcType) {
		this.funcType = funcType;
	}

	public Long getSupFuncId() {
		return supFuncId;
	}

	public void setSupFuncId(Long supFuncId) {
		this.supFuncId = supFuncId;
	}

	public Short getFuncLevel() {
		return funcLevel;
	}

	public void setFuncLevel(Short funcLevel) {
		this.funcLevel = funcLevel;
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public Integer getFuncOrder() {
		return funcOrder;
	}

	public void setFuncOrder(Integer funcOrder) {
		this.funcOrder = funcOrder;
	}

	public String getFuncUrl() {
		return funcUrl;
	}

	public void setFuncUrl(String funcUrl) {
		this.funcUrl = funcUrl;
	}

	public String getFuncImg() {
		return funcImg;
	}

	public void setFuncImg(String funcImg) {
		this.funcImg = funcImg;
	}

}