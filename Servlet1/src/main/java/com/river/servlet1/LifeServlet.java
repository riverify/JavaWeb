package com.river.servlet1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Ａ：　Servlet是单实例多线程的
 * Ｂ：　Servlet的生命周期
 * 1.　Servlet的生命周期是由Servlet容器管理的
 * 2.　Servlet的生命周期包括：　类加载("Class.forName()")、创建(实例化)、初始化、服务、销毁
 * Ｃ：　类加载的时机：
 * 1.　第一次访问Servlet的时候(默认)
 * 2.　启动服务器的时候 (在web.xml中配置) <load-on-startup>1</load-on-startup>
 * 1表示优先级 1最高 2次之 3次之 以此类推 0或者负数表示不启动的时候加载 也就是第一次访问的时候加载
 * 也就是默认的加载方式 一般不用这种方式 因为启动服务器的时候加载会占用服务器的资源
 * 会影响服务器的启动速度 一般不用这种方式 除非你的Servlet是必须要启动的
 * 3.　手动加载　ServletConfig.getServletContext().loadOnStartup(1);
 */
public class LifeServlet extends HttpServlet {

    // 只输出一次
    public LifeServlet() {
        System.out.println("LifeServlet");
    }


    // 执行多次
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
    }

    // 关闭服务器 执行一次
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    // 初始化方法　执行一次
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }


}
