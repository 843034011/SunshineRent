package com.elife.service.impl;


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

/**
 * @author llb
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final UserOrderMapper userOrderMapper;
    private final RentFieldMapper rentFieldMapper;
    private final RentGoodsMapper rentGoodsMapper;

    @Autowired
    public ShoppingCartServiceImpl(UserOrderMapper userOrderMapper, RentFieldMapper rentFieldMapper, RentGoodsMapper rentGoodsMapper) {
        this.userOrderMapper = userOrderMapper;
        this.rentFieldMapper = rentFieldMapper;
        this.rentGoodsMapper = rentGoodsMapper;
    }

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
