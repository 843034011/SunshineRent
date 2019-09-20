package com.elife.service.impl;

import com.elife.mapper.RentFieldMapper;
import com.elife.mapper.RentGoodsMapper;
import com.elife.mapper.UserOrderMapper;
import com.elife.mapper.UserShoppingcartMapper;
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

    @Autowired
    private UserShoppingcartMapper userShoppingcartMapper;
    @Autowired
    private RentFieldMapper rentFieldMapper;
    @Autowired
    private RentGoodsMapper rentGoodsMapper;



    @Override
    public List<UserOrder> selectAllUserOrderUnpaidById(Integer regId) {
        List<UserOrder> userOrders =  userShoppingcartMapper.selectAllUserOrderUnpaidById(regId);
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
