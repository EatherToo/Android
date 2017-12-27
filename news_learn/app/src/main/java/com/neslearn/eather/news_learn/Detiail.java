package com.neslearn.eather.news_learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detiail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detiail);
        Bundle bundle=getIntent().getExtras();
        String title  = bundle.getString("title");
        String article = bundle.getString("article");

        TextView title_view = (TextView)findViewById(R.id.title);
        TextView article_view = (TextView)findViewById(R.id.article);

        title_view.setText(title);
        article_view.setText(article);
    }
}
