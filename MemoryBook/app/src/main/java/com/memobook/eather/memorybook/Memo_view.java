package com.memobook.eather.memorybook;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Memo_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Bundle bundle = new Bundle();
                bundle.putString("title","null");
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(Memo_view.this,Edit.class);
                startActivity(intent);
            }
        });

        final ListView listView1 = (ListView)this.findViewById(R.id.list_item);

        ListAdapter simpleAdapter = new SimpleAdapter(this,this.getMap(),R.layout.text,
                new String[]{"id","text","subtext"},new int[]{R.id.id,R.id.text,R.id.subtext});
        listView1.setAdapter(simpleAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    HashMap<String,String> map=(HashMap<String,String>)listView1.getItemAtPosition(i);
//                    String title=map.get("text");
//                    String content=map.get("subtext");
//                    String id = map.get("id");
//                    Toast.makeText(getApplicationContext(),
//                            "你选择了第"+i+"个Item，text的值是："+title+"subtext的值是:"+content+id+"id值是:"+id,
//                            Toast.LENGTH_SHORT).show();
                    Bundle bundle = new Bundle();
                    bundle.putString("id",map.get("id"));
                    bundle.putString("title",map.get("text"));
                    bundle.putString("text",map.get("subtext"));
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(Memo_view.this,Edit.class);
                    startActivity(intent);

                }
            });
    }
    protected ArrayList<Map<String, Object>> getMap()
    {
        dbop dbHelper = new dbop(this);
        ArrayList<Map<String, Object>> listmap = dbHelper.queryall();
        return listmap;
    }


    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Toast.makeText(getApplicationContext(), "按下返回键！", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

            Memo_view.this.finish();
        }
        return true;
    }
}
