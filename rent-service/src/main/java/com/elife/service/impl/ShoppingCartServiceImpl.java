package com.elife.service.impl;

import com.elife.dto.ShoppingCartResult;
import com.elife.mapper.RentFieldMapper;
import com.elife.mapper.RentGoodsMapper;
import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
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

    @Autowired
    RentGoodsMapper rentGoodsMapper;

    @Override
    public List<UserOrder> selectAllUserOrderUnpaid() {
        List<UserOrder> userOrders =  userOrderMapper.selectAllUserOrderUnpaid();
        return userOrders;
    }

    @Override
    public RentField selectFieldById(Integer id) {
        RentField rentField = rentFieldMapper.selectFieldWithPictureById(id);
        return rentField;
    }

    @Override
    public RentGoods selectGoodsById(Integer id) {
        RentGoods rentGoods = rentGoodsMapper.selectGoodsWithPictureById(id);
        return rentGoods;
    }
}
