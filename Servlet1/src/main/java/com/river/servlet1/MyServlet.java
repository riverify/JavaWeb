package com.river.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8"); // 防止中文乱码

        PrintWriter out = resp.getWriter();

        out.print("<html>");
        out.print("<head>");
        out.print("<title>MyServlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h2>Hello Servlet</h2>");
        out.print("<p>你好,Servlet</p>");
        out.print("</body>");
        out.print("</html>");

    }
}
