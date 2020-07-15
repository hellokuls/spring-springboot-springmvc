package com.kuls.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/28 10:05 上午
 */
public class MyInterceptor implements HandlerInterceptor {
    //return true，执行下一个拦截器，放行
    //return false，不执行下一个拦截器，也就是该方法会被卡在这里
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======方法执行前========");
        return true;
    }

    //日志
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("======方法执行后========");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("======清理========");
    }
}
