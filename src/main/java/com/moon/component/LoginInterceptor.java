package com.moon.component;

import com.moon.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author moonjay
 */
public class LoginInterceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            HttpSession session = request.getSession();
            //统一拦截（查询当前session是否存在user）(这里user会在每次登录成功后，写入session)
            User user = (User) session.getAttribute("user");
            if (user == null) {
                request.setAttribute("msg","没有权限！请先登录...");
                request.getRequestDispatcher("/login").forward(request,response);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}

