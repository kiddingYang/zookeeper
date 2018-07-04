package com.std.guava;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RangeTest {

    @Test
    public void splitterTest() {
        String url = "http://www.diguage.com?userName=diguage&sex=fale";
        String substring = url.substring(url.indexOf("?") + 1);
        System.out.println(substring);
        Map<String, String> mapSplitter = Splitter.on("&").withKeyValueSeparator("=").split(substring);
        System.out.println(mapSplitter);
    }

    @Test
    public void caseFormatTest() {
        String tableName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, RangeTest.class.getSimpleName());
        System.out.println(tableName);
    }

    @Test
    public void joinerTest() {
        ArrayList<String> list = Lists.newArrayList();
        list.add("a");
        list.add("c");
        list.add("b");
        String join = Joiner.on("|").skipNulls().join(list);
        System.out.println(join);
    }

    @Test
    public void StringUtils() {
        String padEnd = Strings.padEnd("", 5, 'a');
        System.out.println(padEnd);
    }


    @Test
    public void cacheTest() {
        Cache<Object, Object> build = CacheBuilder.newBuilder()
                .expireAfterAccess(20L, TimeUnit.MILLISECONDS)
                .softValues()
                .removalListener(new RemovalListener<Object, Object>() {
                    public void onRemoval(RemovalNotification<Object, Object> notification) {
                        System.out.println("remove : " + notification);
                    }
                }).build();



    }


}
