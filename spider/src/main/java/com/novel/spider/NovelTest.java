package com.novel.spider;

import com.spider.http.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.downloader.Downloader;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;


/**
 * Created by Administrator on 2018/9/15.
 */
public class NovelTest implements PageProcessor,Task {


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000).setTimeOut(10000);

    @Override
    public void process(Page page) {
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-]+)").all());
        page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
        page.putField("name", page.getHtml().xpath("//h1[@class='public']/strong/a/text()").toString());
        if (page.getResultItems().get("name")==null){
            //skip this page
            page.setSkip(true);
        }
        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    @Override
    public String getUUID() {
        return null;
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
//        Spider.create(new NovelTest()).addUrl("https://github.com/code4craft").thread(5).run();
        Downloader downloader = new HttpClientDownloader();
        Page page = downloader.download(new Request("http://www.biquge.com.tw/"), new NovelTest());
        Html html = page.getHtml();
        List<String> all = html.xpath("//div[@id='hotcontent']/[@class='l']/[@class='item']").all();
        for (String item : all) {
            Html html1 = new Html(item);
            System.out.println(html1.xpath("div[@class='image']/a/@href"));
            System.out.println(html1.xpath("div[@class='image']/a/img/@src"));
            System.out.println(html1.xpath("dl/dt/span/text()"));
            System.out.println(html1.xpath("dl/dt/a/@href"));
            System.out.println(html1.xpath("dl/dd/text()"));

            System.out.println("--------------------------------");
        }
    }
}
