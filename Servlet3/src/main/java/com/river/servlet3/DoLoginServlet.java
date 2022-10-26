package com.river.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // a.接收页面数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        // b.数据处理
        boolean flag = "admin".equals(uname) && "123456".equals(pwd);

        // c.作出响应
        if (flag) {
            // 转发
//            req.getRequestDispatcher("success.jsp").forward(req, resp);
            // 重定向
            resp.sendRedirect("success.jsp");
        } else {
            req.setAttribute("msg", "账号或密码错误!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
