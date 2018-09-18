package com.eden.d.moss.scraper.title;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TitleConfig {

    @Bean
    public TitlePageParser titlePageParser(List<Extractor> extractors) {
        return new TitlePageParser(extractors);
    }

    @Bean
    public List<Extractor> extractors() {
        return Arrays.asList(
                new TitleNameExtractor("title name"),
                new ReleaseDateExtractor("release date"),
                new GenresExtractor("genres"),
                new BudgetExtractor("budget"),
                new RatersExtractor("raters")
        );
    }
}
