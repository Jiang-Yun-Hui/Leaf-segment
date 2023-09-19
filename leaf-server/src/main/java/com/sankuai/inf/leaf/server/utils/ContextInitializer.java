package com.sankuai.inf.leaf.server.utils;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author jiangyunhui
 * @Date 2023-09-19 08:34
 **/
@Component
public class ContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ContextUtil.getInstance().setApplicationContext(applicationContext);
    }
}
