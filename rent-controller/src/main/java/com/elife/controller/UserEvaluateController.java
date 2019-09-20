package com.elife.controller;

import com.elife.pojo.EvaluatePicture;
import com.elife.pojo.UserEvaluate;
import com.elife.pojo.UserOrder;
import com.elife.service.EvaluatePictureService;
import com.elife.service.QiniuService;
import com.elife.service.UserEvaluateService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @RequestMapping("evaluateHTML")
    public String evaluateHTML() {
        return "user_evaluate";
    }

    @ResponseBody
    @RequestMapping("evaluateData")
    public String insertUserEvaluate(MultipartFile[] file, int grade, String content, HttpServletRequest request) throws IOException {

        UserEvaluate userEvaluate = new UserEvaluate();

        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("timeStr" + timeStr);

        userEvaluateService.insertUserEvaluate(grade, content, 1, timeStr, 1, 9);

        int evaid = userEvaluate.getId();
        System.out.println("evaid = " + evaid);

        if (file != null && file.length > 0) {
            System.out.println(file.length + "薄一帆");
            for (int i = 0; i < file.length; i++) {
                MultipartFile filex = file[i];
                // 保存文件
                EvaluatePicture evaluatePicture = new EvaluatePicture();
                String fileUrl = qiniuService.saveImage(filex);
                System.out.println(fileUrl);
                evaluatePicture.setEvaPicture(fileUrl);
                evaluatePicture.setEvaId(evaid);
                evaluatePictureService.insertEvaluatePicture(evaluatePicture);
            }
        } else {
            System.out.println(file.length + "：长度就是零");
        }
        return "success";
    }

}
