package com.river.servlet;

import com.river.entity.Employee;
import com.river.service.EmployeeService;
import com.river.service.imp.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取数据
        String uname = req.getParameter("ename");
        String pwd = req.getParameter("pwd");

        // 处理数据
        EmployeeService emps = new EmployeeServiceImp();
        Employee employee = emps.login(uname, pwd);


        // 返回结果
        if (employee != null) {
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            req.setAttribute("msg", "账号或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
