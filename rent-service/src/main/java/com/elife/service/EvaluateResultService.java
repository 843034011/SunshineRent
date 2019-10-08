package com.elife.service;

import com.elife.dto.EvaluateResult;
import com.elife.mapper.OrderDetailMapper;
import com.elife.mapper.RentUserMapper;
import com.elife.mapper.UserOrderMapper;
import com.elife.pojo.EvaluatePicture;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.RentUser;
import com.elife.pojo.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EvaluateResultService {

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    RentUserMapper rentUserMapper;

    @Autowired
    UserOrderMapper userOrderMapper;

    @Autowired
    OrderDetailMapper orderDetailMapper;

    public EvaluateResult saveEvaluateResult(MultipartFile[] file, int grade, String content,Integer detailId) throws IOException {
        System.out.println("============" + detailId + "=================");

        EvaluateResult evaluateResult = new EvaluateResult();

        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(detailId);
        UserOrder  userOrder = userOrderMapper.selectById(orderDetail.getOrderId());
        int regId = userOrder.getRentId();

        RentUser rentUser = rentUserMapper.selectById(regId);
        String userPicture = rentUser.getUserPicture();
        String userName = rentUser.getUserNickname();

        List<String> pictureList = new ArrayList<>();
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                MultipartFile filex = file[i];
                // 保存文件
                String fileUrl = qiniuService.saveImage(filex);
                System.out.println(fileUrl);
                pictureList.add(fileUrl);
            }
        } else {
            System.out.println("没有上传图片！");
        }

        Date date = new Date();

        evaluateResult.setRegId(regId);
        evaluateResult.setUserPicture(userPicture);
        evaluateResult.setUserName(userName);
        evaluateResult.setCreateTime(date);
        evaluateResult.setGrade(grade);
        evaluateResult.setContent(content);
        evaluateResult.setPictureList(pictureList);
        Integer fieldId;
        if( orderDetail.getFieldId() != null){
            fieldId = orderDetail.getFieldId();
            evaluateResult.setFieldId(fieldId);
        }
        Integer goodsId;
        if( orderDetail.getGoodsId() != null){
            goodsId = orderDetail.getGoodsId();
            evaluateResult.setGoodsId(goodsId);
        }

        return evaluateResult;
    }

}
