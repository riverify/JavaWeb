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
import java.util.List;

@WebServlet(urlPatterns = "/EmployeeFindAllServlet")
public class EmployeeFindAllServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
