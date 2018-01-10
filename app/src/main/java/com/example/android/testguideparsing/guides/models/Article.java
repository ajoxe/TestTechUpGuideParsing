package com.example.android.testguideparsing.guides.models;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class Article {
    String article;
    String title;
    String overview;
    Subtitle[] subtitles;
    Example[] examples;

    public String getArticle() {
        return article;
    }

    public Subtitle[] getSubtitles() {
        return subtitles;
    }

    public Example[] getExamples() {
        return examples;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
