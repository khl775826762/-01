package com.atguigu.jf.console.common.bean.bo;

public class ResultBean {
	public final static String RESULT_FAILED="failed";
	public final static String RESULT_SUCCESS="success";
	private String result;
	private String msg;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public static String getResultFailed() {
		return RESULT_FAILED;
	}
	public static String getResultSuccess() {
		return RESULT_SUCCESS;
	}
	
	
}
