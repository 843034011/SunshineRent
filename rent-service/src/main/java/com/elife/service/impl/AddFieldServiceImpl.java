package com.elife.service.impl;

import com.elife.mapper.RentField1Mapper;
import com.elife.mapper.RentFieldMapper;
import com.elife.pojo.RentField;
import com.elife.pojo.RentField1;
import com.elife.service.AddFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * author:zgy
 */
@Service
public class AddFieldServiceImpl implements AddFieldService {

    @Autowired
    RentField1Mapper rentFieldMapper;
    @Override
    public int insertField(RentField1 rentField) {
        return rentFieldMapper.insert(rentField);
    }
}
