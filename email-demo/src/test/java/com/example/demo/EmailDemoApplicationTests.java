package com.example.demo;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.HttpClientUtil;
import com.example.demo.vo.amap.response.GeoVO;
import com.example.demo.vo.amap.response.GeocodesVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailDemoApplicationTests {

	@Autowired
	private JavaMailSender javaMailSender;

	@Test
	public void contextLoads() throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("2415621370@qq.com");
		helper.setTo("1754965038@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");
		javaMailSender.send(mimeMessage);

	}
	
	
	@Test
	public void geo(){
		String address = "华联超市";
		String city = "北京";
		
		StringBuffer sb = new StringBuffer();
		sb.append("http://restapi.amap.com/v3/geocode/geo?")
		.append("key=b4e3960361d93e458b28dd8b60c9b6c7")
		.append("&address="+address)
		.append("&city"+city)
		.append("&batch=false")
		.append("&output=JSON");
		
		System.out.println(sb.toString());
		
		JSONObject jSONObject = HttpClientUtil.executeDoGet(sb.toString());
		
		System.out.println(jSONObject.toJSONString());
		
		GeoVO geoVO = JSON.parseObject(jSONObject.toJSONString(), GeoVO.class);
		
		System.out.println(geoVO.getStatus());
		System.out.println(geoVO.getInfo());
		System.out.println(geoVO.getCount());
		System.out.println(geoVO.getInfocode());
		
		List<GeocodesVO> list = geoVO.getGeocodes();
		
		System.out.println(list.get(0).getFormatted_address());
		
		
	}

}
