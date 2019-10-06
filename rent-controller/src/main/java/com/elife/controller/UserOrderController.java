package com.elife.controller;

import com.elife.dto.TotalOrderResult;
import com.elife.pojo.UserOrder;
import com.elife.service.RedisService;
import com.elife.service.UserOrderService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private RedisService redisService;

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
     * @return
     * @author llb
     */
    @RequestMapping("ensureorder")
    public String ensureOrder() {
        return "ensureorder";
    }

    @RequestMapping("getfirstorder")
    @ResponseBody
    public ResultData getFirstOrder(HttpSession session) {
        ResultData resultData = new ResultData();

        TotalOrderResult result = (TotalOrderResult) session.getAttribute("totalOrderResult");
        System.out.println(result.toString());

        resultData.setCode(0);
        resultData.setData(result);

        return resultData;
    }

    @RequestMapping(value = "/addinfo")
    @ResponseBody
    public ResultData insertOrder(@RequestBody TotalOrderResult totalOrderResult, HttpSession session) {

        ResultData resultData = new ResultData();

        // 生成订单的创建时间
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 生成订单编号
        String orderId = UUID.randomUUID().toString().replaceAll("-", "");

        // 添加当前总订单所需要的参数
        totalOrderResult.setOrderId(orderId);
        totalOrderResult.setOrderStatus("已完成");
        totalOrderResult.setCreateTime(timeStr);

        // 为订单详情添加外键信息
        for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
            totalOrderResult.getResults().get(i).setOrderId(orderId);
        }

        System.out.println(totalOrderResult.toString());

        session.setAttribute("totalOrderResult", totalOrderResult);

        resultData.setCode(0);
        return resultData;
    }

    @RequestMapping(value = "/addaddress")
    @ResponseBody
    public ResultData addAddress(String id, String address, HttpSession session) {
        ResultData resultData = new ResultData();

        TotalOrderResult totalOrderResult = (TotalOrderResult) session.getAttribute("totalOrderResult");

        System.out.println(id);
        System.out.println(address);

        for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
            System.out.println();
            if (totalOrderResult.getResults().get(i).getId().equals(id)) {
                totalOrderResult.getResults().get(i).setAddress(address);
            }
        }

        System.out.println(totalOrderResult.toString());

        resultData.setCode(0);
        resultData.setData(totalOrderResult);

        return resultData;
    }

    @RequestMapping("confirm")
    public String confirm(HttpSession session) {
        // 将当前订单存放到redis缓存中
        TotalOrderResult totalOrderResult = (TotalOrderResult) session.getAttribute("totalOrderResult");

        redisService.set("totalOrderResult", totalOrderResult);

        System.out.println(redisService.get("totalOrderResult").toString());

        String orderId = totalOrderResult.getOrderId();
        String money = totalOrderResult.getOrderTotal();
        String storeName = "阳光租赁";

        return ("redirect:/alipay/payInfo?orderId=" + orderId + "&money=" + money + "&storeName=" + storeName);
    }
}
