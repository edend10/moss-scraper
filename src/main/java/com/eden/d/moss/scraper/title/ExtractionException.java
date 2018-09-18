package com.eden.d.moss.scraper.title;

public class ExtractionException extends RuntimeException {
    public ExtractionException(Throwable t) {
        super(t);
    }

    public ExtractionException(String message) {
        super(message);
    }

    public ExtractionException(String message, Throwable t) {
        super(message, t);
    }
}
