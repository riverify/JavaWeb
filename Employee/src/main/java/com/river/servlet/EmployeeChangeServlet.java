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
import java.sql.Date;
import java.util.Arrays;

@WebServlet(urlPatterns = "/EmployeeChangeServlet")
public class EmployeeChangeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 接收数据
        int eid = Integer.parseInt(req.getParameter("eid"));
        String ename = req.getParameter("ename");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbies); // 数组转字符串
        String b = req.getParameter("birth");
        Date birth = Date.valueOf(b);    // 字符串转Date
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");

        Employee emp = new Employee(eid, ename, pwd, sex, hobby, birth, phone, remark);

        // 数据处理
        EmployeeService emps = new EmployeeServiceImp();
        int change = emps.change(emp);

        // 作出响应
        if (change > 0) {
            resp.sendRedirect(req.getContextPath() + "/EmployeeFindAllServlet");
        } else {
            req.setAttribute("msg", "添加失败");
            req.getRequestDispatcher("/updateUser.html").forward(req, resp);
        }

    }
}
