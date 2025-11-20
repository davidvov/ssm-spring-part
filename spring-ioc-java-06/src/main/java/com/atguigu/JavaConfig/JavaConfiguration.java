package com.atguigu.JavaConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com.atguigu")
@PropertySource(value = "classpath:jdbc.properties")
public class JavaConfiguration {
    @Value("${atguigu.url}")
    String url;
    @Value("${atguigu.driver}")
    String drive;
    @Value("${atguigu.username}")
    String username;
    @Value("${atguigu.password}")
    String password;

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(drive);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Scope("prototype")
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
