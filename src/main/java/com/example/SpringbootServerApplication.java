package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ImportResource("classpath:spring-dubbo.xml")
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootServerApplication.class, args);
    }

}
