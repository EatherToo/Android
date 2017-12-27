package com.memobook.eather.memorybook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jump(View view)
    {
//        Intent intent = new Intent(this,MemoList.class);
        Intent intent = new Intent(this,Memo_view.class);
        startActivity(intent);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
            return true;

        }
        return super.onKeyDown(keyCode,event);
    }


}
