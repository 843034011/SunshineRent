package com.elife.service;

import com.elife.dto.FieldOrderInfo;
import com.elife.mapper.*;
import com.elife.pojo.*;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowOrderInfoService {

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    RentGoodsMapper rentGoodsMapper;

    @Autowired
    RentFieldMapper rentFieldMapper;

    @Autowired
    RentUserMapper rentUserMapper;

    @Autowired
    FieldPictureMapper fieldPictureMapper;

    @Autowired
    GoodsPictureMapper goodsPictureMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;
    public int selectOrderInfo(String orderNo){

        int result = 0;
        List<OrderDetail> orderDetailList = orderDetailMapper.selectByOrderNo(orderNo);
        for(int i=0; i<orderDetailList.size();i++){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail = orderDetailList.get(i);
            if(orderDetail.getFieldId() != null && orderDetail.getGoodsId() == null){
                if(orderDetail.getExtra3() ==null ){
                    UserOrder userOrder = userOrderMapper.selectByOrderNo(orderNo);
                    RentField rentField = rentFieldMapper.selectByPrimaryKey(orderDetail.getFieldId());
                    RentUser rentUser = rentUserMapper.selectById(rentField.getRegId());
                    List<FieldPicture> fieldPictureList = fieldPictureMapper.selectByFieldId(rentField.getId());

                    orderDetail.setOrderId(userOrder.getId());
                    orderDetail.setProductType(rentField.getFieldType());
                    orderDetail.setMasterId(rentUser.getUserId());
                    orderDetail.setMasterPhone(rentUser.getUserPhone());
                    orderDetail.setExtra3(fieldPictureList.get(0).getFieldPicture());

                    result = orderDetailMapper.updateByPrimaryKey(orderDetail);
                }else{
                    result = 1;
                }
            }else {
                if(orderDetail.getExtra3() ==  null){
                    UserOrder userOrder = userOrderMapper.selectByOrderNo(orderNo);
                    RentGoods rentGoods = rentGoodsMapper.selectById(orderDetail.getGoodsId());
                    RentUser rentUser = rentUserMapper.selectById(rentGoods.getRegId());
                    List<GoodsPicture> goodsPictureList = goodsPictureMapper.selectByGoodsId(rentGoods.getId());

                    orderDetail.setOrderId(userOrder.getId());
                    orderDetail.setProductType(rentGoods.getGoodsType());
                    orderDetail.setProductModel(rentGoods.getGoodsModel());
                    orderDetail.setMasterId(rentUser.getUserId());;
                    orderDetail.setMasterPhone(rentUser.getUserPhone());
                    orderDetail.setExtra3(goodsPictureList.get(0).getGoodsPicture());

                    result = orderDetailMapper.updateByPrimaryKey(orderDetail);
                }else{
                    result = 1;
                }
            }

        }
        return result;
    }
}
