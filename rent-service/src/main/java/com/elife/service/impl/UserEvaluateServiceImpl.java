package com.elife.service.impl;

import com.elife.mapper.UserEvaluateMapper;
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
    public int insertUserEvaluate(int grade, String content, int isAnonymous, String time, int regid, int orderid) {
        int result = userEvaluateMapper.insertUserEvaluate(grade, content, isAnonymous, time, regid, orderid);
        System.out.println("result = " + result);
        return result;
    }
}
