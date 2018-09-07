package com.spider.bean;

public class Movie {


    /**
     * 显示的名称,如名称+评分等
     */
    private String title;

    /**
     * 名称
     */
    private String movieName;

    /**
     * 图片url
     */
    private String moviePicUrl;

    /**
     * 简介
     */
    private String description;

    /**
     * 评分
     */
    private String score;

    /**
     * 该影片指向的详情页地址
     */
    private String href;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviePicUrl() {
        return moviePicUrl;
    }

    public void setMoviePicUrl(String moviePicUrl) {
        this.moviePicUrl = moviePicUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", movieName='" + movieName + '\'' +
                ", moviePicUrl='" + moviePicUrl + '\'' +
                ", description='" + description + '\'' +
                ", score='" + score + '\'' +
                ", href='" + href + '\'' +
                '}' + '\n';
    }
}
