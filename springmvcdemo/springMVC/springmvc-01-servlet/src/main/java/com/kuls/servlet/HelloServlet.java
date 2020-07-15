package com.kuls.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/26 7:43 上午
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取前端参数
        String method = req.getParameter("method");

        if (method.equals("add")){
            req.getSession().setAttribute("msg","调用了add方法");

        }else if (method.equals("delete")){
            req.getSession().setAttribute("msg","调用了delete方法");
        }

        req.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
