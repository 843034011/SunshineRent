package com.elife.controller;

import com.elife.pojo.RentField;
import com.elife.service.impl.fieldsServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:yy
 */
@Controller
@RequestMapping("fields")

public class fieldsInfo {
    @Autowired
    fieldsServiceImpl fieldsService;

    @RequestMapping("showallfields")
    @ResponseBody
    public ResultData selectAllBook(){
        List<RentField> rentFieldList = fieldsService.selectAllFields();
        ResultData resultData = new ResultData();
        if(null == rentFieldList || rentFieldList.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentFieldList);
        }
        return resultData;
    }

@RequestMapping("orderbyprice")
    @ResponseBody
    public ResultData orderByPrice(){
    List<RentField> orderlist = fieldsService.orderByPrice();
    ResultData resultData = new ResultData();
    if(null == orderlist || orderlist.size() ==0) {
        resultData.setCode(3);
        resultData.setMessage("查无数据");
    } else {
        resultData.setCode(0);
        resultData.setData(orderlist);
    }
    return resultData;

}

    @RequestMapping("selectnametype")
    @ResponseBody
    public ResultData selectByNameType(String nametype){
        List<RentField> orderlist = fieldsService.selectByNameType(nametype);
        ResultData resultData = new ResultData();
        if(null == orderlist || orderlist.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderlist);
        }
        return resultData;

    }

}
