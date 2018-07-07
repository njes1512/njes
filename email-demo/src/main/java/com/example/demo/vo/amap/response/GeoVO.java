package com.example.demo.vo.amap.response;

import java.util.List;

/** 
 * @author 百慕古杜 
 * @version 创建时间：2018年6月29日 下午4:59:34 
 * 类说明 ：
 */
public class GeoVO {
	
	String infocode;
	String status;
	String count;
	String info;
	List<GeocodesVO> geocodes;
	
	
	
	
	
	public String getInfocode() {
		return infocode;
	}
	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<GeocodesVO> getGeocodes() {
		return geocodes;
	}
	public void setGeocodes(List<GeocodesVO> geocodes) {
		this.geocodes = geocodes;
	}
	
	
	



}
