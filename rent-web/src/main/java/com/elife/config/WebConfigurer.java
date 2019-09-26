package com.elife.config;

import com.elife.config.Interceptor.LoginInterceptor;
import com.elife.config.Interceptor.RegisterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author llb*/


@Configuration
//@EnableWebMvc
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Autowired
    RegisterInterceptor registerInterceptor;

    //配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //登录拦截的黑名单
        List<String> loginList = new ArrayList<>();
        loginList.add("/shoppingcart/*");
        loginList.add("/orders/*");

        registry.addInterceptor(loginInterceptor).addPathPatterns(loginList).excludePathPatterns();


        //注册拦截的黑名单
        List<String> registerList = new ArrayList<>();
        registerList.add("/register/**");

        registry.addInterceptor(registerInterceptor).addPathPatterns(registerList).excludePathPatterns();

    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**");
//    }
}
