package com.elife.service.impl;

import com.elife.mapper.EvaluatePictureMapper;
import com.elife.mapper.RentFieldMapper;
import com.elife.pojo.RentField;
import com.elife.service.fieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:yy
 */
@Service
public class fieldsServiceImpl implements fieldsService {
    @Autowired
    RentFieldMapper rentFieldMapper;

    @Override
    public List<RentField> selectAllFields() {

        List<RentField> list=rentFieldMapper.selectAllFields();
        System.out.println("+++=================================================");
        System.out.println(list.size());
        return list;
    }

    @Override
    public List<RentField> orderByPrice() {
        List<RentField> list2=rentFieldMapper.orderByPrice();
        System.out.println("+++=================================================");
        System.out.println(list2.size());
        return list2;
    }

    @Override
    public List<RentField> selectByNameType(String NameType) {
        List<RentField> list3=rentFieldMapper.selectByNameType(NameType);
        System.out.println("+++=================================================");
        System.out.println(list3.size());
        return list3;
    }


}
