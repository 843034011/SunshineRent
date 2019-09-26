package com.elife.controller;

import com.elife.pojo.OrderDetail;
import com.elife.service.OrderDetailService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("orderDetail")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @RequestMapping("showOrderDetail")
    @ResponseBody
    public ResultData showOrderDetail(int detailId){
        ResultData resultData = new ResultData();
        OrderDetail orderDetail = orderDetailService.selectById(detailId);
        if(null == orderDetail) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderDetail);

        }
        return resultData;
    }



}
