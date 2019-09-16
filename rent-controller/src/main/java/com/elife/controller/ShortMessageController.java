package com.elife.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.elife.pojo.RentRegister;
import com.elife.service.RegisterService;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:llb
 */
@Controller
@RequestMapping("shortmessage")
public class ShortMessageController {

    @Autowired
    RegisterService registerService;

    @RequestMapping("send")
    @ResponseBody
    public ResultData sendShortMessage(String telephone){

        ResultData resultData = new ResultData();

        RentRegister rentRegister = registerService.selectRegisterByTelephone(telephone);

        if(rentRegister != null){
            resultData.setCode(1);
            resultData.setMessage("当前用户已经存在");
            return resultData;
        }

        System.out.println(telephone);

        //生成一个验证码
        setNewcode();

        //获取它、打印它
        String code = Integer.toString(getNewcode());
        System.out.println("发送的验证码为：" + code);

        SendSmsResponse sendSmsResponse = null;

        //发短信
        try {
            sendSmsResponse = sendSms(telephone, code);
        } catch (ClientException e) {
            e.printStackTrace();
        }

        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSmsResponse.getCode());
        System.out.println("Message=" + sendSmsResponse.getMessage());
        System.out.println("RequestId=" + sendSmsResponse.getRequestId());
        System.out.println("BizId=" + sendSmsResponse.getBizId());

        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")){
            resultData.setCode(0);
            resultData.setData(code);
        } else{
            resultData.setCode(1);
            resultData.setMessage("短信发送失败！！");
        }

        return resultData;
    }

    //产品名称:云通信短信API产品
    static final String product = "Dysmsapi";
    //产品域名
    static final String domain = "dysmsapi.aliyuncs.com";

    static final String accessKeyId = "LTAI4FdrsoMQhTD1mnfA5Vm7";
    static final String accessKeySecret = "SiuUvqdxiz78BHUKpwmYp5zxIuJSZ3";

    //随机生成验证码
    private static int newcode;

    public static int getNewcode() {
        return newcode;
    }

    public static void setNewcode() {
        newcode = (int) (Math.random() * 8999) + 1000;  //每次调用生成一位四位数的随机数
    }

    public static <IClientProfile> SendSmsResponse sendSms(String telephone, String code) throws ClientException {

        //调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = (IClientProfile) DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient((com.aliyuncs.profile.IClientProfile) profile);

        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();

        //待发送手机号
        request.setPhoneNumbers(telephone);

        //短信签名
        request.setSignName("阳光租赁");
        //短信模板
        request.setTemplateCode("SMS_173342860");

        //模板中的变量替换JSON串
        request.setTemplateParam("{\"code\":\"" + code + "\"}");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            System.out.println("短信发送成功！");
        } else {
            System.out.println("短信发送失败！");
        }
        return sendSmsResponse;
    }
}

