package com.eden.d.moss.scraper.title;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RatersExtractor extends AbstractNamedExtractor implements Extractor {

    private static final String RATING_START_STR = "<span class=\"small\">";
    private static final String RATING_END_STR = "</span>";
    private static final String REGEX_STRING = Pattern.quote(RATING_START_STR) + "(.*?)" + Pattern.quote(RATING_END_STR);
    private static final Pattern PATTERN = Pattern.compile(REGEX_STRING);

    protected RatersExtractor(String name) {
        super(name);
    }

    @Override
    public boolean extract(String pageSource, Title title) {
        Matcher matcher = PATTERN.matcher(pageSource);

        if (matcher.find()) {
            String ratersRaw = matcher.group(1).replaceAll("[^\\d.]", "").replace(" ", "").replace(",", "");
            if (!ratersRaw.equals("")) {
                try {
                    Integer raters = Integer.parseInt(ratersRaw);
                    title.setRaters(raters);
                    return true;
                } catch (NumberFormatException e) {
                    throw new ExtractionException(e);
                }
            }
        }

        return false;
    }
}
