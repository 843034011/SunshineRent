package com.elife.service.impl;

import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.UserOrder;
import com.elife.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author byf
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrder> selectAllUserOrder() {
        List<UserOrder> userOrders = userOrderMapper.selectAllUserOrder();
        System.out.println(userOrders.size());
        return userOrders;
    }

    @Override
    public List<UserOrder> selectFieldOrderDateUnEvaluate(Integer num) {
        List<UserOrder> userOrders = userOrderMapper.selectFieldOrderDateUnEvaluate(num);
        return userOrders;
    }

    @Override
    public List<UserOrder> selectGoodsOrderDateUnEvaluate(Integer num) {
        List<UserOrder> userOrders = userOrderMapper.selectGoodsOrderDateUnEvaluate(num);
        return userOrders;
    }

    @Override
    public List<UserOrder> selectAllByRentId(int rentId) {
        return userOrderMapper.selectAllByRentId(rentId);
    }

    @Override
    public UserOrder selectByOrderId(int orderId) {
        return userOrderMapper.selectById(orderId);
    }
}
