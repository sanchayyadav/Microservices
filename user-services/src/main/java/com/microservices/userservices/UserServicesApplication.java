package com.microservices.userservices;

import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserServicesApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	@Autowired
	private static RestTemplate restTemplate;
	public static void main(String[] args) {
		
		SpringApplication.run(UserServicesApplication.class, args);
//		HttpComponentsClientHttpRequestFactory h = new HttpComponentsClientHttpRequestFactory();
//		HttpClient httpClient;
//		HttpClient.setReuseStrategy(new NoConnectionReuseStrategy());
//		CloseableHttpClient httpClient = HttpClientBuilder
//                .create()
//                .setConnectionTimeToLive(1000, TimeUnit.MILLISECONDS)
//                .build();

//            try {
//				restTemplate.setRequestFactory(
//				    new HttpComponentsClientHttpRequestFactory(httpClient));
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		h.setConnectTimeout(1000000);
//		h.setReadTimeout(12);
//		h.setConnectionRequestTimeout(10);
	}

}
