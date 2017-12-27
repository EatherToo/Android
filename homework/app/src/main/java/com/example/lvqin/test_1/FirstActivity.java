package com.example.lvqin.test_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        final EditText name=(EditText)findViewById(R.id.name_edit);
        final EditText id=(EditText)findViewById(R.id.sex_edit);
        final EditText birthday=(EditText)findViewById(R.id.major_edit);
        Button button=(Button)findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_name",name.getText().toString());
                intent.putExtra("extra_sex",id.getText().toString());
                intent.putExtra("extra_major",birthday.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        EditText name=(EditText)findViewById(R.id.name_edit);
        EditText id=(EditText)findViewById(R.id.sex_edit);
        EditText birthday=(EditText)findViewById(R.id.major_edit);
        name.setText("");
        id.setText("");
        birthday.setText("");
    }
}
