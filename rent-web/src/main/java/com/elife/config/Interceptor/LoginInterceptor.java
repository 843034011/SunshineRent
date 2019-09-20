package com.elife.config.Interceptor;

        import com.elife.pojo.RentRegister;
        import org.springframework.stereotype.Component;
        import org.springframework.web.servlet.HandlerInterceptor;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();

        RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");

        System.out.println(rentRegister.toString());
        if (rentRegister == null) {
            response.sendRedirect("../login.html?info=unlogin");
            return false;
        } else {
            return true;
        }
    }
}
