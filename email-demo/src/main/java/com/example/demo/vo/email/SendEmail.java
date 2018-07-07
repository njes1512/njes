package com.example.demo.vo.email;

import org.hibernate.validator.constraints.NotBlank;

/** 
 * @author 百慕古杜 
 * @version 创建时间：2018年6月29日 上午8:43:10 
 * 类说明 ：
 */
public class SendEmail {
	
	
	//String fromUser;
	
	
	@NotBlank(message="接收方邮箱不能为空")
	String toUser;
	
	@NotBlank(message="邮箱主题不能为空")
	String subject;
	
	
	@NotBlank(message="邮箱内容不能为空")
	String text;

	
	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SendEmail() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SendEmail [toUser=" + toUser + ", subject=" + subject
				+ ", text=" + text + "]";
	}
	
	
	

}
