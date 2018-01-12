package com.example.android.testguideparsing.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Subtitle;
import com.example.android.testguideparsing.views.SubtitleViewHolder;

import java.util.List;

/**
 * Created by amirahoxendine on 1/11/18.
 */

public class SubtitleAdapterNoHeader extends RecyclerView.Adapter<SubtitleViewHolder> {
    List<Subtitle> subtitleList;
    View.OnClickListener exampleToggleClick;

    public SubtitleAdapterNoHeader(List<Subtitle> subtitleList, View.OnClickListener exampleToggleClick) {
        this.subtitleList = subtitleList;
        this.exampleToggleClick = exampleToggleClick;
    }

    @Override
    public SubtitleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subtitle_item_view, parent, false);
        return new SubtitleViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(SubtitleViewHolder holder, int position) {
        Subtitle subtitle = subtitleList.get(position);
        holder.onBind(subtitle);
        holder.exampleLinearLayout.setTag(subtitle.getExample() + "ll");
        holder.exampleTitle.setTag(subtitle.getExample() + "tt");
        holder.exampleCode.setTag(subtitle.getExample() + "cc");
        holder.exampleToggleButton.setOnClickListener(exampleToggleClick);

    }

    @Override
    public int getItemCount() {
        return subtitleList.size();
    }
}
