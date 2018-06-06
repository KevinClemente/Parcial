package com.example.elsalvador.parcial.Object;

public class News {
    private String imageOfNews;
    private String titleOfNews;
    private String subtitleOfNews;
    private boolean favoriteNews;
    private int newsID;

    public News(String imageOfNews, String titleOfNews, String subtitleOfNews, boolean favoriteNews, int newsID) {
        this.imageOfNews = imageOfNews;
        this.titleOfNews = titleOfNews;
        this.subtitleOfNews = subtitleOfNews;
        this.favoriteNews = favoriteNews;
        this.newsID = newsID;
    }

    public String getImageOfNews() {
        return imageOfNews;
    }

    public void setImageOfNews(String imageOfNews) {
        this.imageOfNews = imageOfNews;
    }

    public String getTitleOfNews() {
        return titleOfNews;
    }

    public void setTitleOfNews(String titleOfNews) {
        this.titleOfNews = titleOfNews;
    }

    public String getSubtitleOfNews() {
        return subtitleOfNews;
    }

    public void setSubtitleOfNews(String subtitleOfNews) {
        this.subtitleOfNews = subtitleOfNews;
    }

    public boolean isFavoriteNews() {
        return favoriteNews;
    }

    public void setFavoriteNews(boolean favoriteNews) {
        this.favoriteNews = favoriteNews;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }
}
