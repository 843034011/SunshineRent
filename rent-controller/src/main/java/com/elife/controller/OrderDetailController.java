package com.elife.controller;

import com.elife.pojo.OrderDetail;
import com.elife.pojo.UserOrder;
import com.elife.service.OrderDetailService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("giveback")
    @ResponseBody
    public ResultData giveBack(int detailId){
        ResultData resultData = new ResultData();
        OrderDetail orderDetail = orderDetailService.selectById(detailId);
        orderDetail.setProductStatus("未评价");
        int result = orderDetailService.updateByPrimaryKey(orderDetail);
        if(result >= 1) {
            resultData.setCode(0);
            resultData.setMessage("修改成功");
        } else {
            resultData.setCode(5);
            resultData.setMessage("修改失败");
        }
        return resultData;
    }

    /**
     * @author llb
     * @param num
     * @param kind
     * @return
     */
    @RequestMapping("selectorderdate")
    @ResponseBody
    public ResultData selectOrderDateUnEvaluate(Integer num, String kind) {

        ResultData resultData = new ResultData();

        System.out.println(kind);

        List<OrderDetail> orderDetails = new ArrayList<>();

        if (kind.equals("field")) {
            orderDetails = orderDetailService.selectFieldOrderDateUnEvaluate(num);

            resultData.setCode(0);
            resultData.setData(orderDetails);

            return resultData;
        } else if (kind.equals("goods")) {
            orderDetails = orderDetailService.selectGoodsOrderDateUnEvaluate(num);

            resultData.setCode(0);
            resultData.setData(orderDetails);

            return resultData;
        }
        return null;
    }


}
