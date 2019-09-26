package com.elife.controller;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "17347849";
    public static final String API_KEY = "lkLb9yAyZ0H6gMGaUbxbwBye";
    public static final String SECRET_KEY = "M1XeZDkSOITZTuSwAiF8SFiC6jUiT7No";

    public static void main(String[] args) {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        samplefront(client);
        sampleback(client);
    }

    public static void samplefront(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "front";

        // 参数为本地路径
        String image = "C:\\Users\\admin\\Desktop\\llbfront.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);

        JSONObject words_result = res.getJSONObject("words_result");

        JSONObject endDate = words_result.getJSONObject("姓名");
        JSONObject startDate = words_result.getJSONObject("公民身份号码");

        String end = endDate.getString("words");
        String start = startDate.getString("words");

        System.out.println(end);
        System.out.println(start);

//        System.out.println(res.toString(2));
    }

    public static void sampleback(AipOcr client) {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("detect_direction", "true");
        options.put("detect_risk", "false");

        String idCardSide = "back";

        // 参数为本地路径
        String image = "C:\\Users\\admin\\Desktop\\llbback.jpg";
        JSONObject res = client.idcard(image, idCardSide, options);

        JSONObject words_result = res.getJSONObject("words_result");
        JSONObject endDate = words_result.getJSONObject("失效日期");
        JSONObject startDate = words_result.getJSONObject("签发日期");

        String end = endDate.getString("words");
        String start = startDate.getString("words");

        System.out.println(end);
        System.out.println(start);

//        System.out.println(res.toString(2));
    }

}
