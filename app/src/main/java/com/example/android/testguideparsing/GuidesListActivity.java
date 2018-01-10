package com.example.android.testguideparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.testguideparsing.controllers.GuideListAdapter;
import com.example.android.testguideparsing.data.GuideLibrarian;
import com.example.android.testguideparsing.guides.models.Example;
import com.example.android.testguideparsing.guides.models.Guide;
import com.example.android.testguideparsing.guides.models.Article;

import java.util.HashMap;
import java.util.List;

public class GuidesListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GuideListAdapter guideListAdapter;
    LinearLayoutManager linearLayoutManager;
    GuideLibrarian guideLibrarian;
    List<Guide> guidesList;
    View.OnClickListener guidesListClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guides_list);
        getSupportActionBar().setTitle("Android Development Guides");
        guideLibrarian = new GuideLibrarian(getApplicationContext());
        instantiateFields();
        setRecyclerView();
        testGuideLibrarian();
        //loadData();
    }

    public void testGuideLibrarian(){

        List<Guide> guideTestList = guideLibrarian.getGuideList();
        Log.d("librarian guideList: ", String.valueOf(guideTestList.size()));
        HashMap<String, Guide> guideTestMap = guideLibrarian.getGuideMap();
        Log.d("librarian guideMap: ", String.valueOf(guideTestMap.size()));

        String guideTestKey =  guideTestList.get(0).getGuide();
        Guide testGuide = guideLibrarian.getGuide(guideTestKey);
        Log.d("librarian getGuide: ", testGuide.getGuide());

        List<Article> testArticleList = guideLibrarian.getArticleList(guideTestKey);
        Log.d("librarian articleList: ", String.valueOf(testArticleList.size()));
        String stepTestKey = testArticleList.get(0).getArticle();
        Article testArticle = guideLibrarian.getArticle(guideTestKey, stepTestKey);
        Log.d("librarian getArticle: ", testArticle.getArticle());

        List<Example> exampleTestList = guideLibrarian.getExampleList(guideTestKey, stepTestKey);
        Log.d("librarian exampleList: ", String.valueOf(exampleTestList.size()));
        String textExampleKey = exampleTestList.get(0).getExample();
        Example testExample = guideLibrarian.getExample(guideTestKey, stepTestKey, textExampleKey);
        Log.d("librarian getExample: ", testExample.getExample());

    }

    public void instantiateFields(){
        recyclerView = (RecyclerView) findViewById(R.id.guide_recycler_view);
        guidesList = guideLibrarian.getGuideList();
        guidesListClickListener = setClickListener();
        guideListAdapter = new GuideListAdapter(guidesList,guidesListClickListener);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

    }

    public void setRecyclerView(){
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(guideListAdapter);
    }

    public View.OnClickListener setClickListener(){
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent guideIntent = new Intent(GuidesListActivity.this, GuideActivity.class);
                TextView guideName = (TextView) view.findViewById(R.id.guide_title_textview);
                String name = (String) guideName.getTag();
                guideIntent.putExtra("guideKey", name);
                Log.d("intent", name);
                startActivity(guideIntent);
            }
        };

        return clickListener;
    }
}
