package com.imooc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
        JpaRepositoriesAutoConfiguration.class//禁止springboot自动加载持久化bean
})
public class GirlApplication {

    public static void main(String[] args) {


        SpringApplication.run(GirlApplication.class, args);
    }


}

