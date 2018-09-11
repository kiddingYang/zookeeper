package com.spider.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/8.
 */
public class PlayInfo {

    /**
     * 播放源名称,eg:iqiyi qq等
     */
    private String playSrcName;

    private List<PlayLink> playLinkList;


    public String getPlaySrcName() {
        return playSrcName;
    }

    public void setPlaySrcName(String playSrcName) {
        this.playSrcName = playSrcName;
    }

    public List<PlayLink> getPlayLinkList() {
        return playLinkList;
    }

    public void setPlayLinkList(List<PlayLink> playLinkList) {
        this.playLinkList = playLinkList;
    }

    /**
     * 播放url和集数
     */
    public static class PlayLink {

        private String title;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "PlayLink{" +
                    "title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PlayInfo{" +
                "playSrcName='" + playSrcName + '\'' +
                ", playLinkList=" + playLinkList +
                '}';
    }
}
