package com.elife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan(basePackages = "com.elife.mapper")
@ServletComponentScan
public class RentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApplication.class,args);
    }

}
