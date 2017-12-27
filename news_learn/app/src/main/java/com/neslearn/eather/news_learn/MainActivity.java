package com.neslearn.eather.news_learn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void jump(View view)
    {
//        Intent intent = new Intent(this,MemoList.class);
        Intent intent = new Intent(this,news_view.class);
        startActivity(intent);

    }
}
