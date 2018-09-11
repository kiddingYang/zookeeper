package com.spider.resolve.impl;

import com.spider.bean.MovieDetail;
import com.spider.bean.PlayInfo;
import com.spider.http.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析电影详情
 * Created by Administrator on 2018/9/7.
 */

public class ResolveDocumentOfDetail {

    private static final int iqiyi = 0;
    private static final int m3u8 = 1;
    private static final int qq = 2;
    private static final int mgtv = 3;
    private static final int ckm3u8 = 4;
    private static final int youku = 5;

    private MovieDetail movieDetail = new MovieDetail();

    private String detailUrl;

    public ResolveDocumentOfDetail(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    /**
     * 解析电影详情
     */
    private void resolve() {


        String detailHtml = HttpUtils.httpGetSync(detailUrl);
        Document document = Jsoup.parse(detailHtml);
        Elements main = document.getElementsByClass("main").get(1).getElementsByClass("ct mb clearfix");

        Elements playList = document.getElementsByClass("main").get(1).getElementsByClass("playlist clearfix");

        String moviePicUrl = document.getElementsByClass("main").get(1).getElementsByClass("ct-l").get(0).getElementsByTag("img").get(0).attr("data-original");
        Element movieInfo = main.get(0).getElementsByClass("ct-c").get(0);
        String movieDesc = main.get(0).getElementsByClass("ee").get(0).text();

        for (int i = 0; i < playList.size(); i++) {

            Element playElement = playList.get(i);
//            PlayInfo playInfo = null;
//            if (i == iqiyi) {
//                playInfo = buildPlayInfo(playElement);
//            } else if (i == m3u8) {
//
//            } else if (i == qq) {
//
//            } else if (i == mgtv) {
//
//            } else if (i == ckm3u8) {
//
//            } else if (i == youku) {
//
//            }
            PlayInfo playInfo = buildPlayInfo(playElement);
            Elements info = movieInfo.getElementsByTag("dl").get(0).getElementsByTag("dd");
            movieDetail.setMovieName(movieInfo.getElementsByTag("dl").get(0).getElementsByClass("name").get(0).text());
            movieDetail.setStatus(info.get(0).children().size() < 2 ? "" : info.get(0).childNode(1).toString());
            movieDetail.setUpdateDate(info.get(1).children().size() < 2 ? "" : info.get(1).childNode(1).toString());
            movieDetail.setDirector(info.get(2).children().size() < 2 ? "" : info.get(2).childNode(1).toString());
            movieDetail.setArea(info.get(3).children().size() < 2 ? "" : info.get(3).childNode(1).toString());
            movieDetail.setYear(info.get(4).children().size() < 2 ? "" : info.get(4).childNode(1).toString());
            movieDetail.setLanguage(info.get(5).children().size() < 2 ? "" : info.get(5).childNode(1).toString());
            movieDetail.setPicUrl(moviePicUrl);
            movieDetail.setDesc(movieDesc);
            movieDetail.addPlayInfo(playInfo);
        }

        System.out.println(movieDetail);


    }

    private PlayInfo buildPlayInfo(Element playElement) {
        PlayInfo playInfo = new PlayInfo();
        PlayInfo.PlayLink playLink = new PlayInfo.PlayLink();
        playLink.setTitle(playElement.getElementsByClass("intro").text());
        Elements playUrl = playElement.getElementsByClass("videourl clearfix")
                .get(0).getElementsByTag("li");
        playInfo.setPlayLinkList(parseLink(playUrl));
        playInfo.setPlaySrcName(playElement.getElementsByClass("intro").text());
        return playInfo;
    }

    /**
     * 解析链接
     * @param playUrl
     * @return
     */
    private List<PlayInfo.PlayLink> parseLink(Elements playUrl) {

        List<PlayInfo.PlayLink> playLinkList = new ArrayList<PlayInfo.PlayLink>();
        for (Element element : playUrl) {
            PlayInfo.PlayLink playLink = new PlayInfo.PlayLink();
            playLink.setUrl(element.getElementsByTag("a").attr("href"));
            playLink.setTitle(element.getElementsByTag("a").attr("title"));
            playLinkList.add(playLink);
        }
        return playLinkList;
    }


    public static void main(String[] args) {
        String detailUrl = "https://www.hnmcyxh.org/dongzuopian/shenqimaxituanzhidongwubinggan/";
        ResolveDocumentOfDetail resolveDocumentOfDetail = new ResolveDocumentOfDetail(detailUrl);
        resolveDocumentOfDetail.resolve();

    }

}
