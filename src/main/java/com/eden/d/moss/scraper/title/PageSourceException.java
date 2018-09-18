package com.eden.d.moss.scraper.title;

import com.eden.d.moss.scraper.pagesource.PageSourceClient;

public class PageSourceException extends RuntimeException {
    public PageSourceException(Throwable t) {
        super(t);
    }
}
