package com.example.android.testguideparsing.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Guide;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class GuideListViewHolder extends RecyclerView.ViewHolder {
    public TextView guideTitle;
    TextView guideDescription;
    public GuideListViewHolder(View itemView) {
        super(itemView);
        guideTitle = (TextView) itemView.findViewById(R.id.guide_title_textview);
        guideDescription = (TextView) itemView.findViewById(R.id.guide_description_textview);
    }
    public void onBind(Guide guide){
        guideTitle.setText(guide.getGuide());
        guideDescription.setText(guide.getDescription());
    }
}
