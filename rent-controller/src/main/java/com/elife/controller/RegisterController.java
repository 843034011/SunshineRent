package com.elife.controller;

import com.elife.annotation.Token;
import com.elife.pojo.RentRegister;
import com.elife.pojo.RentUser;
import com.elife.service.RegisterService;
import com.elife.service.UserService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @Autowired
    UserService userService;

    @RequestMapping("insertuser")
    @Token(remove = true)
    public String insertUser(String telephone,String password){

        System.out.println(telephone);
        System.out.println(password);

        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeStr);

        int i = registerService.insertRegister(telephone,password,timeStr);

        if(i > 0){

            RentRegister rentRegister = registerService.selectRegister(telephone,password);

            int j = userService.insertFirst(rentRegister.getRegId());
            if(j > 0 ){
                return "redirect:../login.html";
            }
        }
        return "redirect:../register.html";
    }

    @RequestMapping("selectregister")
    @ResponseBody
    public ResultData selectRegister(HttpSession session,String telephone,String password){
        System.out.println(telephone);

        ResultData resultData = new ResultData();

        RentRegister rentRegister = registerService.selectRegister(telephone,password);

        if(rentRegister != null){
            resultData.setCode(0);
            resultData.setData(rentRegister);
            session.setAttribute("rentRegister",rentRegister);

            RentUser rentUser = userService.selectByTelephone(rentRegister.getRegId());

            System.out.println(rentUser.getUserId());
            System.out.println(rentUser.getIsIdentified());

            session.setAttribute("idIdentified",rentUser.getIsIdentified());

        }else {
            resultData.setCode(1);
            resultData.setMessage("查询无果！！");
        }

        return resultData;
    }

    // 跳转到register页面
    // 改变annotation中save的状态，interceptor设置token
    @RequestMapping("showregister")
    @Token(save = true)
    public String setSession(){
        return "redirect:../register.html";
    }
}
