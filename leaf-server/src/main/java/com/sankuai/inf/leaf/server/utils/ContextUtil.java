package com.sankuai.inf.leaf.server.utils;

import org.springframework.context.ApplicationContext;

/**
 * @Description
 * @Author jiangyunhui
 * @Date 2023-09-19 08:33
 **/
public class ContextUtil {
    private static ContextUtil INSTANCE = new ContextUtil();

    private ApplicationContext applicationContext;
    private ContextUtil(){}
    public static ContextUtil getInstance() {
        return INSTANCE;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
