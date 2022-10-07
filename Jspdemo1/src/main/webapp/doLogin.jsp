<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/7/22
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>处理登陆操作</title>
</head>
<body>
<%
    // 接收页面中传递过来的数据
    String uname = request.getParameter("uname");
    String pwd = request.getParameter("pwd");

    // 数据处理－－与数据库内容作比较，返回结果
    boolean flag = false;
    if ("admin".equals(uname) && "123456".equals(pwd)) {
        flag = true;
    }

    // 给用户作出响应
    if (flag) {
        // 登陆成功
        out.println("登陆成功");
    } else {
        // 登陆失败
        out.println("登陆失败");
    }

%>
</body>
</html>
