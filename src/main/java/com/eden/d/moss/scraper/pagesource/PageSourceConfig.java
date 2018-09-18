package com.eden.d.moss.scraper.pagesource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageSourceConfig {
    @Bean
    public PageSourceService pageSourceService(PageSourceClient pageSourceClient) {
        return new PageSourceService(pageSourceClient);
    }

    @Bean
    public PageSourceClient pageSourceClient() {
        return new PageSourceClient();
    }
}
