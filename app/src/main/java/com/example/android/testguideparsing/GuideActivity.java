package com.example.android.testguideparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.testguideparsing.controllers.ArticleAdapter;
import com.example.android.testguideparsing.data.GuideLibrarian;
import com.example.android.testguideparsing.guides.models.Guide;
import com.example.android.testguideparsing.guides.models.Article;

import java.util.List;

public class GuideActivity extends AppCompatActivity {
    String guideKey;
    GuideLibrarian guideLibrarian;
    Guide guide;
    List<Article> articleList;

    RecyclerView stepsRecyclerView;
    ArticleAdapter articleAdapter;
    LinearLayoutManager linearLayoutManager;
    View.OnClickListener stepsDetailClickListener;
    View.OnClickListener stepsExamplesClickListener;
    String guideTitleHeader;
    String guideDescriptionHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        guideLibrarian = new GuideLibrarian(getApplicationContext());
        Intent intent = getIntent();
        guideKey = intent.getStringExtra("guideKey");
        guide = guideLibrarian.getGuide(guideKey);
        guideTitleHeader = guide.getTitle();
        guideDescriptionHeader = guide.getDescription();
        getSupportActionBar().setTitle(guideTitleHeader);

        setStepsRecyclerView();
    }

    public void setStepsRecyclerView(){
        stepsRecyclerView = (RecyclerView) findViewById(R.id.article_recycler_view);
        articleList = guideLibrarian.getArticleList(guideKey);
        stepsDetailClickListener = setStepsDetailClicklistener();
        stepsExamplesClickListener = setStepsExamplesClicklistener();
        articleAdapter = new ArticleAdapter(articleList, stepsDetailClickListener, stepsExamplesClickListener, guideTitleHeader,guideDescriptionHeader);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        stepsRecyclerView.setAdapter(articleAdapter);
        stepsRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public View.OnClickListener setStepsDetailClicklistener(){
        stepsDetailClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stepDetailIntent = new Intent(GuideActivity.this, ArticleDetailActivity.class);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.step_title_layout);
                String articleKey = (String) linearLayout.getTag();
                stepDetailIntent.putExtra("articleKey", articleKey);
                stepDetailIntent.putExtra("guideKey", guideKey);
                startActivity(stepDetailIntent);
            }
        };

        return stepsDetailClickListener;
    }

    public View.OnClickListener setStepsExamplesClicklistener(){
        stepsExamplesClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stepExamplesIntent = new Intent(GuideActivity.this, ArticleExampleDetailActivity.class);
                Button button = (Button) view.findViewById(R.id.step_examples_button);
                String buttonArticleKey = (String) button.getTag();
                stepExamplesIntent.putExtra("articleKey", buttonArticleKey);
                stepExamplesIntent.putExtra("guideKey", guideKey);
                startActivity(stepExamplesIntent);
            }
        };

        return stepsExamplesClickListener;
    }


}
