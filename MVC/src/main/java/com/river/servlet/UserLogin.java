package com.river.servlet;

import com.river.entity.User;
import com.river.mapper.UserMapper;
import com.river.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/UserLogin")
public class UserLogin extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        // 接收前台页面数据
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");

        // 数据处理--连接数据库
        UserMapper mapper = DBUtil.getSqlSession().getMapper(UserMapper.class);
        User user = mapper.selectOne(uname, pwd);

        // 根据返回的结果作出相应
        if (user == null) {
            // 转发
            req.setAttribute("msg", "登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            // 重定向
            resp.sendRedirect(req.getContextPath() + "/success.jsp");
        }
    }
}
