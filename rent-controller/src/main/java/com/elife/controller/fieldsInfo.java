package com.elife.controller;
import com.elife.pojo.*;
import com.elife.service.impl.fieldsServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * author:yy
 */
@Controller
@RequestMapping("fields")
/*所有场地*/
public class fieldsInfo {
    @Autowired
    fieldsServiceImpl fieldsService;

    @RequestMapping("showallfields")
    @ResponseBody
    public ResultData selectAllBook(HttpSession session){
        List<RentField> rentFieldList = fieldsService.selectAllFields();
        ResultData resultData = new ResultData();
        if(null == rentFieldList || rentFieldList.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentFieldList);

        }
        return resultData;
    }

@RequestMapping("orderbyprice")
    @ResponseBody
    public ResultData orderByPrice(){
    List<RentField> orderlist = fieldsService.orderByPrice();
    ResultData resultData = new ResultData();
    if(null == orderlist || orderlist.size() ==0) {
        resultData.setCode(3);
        resultData.setMessage("查无数据");
    } else {
        resultData.setCode(0);
        resultData.setData(orderlist);
    }
    return resultData;

}

    @RequestMapping("selectnametype")
    @ResponseBody
    public ResultData selectByNameType(String nametype,String name,String order,Integer renshumin,Integer renshumax,String quyu){

        List<RentField> orderlist = fieldsService.selectByNameType(nametype,name,order,renshumin,renshumax,quyu);
        ResultData resultData = new ResultData();
        if(null == orderlist || orderlist.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderlist);
        }
        return resultData;

    }


    @RequestMapping("selectnametypegoods")
    @ResponseBody
    public ResultData selectByNameTypegoods(String nametype,String name,String order,Integer renshumin,Integer renshumax,String quyu){

        List<RentGoods> orderlist = fieldsService.selectByNameTypegoods(nametype,name,order,renshumin,renshumax,quyu);
        ResultData resultData = new ResultData();
        if(null == orderlist || orderlist.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderlist);
        }
        return resultData;

    }

  /*@RequestMapping("insertshoppingcart")
    @ResponseBody
    public int insertFields(Integer fieldid, HttpSession session){
      RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
      int id=rentRegister.getRegId();
     UserShoppingcart userShoppingcart=new UserShoppingcart();
      System.out.println(fieldid);

        System.out.println(id);
        userShoppingcart.setFieldId(fieldid);
        userShoppingcart.setRegId(id);
        fieldsService.insertFields(userShoppingcart);
        return 0;
    }*/


    @RequestMapping("shoppingcart")
    @ResponseBody
    public int shoppingCart(HttpSession session){
        RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        int id=rentRegister.getRegId();
        return id;
    }

    @RequestMapping("jieshoudate")
    @ResponseBody
    public ResultData jieshouDate(String startTime,String endTime){
        System.out.println("+++++++++++++++++++++++++++++++++++++++"+startTime);

         Date startTime1 = new Date(startTime);
         Date endTime1=new Date(endTime);
        System.out.println("+++++++++++1111+"+startTime1);
        List<UserOrder> userOrders=fieldsService.selectCannotOrder(startTime1,endTime1);
        System.out.println(userOrders);
        ResultData resultData = new ResultData();
        if(null == userOrders || userOrders.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(userOrders);
        }
        return resultData;

    }

   /* 展示所有商品*/
    @RequestMapping("showallgoods")
    @ResponseBody
    public ResultData selectAllProducts(){
        List<RentGoods> rentGoods = fieldsService.showAllGoods();
        ResultData resultData = new ResultData();
        if(null == rentGoods || rentGoods.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGoods);

        }
        return resultData;
    }


    @RequestMapping("allshopping")
    @ResponseBody
    public ResultData selectAll(){
        List<UserShoppingcart>userShoppingcarts=fieldsService.selectall();
        System.out.println(userShoppingcarts);
        ResultData resultData = new ResultData();
        if(null == userShoppingcarts || userShoppingcarts.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(userShoppingcarts);
        }
        return resultData;

    }


    @RequestMapping("allorders")
    @ResponseBody
    public ResultData selectAllOrders(){
        List<OrderDetail>orderDetails=fieldsService.selectAllOrders();
        System.out.println(orderDetails);
        ResultData resultData = new ResultData();
        if(null == orderDetails || orderDetails.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(orderDetails);
        }
        return resultData;

    }


/*加入购物车*/
    @RequestMapping("insertshoppingcart")
    @ResponseBody
    public ResultData insertFields(Integer fieldid,Integer masterId,Integer reid,Integer goodsid){
        ResultData resultData = new ResultData();
        System.out.println("=================================="+masterId+reid);
   /*     RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        Integer id=rentRegister.getRegId();//登录人*/
        if(reid==masterId){
            resultData.setCode(9);
            return resultData;
        }else{
            UserShoppingcart userShoppingcart=new UserShoppingcart();
            System.out.println(fieldid);
            userShoppingcart.setFieldId(fieldid);
            userShoppingcart.setRegId(reid);
            fieldsService.insertFields(userShoppingcart);
            resultData.setCode(0);
            return resultData;
        }


    }

    /*加入购物车*/
    @RequestMapping("insertshoppingcart1")
    @ResponseBody
    public ResultData insertFields1(Integer fieldid,Integer masterId,Integer reid,Integer goodsid){
        ResultData resultData = new ResultData();
        System.out.println("=================================="+fieldid);
   /*     RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        Integer id=rentRegister.getRegId();//登录人*/
        if(reid==masterId){
            resultData.setCode(9);
            return resultData;
        }else{
            UserShoppingcart userShoppingcart=new UserShoppingcart();
            System.out.println(fieldid);
            userShoppingcart.setGoodsId(fieldid);
            userShoppingcart.setRegId(reid);
            fieldsService.insertGoods(userShoppingcart);
            resultData.setCode(0);
            return resultData;
        }


    }

}
