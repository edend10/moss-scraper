package com.eden.d.moss.scraper.pagesource;

import com.eden.d.moss.scraper.title.PageSourceException;

public class PageSourceService {
    private static final String TITLE_PAGE_URL_FORMAT = "https://www.imdb.com/title/tt%s";
    private static final String WAYBACK_URL_FORMAT = "";

    private PageSourceClient client;

    public PageSourceService(PageSourceClient client) {
        this.client = client;
    }

    public String getTitlePageSource(String imdbId) throws PageSourceException {
        return client.getWebPageSource(String.format(TITLE_PAGE_URL_FORMAT, imdbId));
    }

    public String getTitlePageSourceFromWayback(int imdbId, int timestamp) {
        String titleUrl = String.format(TITLE_PAGE_URL_FORMAT, imdbId);
        return client.getWebPageSource(String.format(WAYBACK_URL_FORMAT, timestamp, titleUrl));
    }
}
