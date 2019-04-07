package com.target.metrotransit.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestClientConfig {
	
	public static final String JSON_FORMAT = "?format=json";
	public static final String SLASH = "/";
	public static final String OPEN_BRACE = "{";
	public static final String CLOSE_BRACE = "}";
	
	@Value("${api.metro.transit.base.url}")
	private String apiRestBase;
	
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiRestBase));
		return restTemplate;
	}

}
