package com.spider.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/9/7.
 */
public class MovieDetail {

    /**
     * 电影名称
     */
    private String movieName;

    /**
     * 主演
     */
    private String actor;

    /**
     * 更新时间
     */
    private String updateDate;

    /**
     * 类型,eg.欧美剧
     */
    private String type;


    /**
     * 状态 高清,完结等
     */
    private String status;

    /**
     * 导演
     */
    private String director;

    /**
     * 区域 eg.港台,大陆
     */
    private String area;

    /**
     * 年份
     */
    private String year;

    /**
     * 语言
     */
    private String language;

    /**
     * 描述
     */
    private String desc;

    /**
     * 影片图片地址
     */
    private String picUrl;

    /**
     * 播放列表
     */
    private List<PlayInfo> playInfoList = new ArrayList<PlayInfo>();

    /**
     * 猜你喜欢
     */
    private List<Movie> guess;

    public String getMovieName() {
        return movieName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<PlayInfo> getPlayInfoList() {
        return playInfoList;
    }

    public void setPlayInfoList(List<PlayInfo> playInfoList) {
        this.playInfoList = playInfoList;
    }

    public List<Movie> getGuess() {
        return guess;
    }

    public void setGuess(List<Movie> guess) {
        this.guess = guess;
    }


    public void addPlayInfo(PlayInfo playInfo) {
        playInfoList.add(playInfo);
    }

    @Override
    public String toString() {
        return "MovieDetail{" +
                "movieName='" + movieName + '\'' +
                ", actor='" + actor + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", director='" + director + '\'' +
                ", area='" + area + '\'' +
                ", year='" + year + '\'' +
                ", language='" + language + '\'' +
                ", desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", playInfoList=" + playInfoList +
                ", guess=" + guess +
                '}';
    }
}
