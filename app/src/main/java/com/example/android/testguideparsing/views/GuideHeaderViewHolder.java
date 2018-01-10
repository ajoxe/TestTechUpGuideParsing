package com.example.android.testguideparsing.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.testguideparsing.R;

/**
 * Created by amirahoxendine on 1/9/18.
 */

public class GuideHeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView guideHeaderTitle;
    public TextView guideHeaderDescription;
    public GuideHeaderViewHolder(View itemView) {
        super(itemView);
        guideHeaderTitle = (TextView) itemView.findViewById(R.id.guide_header_title_textview);
        guideHeaderDescription = (TextView) itemView.findViewById(R.id.guide_header_description_textview);
    }
}
