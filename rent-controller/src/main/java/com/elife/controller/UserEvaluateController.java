package com.elife.controller;

import com.elife.dto.EvaluateResult;
import com.elife.pojo.EvaluatePicture;
import com.elife.pojo.UserEvaluate;
import com.elife.service.EvaluatePictureService;
import com.elife.service.EvaluateResultService;
import com.elife.service.QiniuService;
import com.elife.service.UserEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * author:byf
 */
@Controller
@RequestMapping("evaluate")
public class UserEvaluateController {

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    UserEvaluateService userEvaluateService;

    @Autowired
    EvaluatePictureService evaluatePictureService;

    @Autowired
    EvaluateResultService evaluateResultService;

    @RequestMapping("evaluateHTML")
    public String evaluateHTML() {
        return "user_evaluate";
    }

    @ResponseBody
    @RequestMapping("evaluateData")
    public String insertUserEvaluate(MultipartFile[] file, int grade, String content, HttpServletRequest request) throws IOException {

        UserEvaluate userEvaluate = new UserEvaluate();
        userEvaluate.setEvaGrade(grade);
        userEvaluate.setEvaContent(content);
        byte isAnonymous = 1;
        userEvaluate.setIsAnonymous(isAnonymous);
        Date date = new Date();
        userEvaluate.setCreateTime(date);
        userEvaluate.setRegId(1);
        userEvaluate.setOrderId(9);
        userEvaluateService.insertUserEvaluate(userEvaluate);

        int evaid = userEvaluate.getId();
        System.out.println("evaid = " + evaid);

        if (file != null && file.length > 0) {
            for (int i = 0; i < file.length; i++) {
                MultipartFile filex = file[i];
                // 保存文件
                EvaluatePicture evaluatePicture = new EvaluatePicture();
                String fileUrl = qiniuService.saveImage(filex);
                System.out.println(fileUrl);
                evaluatePicture.setEvaPicture(fileUrl);
                System.out.println(evaluatePicture.getEvaPicture());
                evaluatePicture.setEvaId(evaid);
                System.out.println(evaluatePicture.getEvaId());
                evaluatePictureService.insertEvaluatePicture(evaluatePicture);
            }
        } else {
            System.out.println("没有上传图片！");
        }
        /*int orderId = 9;
        EvaluateResult evaluateResult = evaluateResultService.saveEvaluateResult(file,grade,content,orderId);
        System.out.println(evaluateResult.toString());*/
        return "success";
    }

}
