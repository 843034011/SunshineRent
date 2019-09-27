package com.elife.service.impl;

import com.elife.mapper.FieldPictureMapper;
import com.elife.mapper.RentFieldMapper;
import com.elife.pojo.FieldPicture;
import com.elife.pojo.RentField;
import com.elife.service.AddFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * author:zgy
 */
@Service
public class AddFieldServiceImpl implements AddFieldService {

    @Autowired
    RentFieldMapper rentFieldMapper;
    @Autowired
    FieldPictureMapper fieldPictureMapper;

    @Override
    public int insertField(RentField rentField) {
        return rentFieldMapper.insert(rentField);
    }

    @Override
    public int insertPicture(FieldPicture fieldPicture) {
        return fieldPictureMapper.insert(fieldPicture);
    }
}
