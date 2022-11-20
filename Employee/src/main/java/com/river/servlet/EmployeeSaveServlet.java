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


@WebServlet("/EmployeeSaveServlet")
public class EmployeeSaveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        // 接收数据
        String ename = req.getParameter("ename");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobby");
        String hobby = Arrays.toString(hobbies); // 数组转字符串
        String b = req.getParameter("birth");
        Date birth = Date.valueOf(b);    // 字符串转Date
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");

        Employee emp = new Employee(null, ename, pwd, sex, hobby, birth, phone, remark);

        // 数据处理
        EmployeeService emps = new EmployeeServiceImp();
        int save = emps.save(emp);

        System.out.println(emps);
        System.out.println(save);

        // 作出响应
        if (save > 0) {
            resp.sendRedirect(req.getContextPath() + "listUser.jsp");
        } else {
            req.setAttribute("msg", "添加失败");
            req.getRequestDispatcher("/saveUser.html").forward(req, resp);
        }

    }
}
