package com.river.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet进行流程控制
 */
public class DoLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 接收页面中传递过来的数据
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        // 数据处理－－与数据库内容作比较，返回结果
        boolean flag = false;
        if ("admin".equals(uname) && "123456".equals(pwd)) {
            flag = true;
        }

        // 给用户作出响应
        if (flag) {
            // 登陆成功
//        out.println("登陆成功");
            request.getRequestDispatcher("success.jsp").forward(request, response);
        } else {
            // 登陆失败
//        out.println("登陆失败");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
