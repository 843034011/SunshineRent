package com.elife.service.impl;

import com.elife.mapper.RentGoodsMapper;
import com.elife.pojo.RentGoods;
import com.elife.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GoodsManageServiceImpl implements GoodsManageService {
    @Autowired
    RentGoodsMapper rentGoodsMapper;
    @Override
    public List<RentGoods> selectByExample(Integer regId) {
//        return rentGoodsMapper.selectByExample();
        return null;
    }
}
