
package com.elife.controller;

import com.elife.dao.MongoTestDao;
import com.elife.dto.EvaluateResult;
import com.elife.pojo.Pictures;
import com.elife.pojo.remarks;
import com.elife.service.EvaluateResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.peer.PanelPeer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MongoTestC {

    @Autowired
    private MongoTestDao mtdao;

    @Autowired
    EvaluateResultService evaluateResultService;


 /* evaluateResult.setRegId(regId);
        evaluateResult.setUserPicture(userPicture);
        evaluateResult.setUserName(userName);
        evaluateResult.setCreateTime(date);
        evaluateResult.setGrade(grade);
        evaluateResult.setContent(content);
        evaluateResult.setPictureList(pictureList);
        evaluateResult.setFieldId(fieldId);*/
    @PostMapping(value = "/test1")
    public void saveTest(MultipartFile[] file, int grade, String content,int orderId) throws Exception {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HHmmss");
        String date1=simpleDateFormat.format(date);




        System.out.println(file);
        System.out.println(content);
        EvaluateResult evaluateResult=evaluateResultService.saveEvaluateResult( file,grade,content,orderId);
        remarks mgtest = new remarks();
        mgtest.setId( Integer.parseInt(date1));
        mgtest.setReg_id(evaluateResult.getRegId());
        mgtest.setUserImg(evaluateResult.getUserPicture());
        mgtest.setUserName(evaluateResult.getUserName());
        mgtest.setCreateTime(evaluateResult.getCreateTime());
        mgtest.setRemark(evaluateResult.getGrade());
        mgtest.setRemarkContent(evaluateResult.getContent());
        List<Pictures> pictures=new ArrayList<Pictures>();
        Pictures p=new Pictures();
        for(int i=0;i<evaluateResult.getPictureList().size();i++){
            p.setPicture(evaluateResult.getPictureList().get(0));
            pictures.add(p);
        }
        mgtest.setFieldId(evaluateResult.getFieldId());
        mgtest.setPicture(pictures);
        mtdao.saveTest(mgtest);
    }

    @GetMapping(value = "/test2")
    public List<remarks> findTestByRegId() {
        List<remarks> remark= mtdao.findALL();
        System.out.println("mgtest is " + remark);
        return remark;
    }
/*
    @GetMapping(value = "/test3")
    public void updateTest() {
       remarks mgtest = new remarks();
        mgtest.setId(11);

        mtdao.updateTest(mgtest);
    }*/

 /*   @GetMapping(value = "/test4")
    public void deleteTestById() {
        mtdao.deleteTestById(11);
    }*/
}


