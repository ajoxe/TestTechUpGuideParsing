package com.example.android.testguideparsing.guides.models;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class Guide {
    String guide;
    String title;
    String description;
    Article[] articles;


    public String getGuide() {
        return guide;
    }

    public String getDescription() {
        return description;
    }

    public Article[] getArticles() {
        return articles;
    }

    public String getTitle() {
        return title;
    }
}
