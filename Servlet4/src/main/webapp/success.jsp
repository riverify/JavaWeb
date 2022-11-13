<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/26/22
  Time: 8:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

<h3>Login success</h3>
<%
    String uname = (String) session.getAttribute("uname");
    out.println(uname);
%>
<a href="update.jsp">update.jsp</a>
<hr/>
JsessionID:<%=session.getId()%>
<hr/>
Session的活动时间<%=session.getMaxInactiveInterval()%>
<hr/>
<a href="LoginOut">退出</a>
<hr/>
当前访问人数:<%=application.getAttribute("countAttribution")%>
</body>
</html>
