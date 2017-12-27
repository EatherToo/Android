package com.neslearn.eather.news_learn;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Eather on 2017/12/12.
 */

public class News {

    /**
     * title : 交通部官员回应春运热点：火车票不能乱涨价
     * article : 中新网北京12月30日电 春运“一票难求”解决了吗？普速列车是否减少了？火车票会涨价吗？国新办29日就《中国交通运输发展》白皮书等情况举行发布会，交通部官员在发布会上对上述春运热点话题进行了回应：今年春运要比往年组织得更好；普速列车的开行没有减少，反而是增加的；要让群众有更多的获得感，所以不能乱涨价。
     * photo : http://192.168.144.241/api/news.png
     */

    private String title;
    private String article;
    private String photo;

    public static News objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), News.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String toString()
    {
        return "News{" +
                "title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", photo=" + photo +
                '}';

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
