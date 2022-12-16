package com.microservices.userservices.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalBeanConfigurations {

	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(final RestTemplateBuilder  builder) {
//		  return builder
//	                .requestFactory(new ClientHttpRequestFactorySupplier())
//	                .setConnectTimeout(Duration.ofMinutes(15))
//	                .setReadTimeout(Duration.ofMinutes(15))
//	                .build();
//	}
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//	    return new RestTemplate();
//	}
	
//	 @Bean
//	  @LoadBalanced
//	  public RestTemplate restTemplate(RestTemplateBuilder builder) {
//	    return builder.build();
//	  }
//
//	private ClientHttpRequestFactory clientHttpRequestFactory() {
//	    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//	    factory.setReadTimeout(60000);
//	    factory.setConnectTimeout(60000);
//	    return factory;
//	   }
	@Bean
	@LoadBalanced
	public RestTemplateBuilder restTemplateBuilder() {
		return new RestTemplateBuilder();
	}

}
