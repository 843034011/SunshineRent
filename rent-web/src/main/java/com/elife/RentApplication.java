package com.elife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.elife.mapper")
public class RentApplication {

    //push的时候将在application中添加的东西清光，只保留主函数
    public static void main(String[] args) {
        SpringApplication.run(RentApplication.class,args);
    }

}
