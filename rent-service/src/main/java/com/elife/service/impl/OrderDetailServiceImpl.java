package com.elife.service.impl;

import com.elife.mapper.OrderDetailMapper;
import com.elife.pojo.OrderDetail;
import com.elife.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailMapper orderDetailMapper;

    @Override
    public OrderDetail selectById(Integer id) {
        return orderDetailMapper.selectByPrimaryKey(id);
    }
}
