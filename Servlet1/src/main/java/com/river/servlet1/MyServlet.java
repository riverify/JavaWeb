package com.river.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    String enc;
    String enc2;

    @Override
    public void init() throws ServletException {
        // 读取属性文件

        // 读取初始化参数
        enc = this.getInitParameter("enc");
//        enc = this.getServletConfig().getInitParameter("enc");
        // 读取全局初始化参数
        enc2 = this.getServletContext().getInitParameter("enc-utf8");

        // 输出
        System.out.println("初始化参数：" + enc);
        System.out.println("全局初始化参数：" + enc2);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=" + enc2); // 防止中文乱码

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
