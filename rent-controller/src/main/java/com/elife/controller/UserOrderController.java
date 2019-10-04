package com.elife.controller;

import com.elife.dto.TotalOrderResult;
import com.elife.pojo.UserOrder;
import com.elife.service.UserOrderService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * author:byf
 */
@Controller
@RequestMapping("orders")
public class UserOrderController {

    @Autowired
    UserOrderService userOrderService;

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

    /**
     * @author llb
     * @return
     */
    @RequestMapping("ensureorder")
    public String ensureOrder(){
        return "ensureorder";
    }

    @RequestMapping(value = "/insertorder")
    @ResponseBody
    public ResultData insertOrder(@RequestBody TotalOrderResult totalOrderResult){

        ResultData resultData = new ResultData();

        // 生成订单的创建时间
        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 生成订单编号
        String orderId = UUID.randomUUID().toString().replaceAll("-","");

        // 添加当前总订单所需要的参数
        totalOrderResult.setOrderId(orderId);
        totalOrderResult.setOrderStatus("已完成");
        totalOrderResult.setCreateTime(timeStr);

        System.out.println(totalOrderResult.toString());

        resultData.setCode(0);
        return resultData;
    }
}
