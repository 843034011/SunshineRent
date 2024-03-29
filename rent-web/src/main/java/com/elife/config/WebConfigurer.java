package com.elife.config;

import com.elife.config.Interceptor.IdentificationIntercepter;
import com.elife.config.Interceptor.LoginInterceptor;
import com.elife.config.Interceptor.RegisterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author llb
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Autowired
    RegisterInterceptor registerInterceptor;

    @Autowired
    IdentificationIntercepter identificationIntercepter;

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录拦截的黑名单
        List<String> loginList = new ArrayList<>();
        loginList.add("/shoppingcart/**");
        loginList.add("/goodsManageCon/showManage");

        registry.addInterceptor(loginInterceptor).addPathPatterns(loginList).excludePathPatterns();


        //注册拦截的防止表单重复提交
        List<String> registerList = new ArrayList<>();
        registerList.add("/register/**");

        registry.addInterceptor(registerInterceptor).addPathPatterns(registerList).excludePathPatterns();


        // 认证拦截的黑名单
        List<String> identificationList = new ArrayList<>();
        identificationList.add("/orders/insertorder");
        registry.addInterceptor(identificationIntercepter).addPathPatterns(identificationList).excludePathPatterns();
    }
}
