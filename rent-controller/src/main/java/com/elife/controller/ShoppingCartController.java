package com.elife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("shoppingcart")
public class ShoppingCartController {

    /**
     * 显示购物车界面 跳转到
     * /WEN-INF/shoppingcart.html
     * @return
     */
    @RequestMapping("showcart")
    public String showcart(){
        return "shoppingcart";
    }



}
