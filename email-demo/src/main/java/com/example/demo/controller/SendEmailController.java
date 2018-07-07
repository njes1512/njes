package com.example.demo.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.vo.response.ResponseResult;
import com.example.demo.vo.email.SendEmail;

/**
 * @author 百慕古杜
 * @version 创建时间：2018年6月28日 下午4:39:54 类说明 ：
 */

@Controller
@RequestMapping("/send/email")
public class SendEmailController {
	
	
	Logger logger = LoggerFactory.getLogger(SendEmailController.class);

	@Autowired
	private JavaMailSender javaMailSender;

	
	@PostMapping
	@ResponseBody
	public ResponseResult sendEmail(@RequestBody @Valid SendEmail sendEmail,BindingResult bindingResult) {
		
		logger.info("this is params:"+sendEmail.toString());
		
		
		if(bindingResult.hasErrors()){
			return new ResponseResult("50000", "请求参数错误",bindingResult.getFieldError().getDefaultMessage());
		}

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("1563793867@qq.com");
			helper.setTo(sendEmail.getToUser());
			helper.setSubject(sendEmail.getSubject());
			helper.setText(sendEmail.getText());
			javaMailSender.send(mimeMessage);
			
			return new ResponseResult("20000", "发送成功");

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("发送邮箱出现错误："+e.getMessage());
			
			return new ResponseResult("50000", "系统错误");
		}


	}

}
