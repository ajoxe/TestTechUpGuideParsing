package com.example.android.testguideparsing.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Article;
import com.example.android.testguideparsing.views.ArticleViewHolder;
import com.example.android.testguideparsing.views.GuideHeaderViewHolder;

import java.util.List;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Article> articleList;
    View.OnClickListener stepDetailClickListener;
    View.OnClickListener stepExamplesClickListener;
    String headerTitle;
    String headerDescription;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public ArticleAdapter(List<Article> articleList, View.OnClickListener stepDetailClickListener, View.OnClickListener stepExamplesClickListener, String headerTitle, String headerDescription) {
        this.articleList = articleList;
        this.stepDetailClickListener = stepDetailClickListener;
        this.stepExamplesClickListener = stepExamplesClickListener;
        this.headerTitle = headerTitle;
        this.headerDescription = headerDescription;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View childView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.guide_header_item_view, parent, false);
            return new GuideHeaderViewHolder(childView);
        } else if(viewType == TYPE_ITEM) {
            View childView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_item_view, parent, false);
            return new ArticleViewHolder(childView);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GuideHeaderViewHolder){
            GuideHeaderViewHolder guideHeaderViewHolder = (GuideHeaderViewHolder) holder;
            ((GuideHeaderViewHolder) holder).guideHeaderTitle.setText(headerTitle);
            ((GuideHeaderViewHolder) holder).guideHeaderDescription.setText(headerDescription);
        } else if(holder instanceof ArticleViewHolder){
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
            Article article = articleList.get(position -1);
            ((ArticleViewHolder) holder).onBind(article);
            ((ArticleViewHolder) holder).articleNumber.setText(String.valueOf(position));
            ((ArticleViewHolder) holder).stepTitleLinearLayout.setOnClickListener(stepDetailClickListener);
            ((ArticleViewHolder) holder).examples.setOnClickListener(stepExamplesClickListener);
        }
    }


    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    @Override
    public int getItemCount() {
        return articleList.size() + 1;
    }

}
