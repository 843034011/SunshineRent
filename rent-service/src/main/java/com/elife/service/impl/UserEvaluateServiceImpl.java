package com.elife.service.impl;

import com.elife.mapper.UserEvaluateMapper;
import com.elife.pojo.UserEvaluate;
import com.elife.service.UserEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author byf
 */
@Service
public class UserEvaluateServiceImpl implements UserEvaluateService {

    @Autowired
    UserEvaluateMapper userEvaluateMapper;

    @Override
    public int insertUserEvaluate(UserEvaluate userEvaluate) {
        int result = userEvaluateMapper.insertUserEvaluate(userEvaluate);
        System.out.println("result = " + result);
        return result;
    }
}
