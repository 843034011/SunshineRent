package com.elife.controller;

import com.elife.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author:llb
 */
@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("insertuser")
    public String insertUser(String telephone,String password){

        System.out.println(telephone);
        System.out.println(password);

        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeStr);

        int i = registerService.insertRegister(telephone,password,timeStr);

        if(i > 0){
            return "redirect:../login.html";
        }
        return "redirect:../register.html";
    }
}
