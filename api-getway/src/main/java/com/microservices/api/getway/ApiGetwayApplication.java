package com.microservices.api.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableWebFlux
public class ApiGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGetwayApplication.class, args);
	}
//	@Bean
//	public HttpClient httpClient() {
//	    return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
//	}

}
