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

@WebServlet(urlPatterns = "/EmployeeFindOneServlet")
public class EmployeeFindOneServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收href的eid: EmployeeFindOneServlet?eid=${emp.eid}
        String e = req.getParameter("eid");
        int eid = Integer.parseInt(e);

        EmployeeService emps = new EmployeeServiceImp();
        Employee emp = emps.findOne(eid);

        req.setAttribute("emp", emp);
        req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
    }
}
