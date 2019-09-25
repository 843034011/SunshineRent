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

    public ResultData selectOrderInfo(int orderId){
        ResultData resultData = new ResultData();

        UserOrder userOrder = userOrderMapper.selectById(orderId);
        if(userOrder.getFieldId() != null && userOrder.getGoodsId() == null){
            RentField rentField = rentFieldMapper.selectByPrimaryKey(userOrder.getFieldId());
            RentUser rentUser = rentUserMapper.selectById(rentField.getRegId());
            List<FieldPicture> fieldPictureList = fieldPictureMapper.selectByFieldId(rentField.getId());

            FieldOrderInfo fieldOrderInfo = new FieldOrderInfo();
            fieldOrderInfo.setSamplePicture(fieldPictureList.get(0).getFieldPicture());
            System.out.println("picture = " + fieldOrderInfo.getSamplePicture());
            fieldOrderInfo.setFieldName(rentField.getFieldName());
            fieldOrderInfo.setFieldType(rentField.getFieldType());
            fieldOrderInfo.setFieldGrade(rentField.getFieldGrade());
            fieldOrderInfo.setFieldCount((rentField.getRentCount()));
            fieldOrderInfo.setFieldDeposit(rentField.getFieldDeposit());
            fieldOrderInfo.setFieldDayPrice(rentField.getFieldDayprice());
            fieldOrderInfo.setFieldWeekPrice(rentField.getFieldWeekprice());
            fieldOrderInfo.setFieldAddress(rentField.getFieldAddress());
            fieldOrderInfo.setMasterName(rentUser.getUserRealname());
            fieldOrderInfo.setMasterPhone(rentUser.getUserPhone());


            if(null == fieldOrderInfo ) {
                resultData.setCode(3);
                resultData.setMessage("查无数据");
            } else {
                resultData.setCode(0);
                resultData.setData(fieldOrderInfo);
            }
        }else{
            RentGoods rentGoods = rentGoodsMapper.selectById(userOrder.getGoodsId());
            if(null == rentGoods ) {
                resultData.setCode(3);
                resultData.setMessage("查无数据");
            } else {
                resultData.setCode(0);
                resultData.setData(rentGoods);
            }
        }
        return resultData;
    }

}
