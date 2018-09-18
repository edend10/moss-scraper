package com.eden.d.moss.scraper.title;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenresExtractor extends AbstractNamedExtractor implements Extractor {

    private static final String RATING_START_STR = "<a href=\"/genre/";
    private static final String RATING_END_STR = "?ref";
    private static final String REGEX_STRING = Pattern.quote(RATING_START_STR) + "(.*?)" + Pattern.quote(RATING_END_STR);
    private static final Pattern PATTERN = Pattern.compile(REGEX_STRING);

    protected GenresExtractor(String name) {
        super(name);
    }

    @Override
    public boolean extract(String pageSource, Title title) {
        Matcher matcher = PATTERN.matcher(pageSource);
        Set<String> genres = new HashSet<>();
        while (matcher.find()) {
            String genre = matcher.group(1);
            if (!genre.equals("")) {
                genres.add(genre.toLowerCase());
            }
        }

        if (genres.size() > 0) {
            title.setGenres(genres);
            return true;
        }

        return false;
    }
}
