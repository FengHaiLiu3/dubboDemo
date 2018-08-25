package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo.xml"})
@MapperScan("com.demo.mapper")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ProviderApplication {
    public static void main(String args[]){
        SpringApplication.run(ProviderApplication.class,args);
        try {
            System.in.read();
        }catch (Exception e){
            //TO-DO
            e.printStackTrace();
        }
    }
}
