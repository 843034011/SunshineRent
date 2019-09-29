package com.elife.service;

import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zgy
 */
@Service
public interface IndexService {

    List<RentField> selectOrderByGrade(String fieldType);

    List<RentGoods> selectAllGoods();

}
