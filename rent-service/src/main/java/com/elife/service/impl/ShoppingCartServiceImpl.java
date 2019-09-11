package com.elife.service.impl;

import com.elife.mapper.RentFieldMapper;
import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.RentField;
import com.elife.pojo.UserOrder;
import com.elife.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    RentFieldMapper rentFieldMapper;

    @Override
    public List<UserOrder> selectAllUserOrderUnpaid() {
        List<UserOrder> userOrders =  userOrderMapper.selectAllUserOrderUnpaid();
        return userOrders;
    }

    @Override
    public RentField selectFieldById(Integer id) {
        RentField rentField = rentFieldMapper.selectByPrimaryKey(id);
        return rentField;
    }
}
