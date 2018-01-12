package com.example.android.testguideparsing.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Example;
import com.example.android.testguideparsing.guides.models.Subtitle;
import com.example.android.testguideparsing.views.ArticleHeaderViewHolder;
import com.example.android.testguideparsing.views.SubtitleViewHolder;

import java.util.List;

/**
 * Created by amirahoxendine on 1/9/18.
 */

public class SubtitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Subtitle> subtitleList;
    String articleTitleHeader;
    String articleDescriptionHeader;
    View.OnClickListener exampleToggleClick;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    public SubtitleAdapter(List<Subtitle> subtitleList, String articleTitleHeader, String articleDescriptionHeader, View.OnClickListener exampleToggleClick) {
        this.subtitleList = subtitleList;
        this.articleTitleHeader = articleTitleHeader;
        this.articleDescriptionHeader = articleDescriptionHeader;
        this.exampleToggleClick = exampleToggleClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View childView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.article_header_itemview, parent, false);
            return new ArticleHeaderViewHolder(childView);
        } else if(viewType == TYPE_ITEM) {
            View childView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.subtitle_item_view, parent, false);
            return new SubtitleViewHolder(childView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ArticleHeaderViewHolder){
            ArticleHeaderViewHolder articleHeaderViewHolder = (ArticleHeaderViewHolder) holder;
            ((ArticleHeaderViewHolder) holder).articleTitle.setText(articleTitleHeader);
            ((ArticleHeaderViewHolder) holder).articleDescription.setText(articleDescriptionHeader);
        } else if(holder instanceof SubtitleViewHolder){
            SubtitleViewHolder subtitleViewHolder = (SubtitleViewHolder) holder;
            Subtitle subtitle = subtitleList.get(position -1);
            ((SubtitleViewHolder) holder).exampleLinearLayout.setTag(subtitle.getExample());
            ((SubtitleViewHolder) holder).exampleToggleButton.setOnClickListener(exampleToggleClick);
            ((SubtitleViewHolder) holder).onBind(subtitle);
            holder.setIsRecyclable(false);
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
        return subtitleList.size() + 1;
    }
}
