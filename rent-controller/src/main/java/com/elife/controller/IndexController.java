package com.elife.controller;

import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.pojo.RentUser;
import com.elife.service.impl.IndexServiceImpl;
import com.elife.service.impl.RentUserServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * author:zgy
 */
@Controller
@RequestMapping("indexCon")
public class IndexController {

    @Autowired
    RentUserServiceImpl rentUserService;

    @Autowired
    IndexServiceImpl indexService;

    @RequestMapping("selectById")
    @ResponseBody
    public ResultData selectById(Integer userId){
        RentUser rentUser = rentUserService.selectById(userId);
        ResultData resultData = new ResultData();
        if(rentUser != null ){
            resultData.setCode(0);
            resultData.setData(rentUser);
        } else {
            resultData.setCode(3);
            resultData.setMessage("没有数据");
        }
        return resultData;
    }

    // 查询所有场地信息
    @RequestMapping("selectFields")
    @ResponseBody
    public ResultData selectField(String fieldType){
        ResultData resultData = new ResultData();
        List<RentField> rentFields = indexService.selectOrderByGrade(fieldType);
        if(rentFields != null ){
            resultData.setCode(0);
            resultData.setData(rentFields);
        } else {
            resultData.setCode(3);
            resultData.setMessage("没有数据");
        }
        return resultData;
    }

    // 查询所有商品信息
    @RequestMapping(value="selectGoods",method = RequestMethod.GET)
    @ResponseBody
    public ResultData selectGoods(){
        ResultData resultData = new ResultData();
        List<RentGoods> rentGoods = indexService.selectAllGoods();
        if(rentGoods != null ){
            resultData.setCode(0);
            resultData.setData(rentGoods);
        } else {
            resultData.setCode(3);
            resultData.setMessage("没有数据");
        }
        return resultData;
    }

    //清除session
    @RequestMapping("/clearsession")
    public String returnUrl(HttpSession session){
        session.removeAttribute("rentRegister");
        session.removeAttribute("idIdentified");
        return "index.html";
    }
}
