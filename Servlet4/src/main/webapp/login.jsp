<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/7/22
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>

    <script type="text/javascript">
    </script>

</head>


<body>

<%
    // 获得请求对象中所有的cookie
    String uname = "";
    String pwd = "";
    String c = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("u".equals(cookie.getName())) {
                c = "checked";
                uname = cookie.getValue();
            }
            if ("p".equals(cookie.getName())) {
                pwd = cookie.getValue();
            }
        }
    }

%>

<h3>登陆页面</h3>
<form action="DoLoginServlet" method="post">

    <p>
        用户名:<input type="text" name="uname" id="uname" value="<%=uname%>">
        <span id="uname_span"></span>
    </p>
    <p>
        密码:<input type="password" name="pwd" id="pwd" value="<%=pwd%>">
        <span id="pwd_span"></span>
    </p>
    <p>
        记住我:<input type="checkbox" id="" name="ch" value="yes" <%=c%>>
    </p>
    <p>
        <input type="submit" value="登陆">
    </p>
</form>
</body>
</html>
