package com.elife.service;

import com.elife.pojo.RentField;
import com.elife.pojo.UserOrder;
import com.elife.pojo.UserShoppingcart;

import java.util.Date;
import java.util.List;

/**
 * author:yy
 */

public interface fieldsService {
   List<RentField> selectAllFields();

   List<RentField> orderByPrice();

   List<RentField>selectByNameType(String NameType,String name,String order,Integer renshumin,Integer renshumax);

   int insertFields(UserShoppingcart userShoppingcart);

   // yy 前台获取起止日期查询不能租的
   List<UserOrder> selectCannotOrder(Date startTime, Date endTime);

   //UserShoppingcart
   List<UserShoppingcart> selectall();
}
