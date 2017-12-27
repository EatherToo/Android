package com.memobook.eather.memorybook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import android.content.Context;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class Edit extends AppCompatActivity {
    //private dbop dbHelper;
    //private SQLiteDatabase db;
    dbop dbHelper = new dbop(Edit.this);

    boolean flag = true;//判断是从listview跳转过来的还是从fab跳转过来的，前者置为1，后者置为0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Log.d("dbop","successful created");
        //db = dbHelper.getWritableDatabase();
        Bundle bundle=getIntent().getExtras();

        if(bundle.getString("title").equals("null"))
        {
            flag = true;
        }else
        {
            flag = false;
        }

        if(flag)
        {
           EditText editText = findViewById(R.id.title);
            editText.setText("请输入标题");
            EditText editText1 = findViewById(R.id.edit);
            editText1.setText("请输入正文");
        }
        else
        {
            String title = bundle.getString("title");
            String text = bundle.getString("text");
            EditText editText = findViewById(R.id.title);
            editText.setText(title);
            EditText editText1 = findViewById(R.id.edit);
            editText1.setText(text);
        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(getApplicationContext(), "按下返回键！", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,Memo_view.class);
            startActivity(intent);

            Edit.this.finish();
        }
        return true;
    }

    public void onClickOk(View view) {

        if(!flag)
        {
            EditText editText = (EditText) findViewById(R.id.title);
            String title = editText.getText().toString();
            EditText editText1 = (EditText) findViewById(R.id.edit);
            String text = editText1.getText().toString();

            Bundle bundle=getIntent().getExtras();
            String id = bundle.getString("id");

            dbHelper.updateinfo(title,text,id);

            Toast.makeText(getApplicationContext(),"备忘录更改成功！",Toast.LENGTH_SHORT).show();
        }
        else
        {
            EditText editText = (EditText) findViewById(R.id.title);
            String title = editText.getText().toString();
            EditText editText1 = (EditText) findViewById(R.id.edit);
            String text = editText1.getText().toString();
            Log.d("edit","clickok is starting");
            dbHelper.insertinfo(title,text);

            Toast.makeText(getApplicationContext(),"备忘录添加成功！",Toast.LENGTH_SHORT).show();
            //dbHelper.insertinfo(db,title,text);
        }


    }

}
