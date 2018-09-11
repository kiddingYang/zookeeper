package com.spider.bean;

/**
 * Created by Administrator on 2018/9/7.
 */

import java.util.List;

/**
 * 推荐影视
 */
public class RecommendContext {


    /**
     * 更多电影
     */
    private String moreFilm;


    /**
     * 推荐电影
     */
    private List<Movie> film;


    /**
     * 推荐电视剧
     */
    private List<Movie> teleplay;

    /**
     * 更多电视剧
     */
    private String moreTeleplay;


    /**
     * 综艺节目
     */
    private List<Movie> variety;


    /**
     * 更多综艺
     */
    private String moreVariety;


    /**
     * 福利社
     */
    private List<Movie> welfare;


    /**
     * 更多福利
     */
    private String moreWelfare;

    /**
     * 动漫
     */
    private List<Movie> cartoon;


    /**
     * 更多动漫
     */
    private String moreCartoon;


    public List<Movie> getFilm() {
        return film;
    }

    public void setFilm(List<Movie> film) {
        this.film = film;
    }

    public List<Movie> getTeleplay() {
        return teleplay;
    }

    public void setTeleplay(List<Movie> teleplay) {
        this.teleplay = teleplay;
    }

    public List<Movie> getVariety() {
        return variety;
    }

    public void setVariety(List<Movie> variety) {
        this.variety = variety;
    }

    public List<Movie> getWelfare() {
        return welfare;
    }

    public void setWelfare(List<Movie> welfare) {
        this.welfare = welfare;
    }

    public List<Movie> getCartoon() {
        return cartoon;
    }

    public void setCartoon(List<Movie> cartoon) {
        this.cartoon = cartoon;
    }

    public String getMoreFilm() {
        return moreFilm;
    }

    public void setMoreFilm(String moreFilm) {
        this.moreFilm = moreFilm;
    }

    public String getMoreTeleplay() {
        return moreTeleplay;
    }

    public void setMoreTeleplay(String moreTeleplay) {
        this.moreTeleplay = moreTeleplay;
    }

    public String getMoreVariety() {
        return moreVariety;
    }

    public void setMoreVariety(String moreVariety) {
        this.moreVariety = moreVariety;
    }

    public String getMoreWelfare() {
        return moreWelfare;
    }

    public void setMoreWelfare(String moreWelfare) {
        this.moreWelfare = moreWelfare;
    }

    public String getMoreCartoon() {
        return moreCartoon;
    }

    public void setMoreCartoon(String moreCartoon) {
        this.moreCartoon = moreCartoon;
    }

    @Override
    public String toString() {
        return "RecommendContext{" +
                "moreFilm='" + moreFilm + '\'' +
                ", film=" + film +
                ", teleplay=" + teleplay +
                ", moreTeleplay='" + moreTeleplay + '\'' +
                ", variety=" + variety +
                ", moreVariety='" + moreVariety + '\'' +
                ", welfare=" + welfare +
                ", moreWelfare='" + moreWelfare + '\'' +
                ", cartoon=" + cartoon +
                ", moreCartoon='" + moreCartoon + '\'' +
                '}';
    }
}
