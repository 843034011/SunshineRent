package com.elife.service.impl;

import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.UserOrder;
import com.elife.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserOrderServiceImpl  implements UserOrderService {
    @Autowired
    UserOrderMapper userOrderMapper;

    @Override
    public List<UserOrder> selectAllUserOrder() {
        List<UserOrder> userOrders = userOrderMapper.selectAllUserOrder();
        System.out.println(userOrders.size());
        return userOrders;
    }
}
