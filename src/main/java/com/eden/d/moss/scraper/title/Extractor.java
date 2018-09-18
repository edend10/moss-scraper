package com.eden.d.moss.scraper.title;

public interface Extractor {
    boolean extract(String pageSource, Title title) throws ExtractionException;
    String getName();
}
