<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 11/9/22
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<h3>update.jsp</h3>
<%
    String uname = (String) session.getAttribute("uname");
    out.println(uname);
%>
<hr/>
<a href="delete.jsp">delete.jsp</a>
<hr/>
JsessionID:<%=session.getId()%>
</body>
</html>
