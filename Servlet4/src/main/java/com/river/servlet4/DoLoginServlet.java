package com.river.servlet4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        String ch = req.getParameter("ch");

        // b.数据处理
        boolean flag = "admin".equals(uname) && "123456".equals(pwd);

        // c.作出响应
        if (flag) {
            // cookie记住我
            // 申请
            Cookie cookie1 = new Cookie("u", uname);
            Cookie cookie2 = new Cookie("p", pwd);
            // 设定有效时间
            if ("yes".equals(ch)) {
                cookie1.setMaxAge(60 * 60 * 24 * 10);
                cookie2.setMaxAge(60 * 60 * 24 * 10);
            } else {
                cookie1.setMaxAge(0);
                cookie2.setMaxAge(0);
            }

            // 指定使用规则
            // 使用范围
            cookie1.setPath("/"); // 服务器
            cookie2.setPath("/Servlet4"); // 当前项目

            // 返回
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);

            // 重定向
            resp.sendRedirect("success.jsp");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
