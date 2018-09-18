package com.eden.d.moss.scraper.wayback;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class WaybackConfig {
    @Bean
    public WaybackApiService waybackApiService(WaybackApiClient waybackApiClient) {
        return new WaybackApiService(waybackApiClient);
    }

    @Bean
    public WaybackApiClient waybackApiClient(RestTemplate waybackRestTemplate) {
        return new WaybackApiClient(waybackRestTemplate);
    }

    @Bean
    public RestTemplate waybackRestTemplate(MappingAnyJsonHttpMessageConverter httpMessageConverter) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Collections.singletonList(new MappingAnyJsonHttpMessageConverter()));
        return restTemplate;
    }

    @Bean
    public MappingAnyJsonHttpMessageConverter mappingAnyJsonHttpMessageConverter() {
        return new MappingAnyJsonHttpMessageConverter();
    }
}
