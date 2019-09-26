package com.elife.service;

import com.elife.pojo.RentField1;
import org.springframework.stereotype.Service;

/**
 * author:zgy
 */
@Service
public interface AddFieldService {

    int insertField(RentField1 rentField);
}
