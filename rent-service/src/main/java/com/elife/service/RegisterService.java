package com.elife.service;

import com.elife.pojo.RentRegister;

public interface RegisterService {
     RentRegister selectRegisterByTelephone(String telephone);
}
