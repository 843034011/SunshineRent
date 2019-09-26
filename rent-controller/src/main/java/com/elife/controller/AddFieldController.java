package com.elife.controller;



import com.elife.service.impl.AddFieldServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * author:zgy
 */
@Controller
@RequestMapping("addField")
public class AddFieldController {


    @Autowired
    AddFieldServiceImpl AddFiledService;

    @RequestMapping("showAddField")
    public String showAddField(){
        return "uploadfield";
    }

    @RequestMapping("insertRendField")
    @ResponseBody
    public ResultData insertRendField(String fieldName,String fieldType,Integer fieldArea){
        System.out.println("==========================");
        System.out.println(fieldName);
        System.out.println(fieldType);
        System.out.println(fieldArea);
        System.out.println("==========================");
//        int rentFieldNum = AddFiledService.insertField(rentField);
        ResultData resultData = new ResultData();
//        if(0 == rentFieldNum ) {
//            resultData.setCode(3);
//            resultData.setMessage("增加失败");
//        } else {
//            resultData.setCode(0);
//            resultData.setData(rentFieldNum);
//        }
        return resultData;
    }


}
