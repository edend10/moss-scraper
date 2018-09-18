package com.eden.d.moss.scraper.title;

public abstract class AbstractNamedExtractor {
    private final String name;

    protected AbstractNamedExtractor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
