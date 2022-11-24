package com.river.ajax1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * SaveServlet
 * Date 2022/11/24 23:31
 * Author river
 */

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        // 进行数据接收
        String uname = req.getParameter("uname");

        // 数据处理--模拟数据库
        Boolean flag = false;
        if ("river".equals(uname)) {
            flag = true;
        }

        // 响应用户
        PrintWriter out = resp.getWriter();
        if (flag) {
            out.print("用户名已被占用");
        } else {
            out.print("用户名可用");
        }
    }
}
