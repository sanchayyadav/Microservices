package com.microservices.company.services.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageConfiguration {

		/**
		 * This method use to creates a bean of {@link ReloadableResourceBundleMessageSource} and 
		 * to resolve text from error_messages.properties file, base on the selected locals.
		 * 
		 * @return {@code MessageSource} messageSource.
		 */
		@Bean
		public MessageSource messageSource() {
			ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
			reloadableResourceBundleMessageSource.setBasename("classpath:/error/error_messages");
			reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");
			
			return reloadableResourceBundleMessageSource;
		}
}
