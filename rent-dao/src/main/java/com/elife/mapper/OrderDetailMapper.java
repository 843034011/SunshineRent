package com.elife.mapper;

import com.elife.dto.OrderResult;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.OrderDetailExample;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailMapper {
    int countByExample(OrderDetailExample example);

    int deleteByExample(OrderDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    List<OrderDetail> selectByExample(OrderDetailExample example);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByExample(@Param("record") OrderDetail record, @Param("example") OrderDetailExample example);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);

    List<OrderDetail> selectByOrderId(Integer orderId);

    List<OrderDetail> selectFieldOrderDateUnEvaluate(Integer num);

    List<OrderDetail> selectGoodsOrderDateUnEvaluate(Integer num);

    int insertOrderDetail(OrderResult orderResult);

    int insertOrderDetailField(@Param("orderResult") OrderResult orderResult,@Param("rentField") RentField rentField,@Param("order") String orderId);

    int insertOrderDetailGoods(@Param("orderResult") OrderResult orderResult,@Param("rentGoods") RentGoods rentGoods,@Param("order") String orderId);
}