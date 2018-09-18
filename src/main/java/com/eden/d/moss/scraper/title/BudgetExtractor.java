package com.eden.d.moss.scraper.title;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BudgetExtractor extends AbstractNamedExtractor implements Extractor {

    private static final String RATING_START_STR = "<h4 class=\"inline\">Budget:</h4>";
    private static final String RATING_END_STR = "<span";
    private static final String REGEX_STRING = Pattern.quote(RATING_START_STR) + "(.*?)" + Pattern.quote(RATING_END_STR);
    private static final Pattern PATTERN = Pattern.compile(REGEX_STRING);

    protected BudgetExtractor(String name) {
        super(name);
    }

    @Override
    public boolean extract(String pageSource, Title title) {
        Matcher matcher = PATTERN.matcher(pageSource);

        if (matcher.find()) {
            String budgetStr = matcher.group(1);
            try {
                title.setBudget(formatBudget(budgetStr));
                return true;
            } catch (NumberFormatException e) {
               throw new ExtractionException(e);
            }
        }

        return false;
    }

    private int formatBudget(String budgetRawStr) {
        return Integer.valueOf(budgetRawStr.replaceAll("[^\\d.]", ""));
    }
}
