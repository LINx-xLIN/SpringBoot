package com.lin.springboot;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.springboot.mapper")
public class SpringbootSolrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSolrApplication.class, args);
    }

}
