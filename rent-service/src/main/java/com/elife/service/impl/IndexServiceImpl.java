package com.elife.service.impl;

import com.elife.mapper.RentFieldMapper;
import com.elife.mapper.RentGoodsMapper;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {


    @Autowired
    RentFieldMapper rentFieldMapper;
    @Autowired
    RentGoodsMapper rentGoodsMapper;

    @Override
    public List<RentField> selectAllFields() {
        return rentFieldMapper.selectAllFields();
    }

    @Override
    public List<RentGoods> selectAllGoods() {
        return rentGoodsMapper.selectAllGoods();
    }
}
