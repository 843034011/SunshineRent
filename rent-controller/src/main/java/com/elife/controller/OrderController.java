package com.elife.controller;

import com.elife.pojo.UserOrder;
import com.elife.service.ShowOrderInfoService;
import com.elife.service.UserOrderService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("userorder")
public class OrderController {

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    private ShowOrderInfoService showOrderInfoService;

    @RequestMapping("showorderlist")
    public String showOrderList(){
        return "orderlist";
    }

    @RequestMapping("showallorders")
    @ResponseBody
    public ResultData selectAllBook(HttpSession session){
        List<UserOrder> orderList = userOrderService.selectAllByRentId(3);
        ResultData resultData = new ResultData();
        if(null == orderList || orderList.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderList);

        }
        return resultData;
    }

    @RequestMapping("showorderinfo")
    @ResponseBody
    public ResultData selectByOrderId(int orderId){
        ResultData resultData = new ResultData();
        resultData = showOrderInfoService.selectOrderInfo(orderId);
        return resultData;
    }
}
