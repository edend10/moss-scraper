package com.eden.d.moss.scraper.listener;

import com.eden.d.moss.scraper.Util;
import com.eden.d.moss.scraper.pagesource.PageSourceService;
import com.eden.d.moss.scraper.title.PageSourceException;
import com.eden.d.moss.scraper.title.Title;
import com.eden.d.moss.scraper.title.TitlePageParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KafkaImdbIdConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaImdbIdConsumer.class);

    private final PageSourceService pageSourceService;
    private final TitlePageParser titlePageParser;

    // todo: temp until we persist each title
    private static final Map<String, Title> TITLES = new ConcurrentHashMap<>();

    public KafkaImdbIdConsumer(PageSourceService pageSourceService,
                               TitlePageParser titlePageParser) {
        this.pageSourceService = pageSourceService;
        this.titlePageParser = titlePageParser;
    }

    @KafkaListener(topics = "test", groupId = "1")
    public void listen(String imdbId) {
        if (!imdbId.isEmpty() && Util.isNumeric(imdbId)) {
            try {
                String pageSource = pageSourceService.getTitlePageSource(imdbId);
                if (!pageSource.isEmpty()) {
                    Title title = titlePageParser.parseFeaturesFromTitlePageSource(pageSource, imdbId);
                    TITLES.put(imdbId, title);
                    LOGGER.info("Persisting title for imdbId {}", imdbId);
                } else {
                    LOGGER.warn("Page source empty for imdbId {}", imdbId);
                }
            } catch (PageSourceException e) {
                LOGGER.warn("problem getting page source for imdbId {}", imdbId, e);
            }
        }
    }
}
