package com.elife.controller;

import com.elife.pojo.UserOrder;
import com.elife.service.impl.UserOrderServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

/**
 * author:byf
 */
@Controller
@RequestMapping("orders")
public class UserOrderController {

    @Autowired
    UserOrderServiceImpl userOrderService;

    @RequestMapping("showallorders")
    @ResponseBody
    public ResultData selectAllUserOrder() {
        List<UserOrder> userOrders = userOrderService.selectAllUserOrder();
        for (int i = 0; i < userOrders.size(); i++) {
            if (userOrders.get(i).getOrderStatus().equals("未支付")) {
                userOrders.remove(i);
            }
        }
        System.out.println("====================================================================");
        System.out.println(userOrders.toString());
        ResultData resultData = new ResultData();
        if (null == userOrders || userOrders.size() == 0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {

            resultData.setCode(0);
            resultData.setData(userOrders);
        }
        return resultData;
    }

    @RequestMapping("selectorderdate")
    @ResponseBody
    public ResultData selectOrderDateUnEvaluate(Integer num, String kind) {

        ResultData resultData = new ResultData();

        System.out.println(kind);
        List<UserOrder> userOrders = new ArrayList<>();

        if (kind.equals("field")) {
            userOrders = userOrderService.selectFieldOrderDateUnEvaluate(num);
            System.out.println(userOrders.size());
            if (userOrders.size() != 0) {
                resultData.setCode(0);
                resultData.setData(userOrders);
            } else {
                resultData.setCode(1);
                resultData.setMessage("查询无果！！！！");
            }
            return resultData;
        } else if (kind.equals("goods")) {
            userOrders = userOrderService.selectGoodsOrderDateUnEvaluate(num);
            System.out.println(userOrders.size());
            if (userOrders.size() != 0) {
                resultData.setCode(0);
                resultData.setData(userOrders);
            } else {
                resultData.setCode(1);
                resultData.setMessage("查询无果！！！！");
            }
            return resultData;
        }
        return null;
    }
}
