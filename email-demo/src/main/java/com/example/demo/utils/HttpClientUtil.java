package com.example.demo.utils;

import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus.Series;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 百慕古杜
 * @version 创建时间：2018年6月29日 下午4:36:29 类说明 ：
 */
public class HttpClientUtil {
	
	
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static JSONObject executeDoGet(String url) {
		RequestConfig defaultRequestConfig = RequestConfig.custom()
				.setSocketTimeout(20000).setConnectTimeout(5000)
				.setConnectionRequestTimeout(5000)
				// .setStaleConnectionCheckEnabled(true)
				.build();
		HttpClientBuilder clientBuilder = HttpClientBuilder.create();
		HttpResponse response = null;
		CloseableHttpClient client = clientBuilder.setDefaultRequestConfig(
				defaultRequestConfig).build();

		try {
			HttpGet httpGet = new HttpGet(url);
			response = client.execute(httpGet);
			int statusCode = response.getStatusLine().getStatusCode();
			if (Series.SUCCESSFUL == Series.valueOf(statusCode)) {
				String json = EntityUtils.toString(response.getEntity(),
						StandardCharsets.UTF_8);
				return JSON.parseObject(json);
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
