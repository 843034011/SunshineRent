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
import java.math.BigDecimal;
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
    public ResultData getFirstOrder() {
        ResultData resultData = new ResultData();

        TotalOrderResult totalOrderResult = new TotalOrderResult();

        // 判断当前redis缓存中是否有totalOrderResult，如果有取出来
        if(redisService.exists(orderId) == true){
            totalOrderResult = (TotalOrderResult) redisService.get(orderId);
        } else {
            resultData.setCode(1);
            resultData.setMessage("当前缓存中缺少数据！！！！");
            return resultData;
        }

        resultData.setCode(0);
        resultData.setData(totalOrderResult);

        return resultData;
    }

    private static String orderId;

    @RequestMapping(value = "/addinfo")
    @ResponseBody
    public ResultData insertOrder(@RequestBody TotalOrderResult totalOrderResult) {

        ResultData resultData = new ResultData();

        // 生成订单的创建时间
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(timeStr);
        System.out.println(timeStr.replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
        // 生成订单编号
        orderId = UUID.randomUUID().toString().replaceAll("-", "");

        // 添加当前总订单所需要的参数
        totalOrderResult.setOrderId(orderId);
        totalOrderResult.setOrderStatus("待评价");
        totalOrderResult.setCreateTime(timeStr);

        // 为订单详情添加外键信息
        for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
            totalOrderResult.getResults().get(i).setOrderId(orderId);
        }

        System.out.println(totalOrderResult.toString());

        // 将订单信息放入redis缓存中
        long l = 15 * 60;
        redisService.set(orderId, totalOrderResult,l);

        resultData.setCode(0);
        return resultData;
    }

    @RequestMapping(value = "/addaddress")
    @ResponseBody
    public ResultData addAddress(String id, String address) {
        ResultData resultData = new ResultData();

        TotalOrderResult totalOrderResult = new TotalOrderResult();

        // 判断当前redis缓存中是否有totalOrderResult，如果有取出来
        if(redisService.exists("totalOrderResult") == true){
            totalOrderResult = (TotalOrderResult) redisService.get("totalOrderResult");
        } else {
            resultData.setCode(1);
            resultData.setMessage("当前缓存中缺少数据！！！！");

            return resultData;
        }

        System.out.println(id);
        System.out.println(address);

        for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
            if (totalOrderResult.getResults().get(i).getId() == Integer.parseInt(id)) {
                totalOrderResult.getResults().get(i).setAddress(address);
                System.out.println(totalOrderResult.toString());
            }
        }

        // 将订单信息放入redis缓存中，并设置有效时间为15min
        long l = 15 * 60;
        redisService.set(orderId, totalOrderResult,l);

        resultData.setCode(0);
        resultData.setData(totalOrderResult);

        return resultData;
    }

    @RequestMapping("confirm")
    public String confirm(HttpSession session) {

        TotalOrderResult totalOrderResult = new TotalOrderResult();

        // 判断当前redis缓存中是否有totalOrderResult，如果有取出来
        if(redisService.exists(orderId) == true){
            totalOrderResult = (TotalOrderResult) redisService.get(orderId);
        } else {
            return "shoppingcart";
        }

        redisService.remove(orderId);

        // 将当前订单存放到session中
        session.setAttribute("totalOrderResult",totalOrderResult);

        System.out.println(totalOrderResult.toString());

        String orderId = totalOrderResult.getOrderId();
        BigDecimal money = totalOrderResult.getOrderTotal();
        String storeName = "SunshineRent";

        return ("redirect:/alipay/payInfo?orderId=" + orderId + "&money=" + money + "&storeName=" + storeName);
    }
}
