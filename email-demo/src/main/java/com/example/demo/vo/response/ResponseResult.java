package com.example.demo.vo.response;

import java.io.Serializable;

/** 
 * @author 百慕古杜 
 * @version 创建时间：2018年6月28日 下午4:48:29 
 * 类说明 ：
 */
public class ResponseResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2484143170544532602L;
	
	/**
	 * 
	 */
	String code;
	
	/**
	 * 
	 */
	String message;
	
	/**
	 * 
	 */
	Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseResult() {
	}
	public ResponseResult(String code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public ResponseResult(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	
	
	
	
	

}
