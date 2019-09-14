package com.elife.controller;

import com.elife.dto.ShoppingCartResult;
import com.elife.pojo.RentField;
import com.elife.pojo.UserOrder;
import com.elife.service.ShoppingCartService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("shoppingcart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    /**
     * 跳转购物车界面 跳转到
     * /WEN-INF/shoppingcart.html
     * @return
     */
    @RequestMapping("showcart")
    public String showcart(){
        return "shoppingcart";
    }

    /**
     * 查询所有未支付的订单
     * @return
     */
    @RequestMapping("selectall")
    @ResponseBody
    public ResultData selectAll(){
        ResultData resultData = new ResultData();
        List<UserOrder> orders = shoppingCartService.selectAllUserOrderUnpaid();
        System.out.println(orders.size());

        if(null == orders){
            resultData.setCode(1);
            resultData.setMessage("信息查询失败");
        } else {
            resultData.setCode(0);
            resultData.setData(orders);
        }

        return resultData;
    }

    /**
     * 根据id查询场地信息及场地图片
     * @param id
     * @return
     */
    @RequestMapping("selectfieldbyid")
    @ResponseBody
    public ResultData selectFieldById(Integer id){

        System.out.println(id);
        ResultData resultData = new ResultData();

        ShoppingCartResult shoppingCartResult = shoppingCartService.selectFieldById(id);

        if(null == shoppingCartResult){
            resultData.setCode(1);
            resultData.setMessage("按id查询场地信息失败");
        } else {
            resultData.setCode(0);
            resultData.setData(shoppingCartResult);
        }
        return resultData;
    }

//    @RequestMapping("selectgoodsbyid")
//    @ResponseBody
//    public ResultData selectByGoodsId(Integer id){
//        return null;
//    }
}
