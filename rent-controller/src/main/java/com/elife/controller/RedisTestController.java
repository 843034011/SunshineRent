package com.elife.controller;

import com.elife.dto.TotalOrderResult;
import com.elife.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("redis")
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("test")
    public String test(){

//        List<String> list = new ArrayList<>();
//        list.add("liu");
//        list.add("lan");
//        list.add("bo");

        TotalOrderResult totalOrderResult = new TotalOrderResult();

        redisService.set("test",totalOrderResult);

        System.out.println("======================");
        System.out.println(redisService.get("test"));
        System.out.println("======================");

        return "redirect:../index.html";
    }
}
