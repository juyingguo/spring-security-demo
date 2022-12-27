package com.blurooo.chapter62;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blurooo.chapter62.mapper")
public class Chapter62Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter62Application.class, args);
    }

}
