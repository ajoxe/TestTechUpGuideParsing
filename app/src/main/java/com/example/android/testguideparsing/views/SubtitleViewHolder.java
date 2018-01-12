package com.example.android.testguideparsing.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Example;
import com.example.android.testguideparsing.guides.models.Subtitle;

/**
 * Created by amirahoxendine on 1/9/18.
 */

public class SubtitleViewHolder extends RecyclerView.ViewHolder{
    public TextView subtitleTitle;
    public TextView subtitleText;
    public Button exampleToggleButton;
    public LinearLayout exampleLinearLayout;
    public TextView exampleTitle;
    public TextView exampleCode;

    public SubtitleViewHolder(View itemView) {
        super(itemView);
        subtitleTitle = (TextView) itemView.findViewById(R.id.subtitle_title_textview);
        subtitleText = (TextView) itemView.findViewById(R.id.subtitle_text_textview);
        exampleToggleButton = (Button) itemView.findViewById(R.id.example_toggle_button);
        exampleLinearLayout = (LinearLayout) itemView.findViewById(R.id.example_linear_layout);
        exampleTitle = (TextView) itemView.findViewById(R.id.example_title_textview);
        exampleCode = (TextView) itemView.findViewById(R.id.example_code_textview);

    }

    public void onBind(Subtitle subtitle){
        subtitleTitle.setText(subtitle.getTitle());
        subtitleText.setText(subtitle.getText());
        exampleToggleButton.setTag(subtitle.getExample());
    }



}
