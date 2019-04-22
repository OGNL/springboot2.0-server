package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MasterDataSourceConfiguration {

    @Value("${spring.datasource.master.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.master.url}")
    private String url;

    @Value("${spring.datasource.master.username}")
    private String username;

    @Value("${spring.datasource.master.password}")
    private String password;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(this.driverClassName);
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }


    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "masterJdbcTemplate")
    @Primary
    public JdbcTemplate masterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }



}