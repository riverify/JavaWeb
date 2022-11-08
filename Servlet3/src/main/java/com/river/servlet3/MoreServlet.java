package com.river.servlet3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/MoreServlet")
public class MoreServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        // request常用方法
        // a.[获取请求头信息](了解)
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            out.println(nextElement + ": " + req.getHeader(nextElement));
        }

        // b.[获取地址信息 http://localhost:8080/Servlet3/MoreServlet?name=river&pwd=114514]
        out.println(req.getScheme());       //  http
        out.println(req.getServerName());   //  localhost
        out.println(req.getServerPort());   //  8080
        out.println(req.getServletPath());  //  /MoreServlet
        out.println(req.getContextPath());  //  /Servlet3
        out.println(req.getRequestURI());   //  /Servlet3/MoreServlet
        out.println(req.getRequestURL());   //  http://localhost:8080/Servlet3/MoreServlet
        out.println(req.getQueryString());  //  name=river&pwd=114514

        // c.[req对象获取值]
        // 获取前台的数据
        String name = req.getParameter("name");     //  river
        // 获取多选框的值
        String[] hobbies = req.getParameterValues("hobby");

        // d.[获取远程和本地信息]
        // 获取浏览器信息
        out.println(req.getRemotePort());
        out.println(req.getRemoteHost());
        out.println(req.getRemoteAddr());
        // 获取服务器信息
        out.println(req.getLocalPort());
        out.println(req.getLocalName());
        out.println(req.getLocalAddr());

        // e.[获取其它对象]
        // 获取Session对象
        HttpSession session = req.getSession();
        // 获取全局对象
        ServletContext servletContext = req.getServletContext();
        // 获取Cookie对象
        Cookie[] cookies = req.getCookies();

        // f.[req中的常用方法]
        req.setCharacterEncoding("utf-8");
//        req.getRequestDispatcher("").forward(req, resp);
//        req.setAttribute("");
//        req.getAttribute("");


        // response常用方法
//        resp.setContentType("text/html;charset=utf-8");
//        resp.sendRedirect("");
        // 把cookie对象增加到resp中
//        resp.addCookie();
        resp.setHeader("cou", "javaee");

    }
}
