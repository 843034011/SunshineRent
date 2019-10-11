package com.elife.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;

import com.elife.alipay.AlipayConfig;

import com.elife.dto.TotalOrderResult;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.service.OrderDetailService;
import com.elife.service.RedisService;
import com.elife.service.ShoppingCartService;
import com.elife.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("alipay")
public class AliPayController{

    @Autowired
    ShoppingCartService shoppingCartService;

    @Autowired
    UserOrderService userOrderService;

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    private RedisService redisService;

    /**
     * 确认订单结算
     * @param httpResponse
     * @throws IOException
     */
    @RequestMapping("payInfo")
    public void alipay(HttpServletResponse httpResponse, String orderId, String money,HttpSession session) throws IOException {

        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.GATEWAY_URL, AlipayConfig.APP_ID,
                AlipayConfig.APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);

        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();

        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(AlipayConfig.RETURN_URL);
        request.setNotifyUrl(AlipayConfig.NOTIFY_URL);

        // 订单号，订单系统中唯一订单号
       String out_trade_no = orderId;

        // 付款金额
        String total_amount =money;

        // 订单名称
        String subject = "";

        TotalOrderResult totalOrderResult = (TotalOrderResult) session.getAttribute("totalOrderResult");
        for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
            subject += totalOrderResult.getResults().get(i).getName() + " ";
        }

        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}"
        );

        String form = "";

        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);

        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }

    @RequestMapping(value = "returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request,HttpSession session) throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("utf-8"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);//查看参数都有哪些

        boolean signVerified = AlipaySignature.rsaCheckV1(
                params, AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.CHARSET, AlipayConfig.SIGN_TYPE); // 调用SDK验证签名

        //验证签名通过
        if(signVerified){
            // 商户订单号
            String out_trade_no1 = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号="+out_trade_no1);
            System.out.println("支付宝交易号="+trade_no);
            System.out.println("付款金额="+total_amount);

            // 支付成功，删除购物车中数据、向订单表、订单详情表内插入数据
            TotalOrderResult totalOrderResult = (TotalOrderResult) session.getAttribute("totalOrderResult");
            System.out.println(totalOrderResult.toString());

            // 向订单表中插数据
            int a = userOrderService.insertOrder(totalOrderResult);

            String orderId = totalOrderResult.getOrderId();

            // 向订单详情表内插入数据
            for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
                if(totalOrderResult.getResults().get(i).getType().equals("field")){
                    RentField rentField = shoppingCartService.selectFieldById(totalOrderResult.getResults().get(i).getFieldId());
                    int m = orderDetailService.insertOrderDetailField(totalOrderResult.getResults().get(i),rentField,orderId);
                } else if(totalOrderResult.getResults().get(i).getType().equals("goods")){
                    RentGoods rentGoods = shoppingCartService.selectGoodsById(totalOrderResult.getResults().get(i).getGoodsId());
                    int n = orderDetailService.insertOrderDetailGoods(totalOrderResult.getResults().get(i),rentGoods,orderId);
            }
            }

            // 从购物车表中删除数据
            for (int i = 0; i < totalOrderResult.getResults().size(); i++) {
                int o = shoppingCartService.deleteByShoppingId(Integer.parseInt(totalOrderResult.getResults().get(i).getShoppingCartId()));
            }

            session.removeAttribute("totalOrderResult");

            return "shoppingcart";//跳转付款成功页面
        }else{
            return "/orders/ensureorder";//跳转付款失败页面
        }
    }
}