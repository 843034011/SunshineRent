package com.elife.service.impl;

import com.elife.mapper.OrderDetailMapper;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.UserOrder;
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
}
