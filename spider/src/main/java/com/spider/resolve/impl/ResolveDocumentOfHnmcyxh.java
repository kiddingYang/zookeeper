package com.spider.resolve.impl;

import com.spider.bean.Movie;
import com.spider.bean.RecommendContext;
import com.spider.http.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hnmcyxh.org/ 该网站解析
 * Created by Administrator on 2018/9/7.
 */
public class ResolveDocumentOfHnmcyxh {


    private RecommendContext recommendContext = new RecommendContext();


    private static final String baseURl = "https://www.hnmcyxh.org";

    private static final int movie = 0;
    private static final int teleplay = 1;
    private static final int welfare = 2;
    private static final int cartoon = 3;
    private static final int variety = 4;


    // TODO 是否优先加载?待优化
    public ResolveDocumentOfHnmcyxh() {
        resolve();
    }

    private void resolve() {

        String html = HttpUtils.httpGetSync(baseURl);
        if(html == null || html.trim().equals("")) {
            return;
        }

        Document parse = Jsoup.parse(html);

        // 这个包含了推荐页的电影,电视剧,福利,动漫综艺
        Elements elements = parse.getElementsByClass("index-area clearfix");
        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            if(i == movie) {
                resolveMovieElement(element);
            } else if(i == teleplay) {
                resolveTeleplayElement(element);
            } else if(i == welfare) {
                resolveWelfareElement(element);
            } else if(i == cartoon) {
                resolvecCartoonElement(element);
            } else if(i == variety) {
                resolveVarietyElement(element);
            }
        }
    }

    public RecommendContext getContext() {
        return this.recommendContext;
    }

    /**
     * 解析电影
     * @param element
     */
    private void resolveMovieElement(Element element) {

        recommendContext.setMoreFilm(getMoreUrl(element));
        recommendContext.setFilm(resolveMovies(element));

    }

    /**
     * 解析电视剧
     * @param element
     */
    private void resolveTeleplayElement(Element element) {
        recommendContext.setMoreTeleplay(getMoreUrl(element));
        recommendContext.setTeleplay(resolveMovies(element));
    }


    /**
     * 解析综艺
     * @param element
     */
    private void resolveVarietyElement(Element element) {
        recommendContext.setVariety(resolveMovies(element));
        recommendContext.setMoreVariety(getMoreUrl(element));
    }


    /**
     * 解析福利
     * @param element
     */
    private void resolveWelfareElement(Element element) {
        recommendContext.setWelfare(resolveMovies(element));
        recommendContext.setMoreWelfare(getMoreUrl(element));
    }


    /**
     * 解析动漫
     * @param element
     */
    private void resolvecCartoonElement(Element element) {
        recommendContext.setCartoon(resolveMovies(element));
        recommendContext.setMoreCartoon(getMoreUrl(element));
    }



    /**
     * 获取更多的url链接
     * @param element
     * @return
     */
    private String getMoreUrl(Element element) {

        String moreUrl = element.getElementsByTag("h1").get(0).
                getElementsContainingOwnText("更多").get(0).attr("href");
        return createUrlWithBaseUrl(moreUrl);
    }


    /**
     * 将<li>标签解析
     * @param element 整个节点
     * @return
     */
    private List<Movie> resolveMovies(Element element) {

        Elements movieElements = element.getElementsByTag("ul").get(0).getElementsByTag("li");

        List<Movie> movieList = new ArrayList<Movie>();
        for (Element movieElement : movieElements) {
            String href = movieElement.getElementsByTag("a").attr("href");
            String title = movieElement.getElementsByTag("a").attr("title");
            String img = movieElement.getElementsByTag("img").get(0).attr("data-original");
            String movieName = movieElement.getElementsByClass("name").get(0).text();
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setMovieName(movieName);
            movie.setHref(createUrlWithBaseUrl(href));
            movie.setMoviePicUrl(img);
            movieList.add(movie);
        }
        return movieList;
    }


    /**
     * 加上baseUrl
     * @param url
     * @return
     */
    private String createUrlWithBaseUrl(String url) {

        if(url.startsWith("/")) {
            url = baseURl + url;
        } else {
            url = baseURl + "/" + url;
        }
        return url;
    }

    public static void main(String[] args) {

        ResolveDocumentOfHnmcyxh resolveDocument = new ResolveDocumentOfHnmcyxh();
        Object context = resolveDocument.getContext();
        System.out.println(context);

    }
}
