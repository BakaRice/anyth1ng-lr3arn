package com.ricemarch.accessdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ricemarch.accessdata.mapper")
public class AccessDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessDataApplication.class, args);
    }

}
