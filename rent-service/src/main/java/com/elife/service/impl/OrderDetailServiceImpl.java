package com.elife.service.impl;

import com.elife.dto.OrderResult;
import com.elife.mapper.OrderDetailMapper;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail selectById(Integer id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<OrderDetail> selectFieldOrderDateUnEvaluate(Integer num) {
        List<OrderDetail> orderDetails = orderDetailMapper.selectFieldOrderDateUnEvaluate(num);
        return orderDetails;
    }

    @Override
    public List<OrderDetail> selectGoodsOrderDateUnEvaluate(Integer num) {
        List<OrderDetail> orderDetails = orderDetailMapper.selectGoodsOrderDateUnEvaluate(num);
        return orderDetails;
    }

    @Override
    public int insertOrderDetailField(OrderResult orderResult, RentField rentField, String orderId) {
        return orderDetailMapper.insertOrderDetailField(orderResult,rentField,orderId);
    }

    @Override
    public int insertOrderDetailGoods(OrderResult orderResult, RentGoods rentGoods, String orderId) {
        return orderDetailMapper.insertOrderDetailGoods(orderResult,rentGoods,orderId);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKey(orderDetail);
    }

}
