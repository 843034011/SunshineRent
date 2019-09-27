package com.elife.service;

import com.elife.pojo.FieldPicture;
import com.elife.pojo.RentField;
import org.springframework.stereotype.Service;

/**
 * author:zgy
 */
@Service
public interface AddFieldService {

    int insertField(RentField rentField);

    int insertPicture(FieldPicture fieldPicture);


}
