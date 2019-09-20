/*
package com.elife.config.Interceptor;

import com.elife.annotation.Token;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class RegisterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 跳转register页面请求 拦截器放行 修改annotation.save()==true
        if(handler instanceof HandlerMethod){

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);

            System.out.println("========");
            System.out.println(annotation);
            if (annotation != null) {

                // 第一次提交请求 拦截器放行 修改annotation.remove()==true
                // 跳转到register页面后 annotation.save()==true 创建令牌
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    // 将token放到session中
                    request.getSession(true).setAttribute("token", "liulanboyoudianshuaiya");
                }

                // 第二或多次提交请求 判断 是否是重复提交 是---拦截、不是---删除令牌、放行
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        return false;
                    }
                    request.getSession(true).removeAttribute("token");
                }
            }
            return true;
        } else {
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(true).getAttribute("token");

        if (serverToken == null) {
            return true;
        }

        String formToken = request.getParameter("token");

        if (formToken == null) {
            return true;
        }
        if (!serverToken.equals(formToken)) {
            return true;
        }

        return false;
    }
}
*/
