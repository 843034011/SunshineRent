package com.elife.controller;


import com.elife.pojo.RentGoods;
import com.elife.service.impl.GoodsManageServiceImpl;
import com.elife.vo.ResultData;
import org.junit.jupiter.api.Test;
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
    @Autowired
    GoodsManageServiceImpl goodsManageService;

    @RequestMapping("regId")
    @ResponseBody
//    @Test
    public ResultData selectRegId(Integer regId){
        List<RentGoods> rentGoods = goodsManageService.selectByRegId(1);
        ResultData resultData = new ResultData();
        if(null == rentGoods || rentGoods.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
//            System.out.println("===");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGoods);
//            System.out.println("===");
        }
//        System.out.println(rentGoods.size()+"===");

        return resultData;
    }

}
