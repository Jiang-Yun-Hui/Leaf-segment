package com.sankuai.inf.leaf.server.utils;

import com.sankuai.inf.leaf.SegmentIdGenerator;
import com.sankuai.inf.leaf.common.Result;
import org.springframework.context.ApplicationContext;

/**
 * @Description
 * @Author jiangyunhui
 * @Date 2023-09-18 19:56
 **/
public class IdGenUtil {

    public static Result get(String tag) {
        ApplicationContext context = ContextUtil.getInstance().getApplicationContext();
        SegmentIdGenerator generator = context.getBean(SegmentIdGenerator.class);
        return generator.get(tag);
    }
}
