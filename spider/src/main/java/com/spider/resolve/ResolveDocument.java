package com.spider.resolve;

/**
 * Created by Administrator on 2018/9/7.
 */
public interface ResolveDocument {


    /**
     * 解析html
     * @return
     */
    void resolve();


    /**
     * 获取解析的上下文
     * @return
     */
    Object getContext();

}
