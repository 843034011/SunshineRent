package com.elife.controller;

import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.pojo.RentRegister;
import com.elife.pojo.UserOrder;
import com.elife.service.ShoppingCartService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author llb
 */
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
     * 根据regId查询所有未支付的订单
     * @return
     */
    @RequestMapping("selectallbyid")
    @ResponseBody
    public ResultData selectAll(Integer regId){
        ResultData resultData = new ResultData();
        List<UserOrder> orders = shoppingCartService.selectAllUserOrderUnpaidById(regId);
        System.out.println(orders.size());

        if(null == orders){
            resultData.setCode(3);
            resultData.setMessage("未支付的订单查询失败");
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

        RentField rentField = shoppingCartService.selectFieldById(id);

        if(null == rentField){
            resultData.setCode(3);
            resultData.setMessage("按id查询场地信息失败");
        } else {
            resultData.setCode(0);
            resultData.setData(rentField);
        }
        return resultData;
    }

    @RequestMapping("selectgoodsbyid")
    @ResponseBody
    public ResultData selectByGoodsId(Integer id){

        System.out.println(id);
        ResultData resultData = new ResultData();

        RentGoods rentGoods = shoppingCartService.selectGoodsById(id);

        if(null == rentGoods){
            resultData.setCode(3);
            resultData.setMessage("按id查询商品信息失败");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGoods);
        }
        return resultData;
    }

    @RequestMapping("deletebyshoppingid")
    @ResponseBody
    public ResultData deleteByShoppingId(Integer shoppingId, HttpSession session){

        ResultData resultdata = new ResultData();

        System.out.println("============");
        System.out.println(shoppingId);

        RentRegister register = (RentRegister) session.getAttribute("rentRegister");
        System.out.println(register.toString());

        int i = shoppingCartService.deleteByShoppingId(shoppingId);

        if(i > 0){
            resultdata.setCode(0);
            resultdata.setData(i);
        } else {
            resultdata.setCode(1);
            resultdata.setData("删除失败");
        }
        return resultdata;
    }

}
