package com.gh.firstdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.gh.firstdemo.dao")
public class FirstdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstdemoApplication.class, args);
    }

}
