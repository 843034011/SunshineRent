package com.elife.service.impl;

import com.elife.mapper.RentGoodsMapper;
import com.elife.pojo.RentGoods;
import com.elife.service.GoodsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsManageServiceImpl implements GoodsManageService {

    @Autowired
    RentGoodsMapper rentGoodsMapper;
    @Override
    public List<RentGoods> selectByRegId(Integer regId) {
        return rentGoodsMapper.selectByRegId(regId);
    }

    @Override
    public int updataGood(RentGoods rentGood) {
        return rentGoodsMapper.updataGood(rentGood);
    }


    @Override
    public int insertGood(RentGoods rentGood) {
        return rentGoodsMapper.insertGood(rentGood);
    }

    @Override
    public int deleteById(Integer id) {
        return rentGoodsMapper.deleteById(id);
    }
}
