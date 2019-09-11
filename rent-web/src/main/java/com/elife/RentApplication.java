package com.elife;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan(basePackages = "com.elife.mapper")
//@ServletComponentScan
@Controller
public class RentApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentApplication.class,args);
    }

    @RequestMapping("shoppingcart")
    public String shoppingcart(){
        return "shoppingcart";
    }
}
