package com.river.servlet;

import com.river.entity.User;
import com.river.service.UserService;
import com.river.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UserRegister")
public class UserRegister extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        // 数据处理
        User user = new User(null, uname, pwd);
        UserService userService = new UserServiceImpl();
        Integer register = userService.register(user);

        // 作出响应
        if (register > 0) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        } else {
            req.setAttribute("msg", "注册失败");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
