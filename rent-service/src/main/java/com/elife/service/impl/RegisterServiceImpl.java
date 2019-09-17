package com.elife.service.impl;

import com.elife.mapper.RentRegisterMapper;
import com.elife.pojo.RentRegister;
import com.elife.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RentRegisterMapper rentRegisterMapper;

    @Override
    public RentRegister selectRegisterByTelephone(String telephone) {
        return rentRegisterMapper.selectByTelephone(telephone);
    }

    @Override
    public int insertRegister(String telephone, String password, String time) {
        return rentRegisterMapper.insertRegister(telephone, password, time);
    }
}
