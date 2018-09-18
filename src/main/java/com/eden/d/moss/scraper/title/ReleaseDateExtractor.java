package com.eden.d.moss.scraper.title;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReleaseDateExtractor extends AbstractNamedExtractor implements Extractor {

    private static final String RATING_START_STR = "<h4 class=\"inline\">Release Date:</h4>";
    private static final String RATING_END_STR = "<span";
    private static final String REGEX_STRING = Pattern.quote(RATING_START_STR) + "(.*?)" + Pattern.quote(RATING_END_STR);
    private static final Pattern PATTERN = Pattern.compile(REGEX_STRING);

    protected ReleaseDateExtractor(String name) {
        super(name);
    }

    @Override
    public boolean extract(String pageSource, Title title) {
        Matcher matcher = PATTERN.matcher(pageSource);

        if (matcher.find()) {
            try {
                Integer releaseDate = formatReleaseDate(matcher.group(1));
                title.setReleaseTimestamp(releaseDate);
                return true;
            } catch (Exception e) {
                throw new ExtractionException(e);
            }
        }

        return false;
    }

    private Integer formatReleaseDate(String releaseDateRawStr) throws ParseException {
        String releaseDateStr = releaseDateRawStr.replace("\"", "").replace("(USA)", "").trim();
        DateFormat strFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        Date date = strFormat.parse(releaseDateStr);

        DateFormat timestampFormat = new SimpleDateFormat("yyyyMMdd");

        return Integer.parseInt(timestampFormat.format(date));
    }
}
