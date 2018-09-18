package com.eden.d.moss.scraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:moss-scraper.properties")
public class MossScraper {
    public static void main(String[] args) {
        SpringApplication.run(MossScraper.class, args);
    }
}
