package com.elife.service.impl;

import com.elife.mapper.*;
import com.elife.pojo.*;
import com.elife.service.fieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author:yy
 */
@Service
public class fieldsServiceImpl implements fieldsService {
    @Autowired
    RentFieldMapper rentFieldMapper;
    @Autowired
    UserShoppingcartMapper userShoppingcartMapper;

    @Autowired
    OrderDetailMapper userOrderMapper;

    @Autowired
    RentGoodsMapper rentGoodsMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public List<RentField> selectAllFields() {

        List<RentField> list=rentFieldMapper.selectAllFields();
        System.out.println("+++=================================================");
        System.out.println(list.size());
        return list;
    }

    @Override
    public List<RentField> orderByPrice() {
        List<RentField> list2=rentFieldMapper.orderByPrice();
        System.out.println("+++=================================================");
        System.out.println(list2.size());
        return list2;
    }

    @Override
    public List<RentField> selectByNameType(String NameType,String name,String order,Integer renshumin,Integer renshumax,String quyu) {
        List<RentField> list3=rentFieldMapper.selectByNameType(NameType,name,order,renshumin,renshumax,quyu);
        System.out.println("+++=================================================");
        System.out.println(list3.size());
        return list3;
    }

    @Override
    public List<RentGoods> selectByNameTypegoods(String NameType,String name,String order,Integer renshumin,Integer renshumax,String quyu) {
        List<RentGoods> list3=rentGoodsMapper.selectByNameTypegoods(NameType,name,order,renshumin,renshumax,quyu);
        System.out.println("+++=================================================");
        System.out.println(list3.size());
        return list3;
    }

    @Override
    public int insertFields(UserShoppingcart userShoppingcart) {
        int num=userShoppingcartMapper.insertFields(userShoppingcart);
        System.out.println(num);
                return 0;
    }

    @Override
    public List<UserOrder> selectCannotOrder(Date startTime, Date endTime) {
        List<UserOrder> userOrders= userOrderMapper.selectCannotOrder(startTime,endTime);
        return userOrders;
    }

    @Override
    public List<UserShoppingcart> selectall() {
        List<UserShoppingcart>userShoppingcarts=userShoppingcartMapper.selectall();
        return userShoppingcarts;
    }

    @Override
    public List<OrderDetail> selectAllOrders() {
        List<OrderDetail>orderDetails=orderDetailMapper.selectAllOrders();
        return orderDetails;
    }


    /* 商品相关*/
    public List<RentGoods> showAllGoods(){
        List<RentGoods> showAllGoods=rentGoodsMapper.showAllGoods();
        return showAllGoods;
    }




}
