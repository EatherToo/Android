package com.example.eather.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.first.MESSAGE";
    public EditText ediText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ediText = (EditText)findViewById(R.id.editText);
    }

    //button click
    public void sendMessage(View view){
        Intent intent = new Intent(this,DisplayMessageActivity.class);

        String message = ediText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

        ediText.setText(" ");
    }

}
