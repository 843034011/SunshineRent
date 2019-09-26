package com.elife.service.impl;

import com.elife.mapper.RentUserMapper;
import com.elife.pojo.RentUser;
import com.elife.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentUserServiceImpl implements RentUserService {

    @Autowired
    RentUserMapper rentUserMapper;

    @Override
    public RentUser selectById(Integer userId) {
        return rentUserMapper.selectById(userId);
    }
}
