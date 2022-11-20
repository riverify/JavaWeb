package com.river.servlet;

import com.river.service.EmployeeService;
import com.river.service.imp.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmployeeRemoveServlet")
public class EmployeeRemoveServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int eid = Integer.parseInt(req.getParameter("eid"));

        EmployeeService emps = new EmployeeServiceImp();
        int remove = emps.remove(eid);

        resp.sendRedirect(req.getContextPath() + "/EmployeeFindAllServlet");
    }
}
