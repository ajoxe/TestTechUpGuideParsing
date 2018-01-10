package com.example.android.testguideparsing.data;

import android.content.Context;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Article;
import com.example.android.testguideparsing.guides.models.Example;
import com.example.android.testguideparsing.guides.models.Guide;
import com.example.android.testguideparsing.guides.models.Subtitle;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by amirahoxendine on 1/8/18.
 */

public class GuideLibrarian {
    private List<Guide> guideList;
    private HashMap<String, Guide> guideMap;
    private Guide guide;
    private List<Article> articleList;
    private HashMap<String, Article> articleMap;
    private Article article;
    private List<Subtitle> subtitleList;
    private HashMap<String, Subtitle> subtitleMap;
    private Subtitle subtitle;
    private List<Example> exampleList;
    private HashMap<String, Example> exampleMap;
    private Example example;


    public GuideLibrarian(Context context){
        buildGuideList(context);
        buildGuideMap();
    }

    public void buildGuideList(Context context){
        Type collectiontype = new TypeToken<Collection<Guide>>() {
        }.getType();
        Gson gs = new Gson();
        Collection<Guide> guides = null;
        InputStream is = context.getApplicationContext().getResources().openRawResource(R.raw.guideexampleupdate);
        InputStreamReader isr = new InputStreamReader(is);
        guides = gs.fromJson(isr, collectiontype);
        guideList = new ArrayList<>();
        guideList.addAll(guides);

    }

    public void buildGuideMap(){
        guideMap = new HashMap<>();
        for (Guide guide: guideList){
            guideMap.put(guide.getGuide(), guide);
        }
    }

    public List<Guide> getGuideList(){
        return guideList;
    }

    public HashMap<String, Guide> getGuideMap() {
        return guideMap;
    }

    public Guide getGuide(String guideKey){
        guide = guideMap.get(guideKey);
        return guide;
    }

    public List<Article> getArticleList(String guideKey) {
        articleList = new ArrayList<>();
        guide = getGuide(guideKey);
       /* for (article article: guide.getArticles()) {
            articleList.add(article);
        }*/
        Collections.addAll(articleList, guide.getArticles());
        return articleList;
    }

    public HashMap<String, Article> getArticleMap(String guideKey) {
        articleMap = new HashMap<>();
        articleList = getArticleList(guideKey);
        for (Article article : articleList){
            articleMap.put(article.getArticle(), article);
        }
        return articleMap;
    }

    public Article getArticle(String guideKey, String articleKey) {
        articleMap = getArticleMap(guideKey);
        article = articleMap.get(articleKey);
        return article;
    }

    public List<Subtitle> getSubtitleList(String guideKey, String articleKey) {
        subtitleList = new ArrayList<>();
        article = getArticle(guideKey, articleKey);
        Collections.addAll(subtitleList, article.getSubtitles());
        return subtitleList;
    }

    public HashMap<String, Subtitle> getSubtitleMap(String guideKey, String articleKey) {
        subtitleMap = new HashMap<>();
        subtitleList = getSubtitleList(guideKey,articleKey);
        for (Subtitle subtitle: subtitleList){
            subtitleMap.put(subtitle.getSubtitle(), subtitle);
        }
        return subtitleMap;
    }

    public Subtitle getSubtitle(String guideKey, String articleKey, String subtitleKey) {
        subtitleMap = getSubtitleMap(guideKey, articleKey);
        subtitle = subtitleMap.get(subtitleKey);
        return subtitle;
    }

    public List<Example> getExampleList(String guideKey, String articleKey) {
        exampleList = new ArrayList<>();
        article = getArticle(guideKey, articleKey);
        Collections.addAll(exampleList, article.getExamples());
        return exampleList;
    }

    public HashMap<String, Example> getExampleMap(String guideKey, String articleKey) {
        exampleMap = new HashMap<>();
        exampleList = getExampleList(guideKey, articleKey);
        for (Example example: exampleList){
            exampleMap.put(example.getExample(), example);
        }
        return exampleMap;
    }

    public Example getExample(String guideKey, String articleKey, String exampleKey) {
        exampleMap = getExampleMap(guideKey, articleKey);
        example = exampleMap.get(exampleKey);
        return example;
    }


}
