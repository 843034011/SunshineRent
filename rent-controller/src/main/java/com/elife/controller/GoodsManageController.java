package com.elife.controller;


import com.elife.pojo.RentGoods;
import com.elife.service.impl.GoodsManageServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:zgy
 */
@Controller
@RequestMapping("goodsManageCon")
public class GoodsManageController {

    @RequestMapping("showManage")
    public String showManage(){
        return "goodsmanage";
    }

    @Autowired
    GoodsManageServiceImpl goodsManageService;

    @RequestMapping("selectRegId")
    @ResponseBody
    public ResultData selectRegId(Integer regId){
        List<RentGoods> rentGoods = goodsManageService.selectByRegId(regId);
        ResultData resultData = new ResultData();
        if(null == rentGoods || rentGoods.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGoods);
        }
        return resultData;
    }

    @RequestMapping("updateByPrimaryKey")
    public int updateByPrimaryKey(RentGoods record){
        return goodsManageService.updateByPrimaryKey(record);
    }

}
