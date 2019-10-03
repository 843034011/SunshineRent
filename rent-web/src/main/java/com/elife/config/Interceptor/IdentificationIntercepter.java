package com.elife.config.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class IdentificationIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Byte isIdentified = (Byte) request.getSession().getAttribute("idIdentified");

        System.out.println("=================");
        System.out.println(isIdentified);
        if(isIdentified == null ){
            response.sendRedirect("http://localhost:8080/login.html?info=unlogin");
        }

        if(isIdentified == 0 ){
            response.sendRedirect("http://localhost:8080/identification/show");
            return false;
        } else if(isIdentified == 1 ){
            return true;
        }
        return false;
    }
}
