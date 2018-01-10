package com.example.android.testguideparsing.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.testguideparsing.R;
import com.example.android.testguideparsing.guides.models.Article;

/**
 * Created by amirahoxendine on 12/30/17.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    public TextView stepTitle;
    public TextView stepBrief;
    public TextView articleNumber;
    public LinearLayout stepTitleLinearLayout;
    public Button examples;

    public ArticleViewHolder(View itemView) {
        super(itemView);
        stepTitle = (TextView) itemView.findViewById(R.id.step_title_textview);
        stepBrief = (TextView) itemView.findViewById(R.id.step_brief_textview);
        articleNumber = (TextView) itemView.findViewById(R.id.article_number_textview);
        stepTitleLinearLayout = (LinearLayout) itemView.findViewById(R.id.step_title_layout);
        examples = (Button) itemView.findViewById(R.id.step_examples_button);
    }

    public void onBind(Article article){
        stepTitle.setText(article.getTitle());
        stepBrief.setText(article.getOverview());
        stepTitleLinearLayout.setTag(article.getArticle());
        examples.setTag(article.getArticle());
    }
}
