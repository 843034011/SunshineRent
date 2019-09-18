package com.elife.controller;

import com.elife.pojo.RentRegister;
import com.elife.service.RegisterService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author llb
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

    @RequestMapping("selectregisterbytelephone")
    @ResponseBody
    public ResultData selectRegisterByTelephone(String telephone){
        System.out.println(telephone);

        ResultData resultData = new ResultData();

        RentRegister rentRegister = registerService.selectRegisterByTelephone(telephone);

        if(rentRegister != null){
            resultData.setCode(0);
            resultData.setData(rentRegister);
        }else {
            resultData.setCode(1);
            resultData.setMessage("查询无果！！");
        }

        return resultData;
    }
}
