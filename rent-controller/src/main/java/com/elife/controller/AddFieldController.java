package com.elife.controller;

import com.elife.pojo.FieldPicture;
import com.elife.pojo.RentField;
import com.elife.service.QiniuService;
import com.elife.service.impl.AddFieldServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * author:zgy
 */
@Controller
@RequestMapping("addField")
public class AddFieldController {


    @Autowired
    private QiniuService qiniuService;

    @Autowired
    AddFieldServiceImpl AddFiledService;

    @RequestMapping("showAddField")
    public String showAddField(){
        return "uploadfield";
    }

    @RequestMapping("insertRendField")
    @ResponseBody
    public ResultData insertRendField(MultipartFile[] file, String fieldName,
                                      String fieldType,Integer fieldArea,
                                      String fieldInfo, BigDecimal fieldDeposit,
                                      BigDecimal fieldHourprice,BigDecimal fieldDayprice,
                                      BigDecimal fieldWeekprice,BigDecimal fieldMonthprice,
                                      String fieldAddress,BigDecimal fieldGrade,
                                      Integer regId, Integer fieldVolume) throws IOException {

        System.out.println("===================");
        System.out.println(fieldVolume);
        System.out.println("===================");
        ResultData resultData = new ResultData();
        FieldPicture fieldPicture = new FieldPicture();
        RentField rentField = new RentField();

        rentField.setFieldName(fieldName);
        rentField.setFieldType(fieldType);
        rentField.setFieldInfo(fieldInfo);
        rentField.setFieldArea(fieldArea);
        rentField.setFieldDeposit(fieldDeposit);
        rentField.setFieldHourprice(fieldHourprice);
        rentField.setFieldDayprice(fieldDayprice);
        rentField.setFieldWeekprice(fieldWeekprice);
        rentField.setFieldMonthprice(fieldMonthprice);
        rentField.setFieldAddress(fieldAddress);
        rentField.setFieldGrade(fieldGrade);
        rentField.setRentCount(0);
        rentField.setRegId(regId);
        rentField.setFieldVolume(fieldVolume);

        int addFieldNum = AddFiledService.insertField(rentField);
        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                MultipartFile filex = file[i];
                String fileUrl = qiniuService.saveImage(filex);
                fieldPicture.setFieldPicture(fileUrl);
                fieldPicture.setFieldId(rentField.getId());
                AddFiledService.insertPicture(fieldPicture);
            }
        } else {
            System.out.println("没有上传图片！");
        }
        if (addFieldNum == 0 ) {
            resultData.setCode(5);
            resultData.setMessage("添加失败");
        } else {
            resultData.setCode(0);
            resultData.setData(addFieldNum);
        }
        return resultData;
    }


}
