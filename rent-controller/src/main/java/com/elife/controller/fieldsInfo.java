package com.elife.controller;
import com.elife.pojo.RentRegister;
import com.elife.pojo.RentField;
import com.elife.pojo.UserShoppingcart;
import com.elife.service.impl.fieldsServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * author:yy
 */
@Controller
@RequestMapping("fields")

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
    public ResultData selectByNameType(String nametype){
        List<RentField> orderlist = fieldsService.selectByNameType(nametype);
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

  @RequestMapping("insertshoppingcart")
    @ResponseBody
    public int insertFields(Integer fieldid, HttpSession session){
     UserShoppingcart userShoppingcart=new UserShoppingcart();
      System.out.println(fieldid);
        RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        int id=rentRegister.getRegId();
        System.out.println(id);
        userShoppingcart.setFieldId(fieldid);
        userShoppingcart.setRegId(id);
        fieldsService.insertFields(userShoppingcart);
        return 0;
    }


    @RequestMapping("shoppingcart")
    @ResponseBody
    public int shoppingCart(HttpSession session){
        RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        int id=rentRegister.getRegId();
        return id;
    }


   /* @RequestMapping("toshoppingcart")
    public String toShoppingCart(int fieldid){

        return "shoppingcart";
    }*/

}
