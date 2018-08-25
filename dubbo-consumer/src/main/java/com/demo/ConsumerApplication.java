package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@MapperScan("com.demo.mapper")
@SpringBootApplication(scanBasePackages = {"com.demo"})
@ImportResource({"classpath:dubbo.xml"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}