package com.job.interview.football.api.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FootballRestTemplate {
	
	@Autowired
	RestTemplateResponseErrorHandler restTemplateErrorHanlder;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.errorHandler(restTemplateErrorHanlder).build();
	}

}
