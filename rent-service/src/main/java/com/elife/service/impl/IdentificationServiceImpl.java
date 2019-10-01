package com.elife.service.impl;

import com.elife.dto.UserResult;
import com.elife.mapper.RentUserMapper;
import com.elife.service.IdentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentificationServiceImpl implements IdentificationService {

    @Autowired
    RentUserMapper rentUserMapper;

    @Override
    public int updateUser(UserResult userResult, String imgUrl) {
        return rentUserMapper.updateUser(userResult,imgUrl);
    }
}
