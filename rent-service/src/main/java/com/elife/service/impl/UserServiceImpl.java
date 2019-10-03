package com.elife.service.impl;

import com.elife.mapper.RentUserMapper;
import com.elife.pojo.RentUser;
import com.elife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RentUserMapper rentUserMapper;

    @Override
    public int insertFirst(Integer id) {
        return rentUserMapper.insertFirst(id);
    }

    @Override
    public RentUser selectByTelephone(Integer id) {
        return rentUserMapper.selectById(id);
    }
}
