package com.elife.service;

import com.elife.pojo.RentUser;
import org.springframework.stereotype.Service;

@Service
public interface RentUserService {

    RentUser selectById(Integer userId);

}
