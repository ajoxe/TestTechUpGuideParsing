package com.example.android.testguideparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.testguideparsing.controllers.SubtitleAdapter;
import com.example.android.testguideparsing.controllers.SubtitleAdapterNoHeader;
import com.example.android.testguideparsing.data.GuideLibrarian;
import com.example.android.testguideparsing.guides.models.Article;
import com.example.android.testguideparsing.guides.models.Example;
import com.example.android.testguideparsing.guides.models.Subtitle;

import java.util.List;

public class ArticleDetailActivity extends AppCompatActivity {

    Intent intent;
    String guideKey;
    String articleKey;
    GuideLibrarian guideLibrarian;
    Article article;
    String articleTitle;
    String articleDescription;
    List<Subtitle> subtitleList;
    View.OnClickListener exampleToggleClickListener;
    RecyclerView subtitleRecyclerView;
    SubtitleAdapter subtitleAdapter;
    SubtitleAdapterNoHeader subtitleAdapterNoHeader;
    LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        intent = getIntent();
        setDataFields();
        setRecyclerView();
    }

    public void setDataFields(){
        guideLibrarian = new GuideLibrarian(getApplicationContext());
        guideKey = intent.getStringExtra("guideKey");
        articleKey = intent.getStringExtra("articleKey");
        article = guideLibrarian.getArticle(guideKey, articleKey);
        subtitleList = guideLibrarian.getSubtitleList(guideKey,articleKey);
        articleTitle = article.getTitle();
        exampleToggleClickListener = setExampleToggleClickListener();
        articleDescription = article.getTitle();
    }

    public void setRecyclerView(){
        subtitleRecyclerView = (RecyclerView) findViewById(R.id.subtitle_recycler_view);
        //subtitleAdapter = new SubtitleAdapter(subtitleList, articleTitle, articleDescription, exampleToggleClickListener);
        subtitleAdapterNoHeader = new SubtitleAdapterNoHeader(subtitleList,exampleToggleClickListener);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        //subtitleRecyclerView.setAdapter(subtitleAdapter);
        subtitleRecyclerView.setAdapter(subtitleAdapterNoHeader);
        subtitleRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public View.OnClickListener setExampleToggleClickListener(){
        exampleToggleClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View rootView = view.getRootView();
                Button exampleToggle = (Button) view.findViewById(R.id.example_toggle_button);
                LinearLayout exampleLayout = (LinearLayout) rootView.findViewById(R.id.example_linear_layout);
                String exampleKey = exampleToggle.getTag().toString();
                exampleLayout = (LinearLayout) rootView.findViewWithTag(exampleKey+ "ll");

                    toggleView(exampleToggle, exampleLayout);
                    Log.d("exampleToggle", exampleLayout.getTag().toString() + exampleToggle.getTag().toString());

                Example example = guideLibrarian.getExample(guideKey, articleKey, exampleKey);
                TextView exampleTitle = rootView.findViewById(R.id.example_title_textview);
                exampleTitle = rootView.findViewWithTag(exampleKey + "tt");
                TextView exampleCode = rootView.findViewById(R.id.example_code_textview);
                exampleCode = rootView.findViewWithTag(exampleKey + "cc");
                exampleTitle.setText(example.getTitle());
                exampleCode.setText(example.getCode());
            }
        };
        return exampleToggleClickListener;
    }

    public void toggleView (Button button, LinearLayout linearLayout){
        if(linearLayout.getVisibility() == View.GONE){
            linearLayout.setVisibility(View.VISIBLE);
            button.setText("Hide Example");
        } else{
            linearLayout.setVisibility(View.GONE);
            button.setText("Show Example");
        }
    }
}
