package com.neslearn.eather.news_learn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.squareup.okhttp.*;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class news_view extends AppCompatActivity {

    private OkHttpClient okHttpClient = new OkHttpClient();//新建okhttp对象
    private Gson gson = new Gson();//新建gson对象来处理json数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);
        final ListView news_list = (ListView)this.findViewById(R.id.list_item);
        ListAdapter listAdapter = null;
        try {
            listAdapter = new SimpleAdapter(this,this.getMapList(), R.layout.news_conten,
                    new String[]{"title","article","photo"},new int[]{R.id.title,R.id.content,R.id.news_image});
        } catch (Exception e) {
            e.printStackTrace();
        }
        news_list.setAdapter(listAdapter);
        news_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String,String> map=(HashMap<String,String>)news_list.getItemAtPosition(i);
                Bundle bundle = new Bundle();
                bundle.putString("title",map.get("title"));
                bundle.putString("article",map.get("article"));
                //bundle.put("photo",map.get("photo"));
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(news_view.this,Detiail.class);
                startActivity(intent);

            }
        });

    }
    protected ArrayList<Map<String, Object>> getMapList() throws Exception {
        ArrayList<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();//listview的资源链表
        ArrayList<News> news_list = run();
        for(News item:news_list)
        {
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("title",item.getTitle());
            map.put("article",item.getArticle());
            Bitmap bitmap = getBitmap(item.getPhoto());
            map.put("photo",R.drawable.pic);
            listmap.add(map);
        }

        return listmap;
    }
    public ArrayList<News> run() throws Exception
    {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        Request request = new Request.Builder().url("http://eather.s1.natapp.cc/news.json").build();
        Response response = okHttpClient.newCall(request).execute();
        if(!response.isSuccessful())
        {
            throw new IOException("请求错误，错误码："+response.code());

        }
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(response.body().string()).getAsJsonArray();
        ArrayList<News> news_list = new ArrayList<News>();
        for(JsonElement item:jsonArray)
        {
            News news = gson.fromJson(item,News.class);
            news_list.add(news);
            Log.d("news:",news.getTitle());
        }

        return news_list;
    }
    public Bitmap getBitmap(String url) throws IOException {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
        Request request = new Request.Builder().url("http://eather.s1.natapp.cc/news.png").build();
        Response response = okHttpClient.newCall(request).execute();
        InputStream in = response.body().byteStream();
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        return bitmap;
    }

}
