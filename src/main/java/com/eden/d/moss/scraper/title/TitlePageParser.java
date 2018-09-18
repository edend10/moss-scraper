package com.eden.d.moss.scraper.title;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class TitlePageParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(TitlePageParser.class);

    private List<Extractor> extractors;

    public TitlePageParser(List<Extractor> extractors) {
        this.extractors = extractors;
    }

    public Title parseFeaturesFromTitlePageSource(String pageSource, String imdbId) {
        Title title = new Title();

        title.setImdbId(imdbId);
        extractors.forEach(extractor -> {
            try {
                extractor.extract(pageSource, title);
            } catch (ExtractionException e) {
                LOGGER.warn("Error extracting with {} extractor for imdbId {}",
                        extractor.getName(), imdbId);
            }
        });

        return title;
    }
}
