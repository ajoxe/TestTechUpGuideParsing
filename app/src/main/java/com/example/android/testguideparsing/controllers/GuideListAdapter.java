package com.example.android.testguideparsing.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Guide;
import com.example.android.testguideparsing.views.GuideListViewHolder;

import java.util.List;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class GuideListAdapter extends RecyclerView.Adapter<GuideListViewHolder>{
    List<Guide> guidesList;
    View.OnClickListener guidesListClickListener;

    public GuideListAdapter(List<Guide> guidesList, View.OnClickListener guidesListClickListener) {
        this.guidesList = guidesList;
        this.guidesListClickListener = guidesListClickListener;
    }

    @Override
    public GuideListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.guides_list_item_view, parent, false);
        return new GuideListViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(GuideListViewHolder holder, int position) {
        Guide guide = guidesList.get(position);
        holder.onBind(guide);
        holder.guideTitle.setTag(guide.getGuide());
        holder.itemView.setOnClickListener(guidesListClickListener);

    }

    @Override
    public int getItemCount() {
        return guidesList.size();
    }
}
