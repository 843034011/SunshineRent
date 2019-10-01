package com.elife.controller;

import com.baidu.aip.ocr.AipOcr;
import com.elife.dto.IdCardResult;
import com.elife.dto.UserResult;
import com.elife.pojo.RentRegister;
import com.elife.service.IdentificationService;
import com.elife.service.QiniuService;
import com.elife.service.RentUserService;
import com.elife.vo.ResultData;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author llb
 */
@Controller
@RequestMapping("identification")
public class IdentificationController {

    @Autowired
    QiniuService qiniuService;

    @Autowired
    IdentificationService identificationService;

    //设置APPID/AK/SK
    public static final String APP_ID = "17347849";
    public static final String API_KEY = "lkLb9yAyZ0H6gMGaUbxbwBye";
    public static final String SECRET_KEY = "M1XeZDkSOITZTuSwAiF8SFiC6jUiT7No";

    // 初始化一个AipOcr
    static AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    public static void samplefront(AipOcr client, String url, IdCardResult idCardResult) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "front";

        // 参数为本地路径
        String image = url;
        JSONObject res = client.idcard(image, idCardSide, options);

        JSONObject words_result = res.getJSONObject("words_result");

        JSONObject name = words_result.getJSONObject("姓名");
        JSONObject num = words_result.getJSONObject("公民身份号码");

        String realName = name.getString("words");
        String idNumber = num.getString("words");

        System.out.println(realName);
        System.out.println(idNumber);

        idCardResult.setRealName(realName);
        idCardResult.setIdNumber(idNumber);
    }

    public static void sampleback(AipOcr client,String url, IdCardResult idCardResult) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地路径
        String image = url;
        JSONObject res = client.idcard(image, idCardSide, options);
        JSONObject words_result = res.getJSONObject("words_result");

        JSONObject endDate = words_result.getJSONObject("失效日期");
        JSONObject startDate = words_result.getJSONObject("签发日期");

        String end = endDate.getString("words");
        String start = startDate.getString("words");

        System.out.println(end);
        System.out.println(start);

        idCardResult.setEndDate(end);
        idCardResult.setStartDate(start);
    }


    @RequestMapping("show")
    public String showIdentification(){
        return "identification";
    }

    @RequestMapping("idcard")
    @ResponseBody
    public ResultData confirm(MultipartFile front, MultipartFile back) throws IOException {

        IdCardResult idCardResult = new IdCardResult();

        System.out.println(front.toString());
        System.out.println(back.toString());

        String idCardFront = getAbsolute(front);
        String idCardBack = getAbsolute(back);

        sampleback(client,idCardBack,idCardResult);
        samplefront(client,idCardFront,idCardResult);

        System.out.println("======================");
        System.out.println(idCardResult.toString());
        System.out.println("======================");

        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).replaceAll("-","");

        ResultData resultData = new ResultData();

        if(Integer.parseInt(idCardResult.getStartDate()) > Integer.parseInt(timeStr) || Integer.parseInt(idCardResult.getEndDate()) < Integer.parseInt(timeStr)){
            resultData.setCode(1);
            resultData.setMessage("当前身份证已经过期了");
        }

        if(idCardResult != null){
            resultData.setCode(0);
            resultData.setData(idCardResult);
        }else{
            resultData.setCode(1);
            resultData.setMessage("用户信息采集失败");
        }

        return resultData;
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultData update(MultipartFile headimg, UserResult userResult, HttpSession session) throws IOException {

        ResultData resultData = new ResultData();

        RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
        System.out.println(rentRegister.getRegId());
        userResult.setId(rentRegister.getRegId());

        System.out.println(userResult.getId());

        System.out.println(headimg);

        String imgUrl = new String();

        if(headimg == null){
            imgUrl = "http://pxm37tv32.bkt.clouddn.com/default.png";
        }else{
            imgUrl = qiniuService.saveImage(headimg);
        }

        System.out.println(imgUrl);

        System.out.println(userResult.getRealname());
        System.out.println(userResult.getIdcard());
        System.out.println(userResult.getPhone());
        System.out.println(userResult.getNickname());
        System.out.println(userResult.getEmail());

        int i = identificationService.updateUser(userResult,imgUrl);

        if(i > 0){
            resultData.setCode(0);
            resultData.setMessage("修改成功！！！");
        } else {
            resultData.setCode(1);
            resultData.setMessage("修改失败！！！");
        }
        return resultData;
    }

    public String getAbsolute(MultipartFile file) throws IOException {
        String oldName = file.getOriginalFilename();
        System.out.println(oldName);
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        System.out.println(newName);

        String basePath = "C:\\imgs\\";

        File f = new File(basePath);
        if(f.exists() == false){
            f.mkdirs();
        }

        String newPath = basePath + newName;

        System.out.println(newPath);

        OutputStream outputstream = null;
        InputStream inputstream = null;

        try {
            inputstream = file.getInputStream();
            outputstream = new FileOutputStream(newPath);

            byte[] buffer = new byte[1024 * 5];
            int byteRead = -1;

            while ((byteRead = (inputstream.read(buffer))) != -1) {
                outputstream.write(buffer, 0, byteRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputstream != null) {
                outputstream.flush();
                outputstream.close();
            }
            if (inputstream != null) {
                inputstream.close();
            }
        }
        return newPath;
    }
}