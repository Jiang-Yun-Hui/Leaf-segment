package com.sankuai.inf.leaf.configuration;

import com.sankuai.inf.leaf.SegmentIdGenerator;
import com.sankuai.inf.leaf.exception.InitException;
import com.sankuai.inf.leaf.segment.SegmentIDGenImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Description
 * @Author jiangyunhui
 * @Date 2023-09-18 18:55
 **/
@Configuration
public class SegmentIdConfiguration implements ApplicationContextAware {
    private Logger logger = LoggerFactory.getLogger(SegmentIdConfiguration.class);
    private ApplicationContext applicationContext;

    @Bean(destroyMethod = "shutdown")
    public SegmentIdGenerator segmentIdGenerator() {
        JdbcTemplate jdbcTemplate;
        try {
            jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        } catch (Exception e) {
            throw new RuntimeException("DataSource not exists...", e);
        }
        DataSource dataSource = jdbcTemplate.getDataSource();
        SegmentIdGenerator segmentIdGenerator = new SegmentIDGenImpl();
        if (segmentIdGenerator.init(dataSource)) {
            logger.info("SegmentIdGenerator initialization success...");
        } else {
            throw new InitException("SegmentIdGenerator initialization failed...");
        }
        return segmentIdGenerator;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
