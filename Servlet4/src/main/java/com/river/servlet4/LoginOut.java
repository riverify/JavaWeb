package com.river.servlet4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginOut")
public class LoginOut extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 注销session对象
        req.getSession().invalidate();
        // 跳转到登陆页面
        // 重定向
        resp.sendRedirect(req.getContextPath() + "/login.jsp");
    }
}
