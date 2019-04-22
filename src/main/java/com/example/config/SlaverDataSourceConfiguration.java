package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class SlaverDataSourceConfiguration {

    @Value("${spring.datasource.slaver.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.slaver.url}")
    private String url;

    @Value("${spring.datasource.slaver.username}")
    private String username;

    @Value("${spring.datasource.slaver.password}")
    private String password;

    @Bean(name = "slaverDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }


    @Bean(name = "slaverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "slaverJdbcTemplate")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("slaverDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
