package com.river.ajax2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * FileName AjaxServlet3
 * Date 2022/11/25 16:06
 * Author river
 */

@WebServlet("/AjaxServlet2")
public class AjaxServlet2 extends HttpServlet {

    /**
     * a.普通文本
     * <p>
     * <p>
     * b.json
     * <p>
     * <p>
     * c.xml
     */
     
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        // 作出响应
        // 数据处理
        // 用户响应
        // ********　普通文本  ********
//        resp.getWriter().println("Ajax响应成功");


    }
}
