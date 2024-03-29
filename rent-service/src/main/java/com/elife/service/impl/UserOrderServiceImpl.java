package com.elife.service.impl;

import com.elife.dto.TotalOrderResult;
import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.UserOrder;
import com.elife.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
        for (int i = 0; i < userOrders.size(); i++) {
            System.out.println(userOrders.get(i).toString());
        }
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

    @Override
    public int updateByPrimaryKey(UserOrder record) {
        return userOrderMapper.updateByPrimaryKey(record);
    }

    @Override
    public int insertOrder(TotalOrderResult totalOrderResult) {
        return userOrderMapper.insertOrder(totalOrderResult);
    }
}
