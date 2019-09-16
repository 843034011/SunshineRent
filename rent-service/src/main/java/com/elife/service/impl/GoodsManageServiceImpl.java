package com.elife.service.impl;

import com.elife.mapper.RentGoodsMapper;
import com.elife.pojo.RentGoods;
import com.elife.service.GoodsManageService;
/*import org.junit.jupiter.api.Test;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsManageServiceImpl implements GoodsManageService {
    @Autowired
    RentGoodsMapper rentGoodsMapper;
    @Override
    public List<RentGoods> selectByRegId(Integer regId) {
//        return rentGoodsMapper.selectByExample();
        List<RentGoods> rentGoods = rentGoodsMapper.selectByRegId(regId);
        System.out.println(rentGoods.size());
        return rentGoods;
    }
}
