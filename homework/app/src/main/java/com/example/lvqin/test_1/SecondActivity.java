package com.example.lvqin.test_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView name=(TextView)findViewById(R.id.name_text);
        TextView sex=(TextView)findViewById(R.id.sex_text);
        TextView major=(TextView)findViewById(R.id.major_text);
        Intent intent=getIntent();
        name.setText("姓名："+intent.getStringExtra("extra_name"));
        sex.setText("性别："+intent.getStringExtra("extra_sex"));
        major.setText("专业："+intent.getStringExtra("extra_major"));
    }
}
