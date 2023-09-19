package com.sankuai.inf.leaf;

import com.sankuai.inf.leaf.common.Result;

import javax.sql.DataSource;

public interface SegmentIdGenerator {
    Result get(String key);
    boolean init(DataSource dataSource);

    void shutdown();
}
