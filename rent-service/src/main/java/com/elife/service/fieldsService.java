package com.elife.service;

import com.elife.pojo.RentField;
import com.elife.pojo.UserShoppingcart;

import java.util.List;

/**
 * author:yy
 */

public interface fieldsService {
   List<RentField> selectAllFields();

   List<RentField> orderByPrice();

   List<RentField>selectByNameType(String NameType);

   int insertFields(UserShoppingcart userShoppingcart);
}
