package com.example.android.testguideparsing.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.testguideparsing.R;

/**
 * Created by amirahoxendine on 1/9/18.
 */

public class ArticleHeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView articleTitle;
    public TextView articleDescription;
    public ArticleHeaderViewHolder(View itemView) {
        super(itemView);
        articleTitle = (TextView) itemView.findViewById(R.id.article_header_title_textview);
        articleDescription = (TextView) itemView.findViewById(R.id.article_header_description_textview);
    }
}
