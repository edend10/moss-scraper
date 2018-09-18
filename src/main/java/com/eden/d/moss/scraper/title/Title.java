package com.eden.d.moss.scraper.title;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Title {

    private String imdbId;
    private String name;
    private Integer releaseTimestamp;
    private Set<String> genres;
    private Integer budget;
    private List<RatingSnapshot> ratingSnapshots;
    private Integer raters;

    public Title() {
        this.ratingSnapshots = new ArrayList<>();
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseTimestamp() {
        return releaseTimestamp;
    }

    public void setReleaseTimestamp(Integer releaseTimestamp) {
        this.releaseTimestamp = releaseTimestamp;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getRaters() {
        return raters;
    }

    public void setRaters(Integer raters) {
        this.raters = raters;
    }

    public List<RatingSnapshot> getRatingSnapshots() {
        return ratingSnapshots;
    }

    public void addRatingSnapshot(RatingSnapshot ratingSnapshots) {
        this.ratingSnapshots.add(ratingSnapshots);
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }
}
