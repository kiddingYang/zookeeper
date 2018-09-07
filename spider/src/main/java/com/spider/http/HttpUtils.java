package com.spider.http;

import com.spider.bean.Movie;
import com.spider.exception.HttpIOException;
import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class HttpUtils {


    String url = "https://www.80s.tw/movie/list";

    public String httpGetAsync(String url,Callback callback) {

        Request request = new Request.Builder().url(url).get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        return null;
    }

    /**
     * 同步方式get请求url
     * @param url
     * @return
     */
    public static String httpGetSync(String url) {

        Request request = new Request.Builder().url(url)
                .header("referer","https://www.80s.tw/")
                .header("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36")
                .header("cookie","adClass0803=5; Hm_lvt_652f84236c4c73e10377e2dd54891ff3=1536306312; _ga=GA1.2.372868138.1536306316; _gid=GA1.2.435384999.1536306316; adClass0803=3; AD_Time_480=\"idx:1\"; Hm_lpvt_652f84236c4c73e10377e2dd54891ff3=1536308853")
                .header(":authority","www.80s.tw")
                .get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                if (body != null) {
                    return body.string();
                }
            }
        } catch (IOException e) {
            throw new HttpIOException(e);
        }
        return null;
    }


    public static void main(String[] args) {

        String url = "http://www.80s.tw/movie/list";
        String htmlResponse = HttpUtils.httpGetSync(url);
        Document parse = Jsoup.parse(htmlResponse);
        Elements elements = parse.getElementsByClass("me1 clearfix");
        List<Movie> movieList = new LinkedList<Movie>();
        for (Element element : elements) {
            Elements liOfMovieList = element.getElementsByTag("li");
            for (Element liOfMovie : liOfMovieList) {
                Elements children = liOfMovie.children();
                if(!children.isEmpty()) {
                    // 直接使用第一条解析
                    String href = children.get(0).attr("href");
                    String title = children.get(0).attr("title");
                    String imgUrl = children.get(0).getElementsByTag("img").attr("src");
                    String score = children.get(0).getElementsByTag("span").get(1).ownText();
                    String desc = children.get(2).ownText();
                    Movie movie = new Movie();
                    movie.setHref(href);
                    movie.setTitle(title);
                    movie.setMoviePicUrl(imgUrl);
                    movie.setDescription(desc);
                    movie.setScore(score);
                    movieList.add(movie);
                }
            }
        }
        System.out.println(movieList);
    }

}
