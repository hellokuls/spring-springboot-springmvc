package com.kuls.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/28 10:41 上午
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //在登录页面也会放行
        if (request.getRequestURI().contains("goLogin")){
            return true;
        }
        //说明我在登录
        if (request.getRequestURI().contains("login")){
            return true;
        }

        //如果包含session则放行，第一次的时候是没有session的
        if (session.getAttribute("userLoginInfo")!=null){
            return true;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }


}
