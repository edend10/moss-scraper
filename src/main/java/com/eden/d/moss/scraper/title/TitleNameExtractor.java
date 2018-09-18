package com.eden.d.moss.scraper.title;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleNameExtractor extends AbstractNamedExtractor implements Extractor {

    private static final String RATING_START_STR = "<title>";
    private static final String RATING_END_STR = "</title>";
    private static final String REGEX_STRING = Pattern.quote(RATING_START_STR) + "(.*?)" + Pattern.quote(RATING_END_STR);
    private static final Pattern PATTERN = Pattern.compile(REGEX_STRING);

    protected TitleNameExtractor(String name) {
        super(name);
    }

    @Override
    public boolean extract(String pageSource, Title title) {
        Matcher matcher = PATTERN.matcher(pageSource);

        if (matcher.find()) {
            String name = formatTitle(matcher.group(1));
            title.setName(name);
            return true;
        }

        return false;
    }

    private String formatTitle(String rawTitle) {
        return rawTitle.toLowerCase().replace(" - imdb", "").replaceAll("(\\()[^&]*(\\))", "").trim();
    }
}
