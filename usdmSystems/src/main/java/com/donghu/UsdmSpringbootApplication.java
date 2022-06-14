package com.donghu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.donghu.mapper")
public class UsdmSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsdmSpringbootApplication.class, args);
    }

}
