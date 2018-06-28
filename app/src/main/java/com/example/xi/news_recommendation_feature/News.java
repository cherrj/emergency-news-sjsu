package com.example.xi.news_recommendation_feature;

import java.net.URL;

public class News {
    private String title, summary;
    private URL url;

    public News(String title, String summary, URL url){
        this.title=title;
        this.summary=summary;
        this.url=url;
    }

    public String getTitle(){
        return title;
    }

    public String getSummary(){
        return summary;
    }

    public URL getUrl() {
        return url;
    }
}
