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
import java.util.List;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if ("empLogin".equals(method)) {
            empLogin(req, resp);
        } else if ("empSave".equals(method)) {
            empSave(req, resp);
        } else if ("empFindAll".equals(method)) {
            empFindAll(req, resp);
        }
    }

    // 用户登陆
    protected void empLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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


    // 新增信息
    protected void empSave(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

//        System.out.println(emps);
//        System.out.println(save);

        // 作出响应
        if (save > 0) {
//            resp.sendRedirect(req.getContextPath() + "/EmployeeFindAllServlet");
            empFindAll(req, resp);
        } else {
            req.setAttribute("msg", "添加失败");
            req.getRequestDispatcher("/saveUser.html").forward(req, resp);
        }
    }

    // 查询所有
    protected void empFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ename = req.getParameter("ename");
        String phone = req.getParameter("phone");

        EmployeeService emps = new EmployeeServiceImp();
        List<Employee> list = emps.findAll(ename, phone);

        req.setAttribute("list", list);
        req.setAttribute("ename", ename);
        req.setAttribute("phone", phone);
        req.getRequestDispatcher("/listUser.jsp").forward(req, resp);
    }
}
