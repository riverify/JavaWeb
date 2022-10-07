<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/6/22
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>统计访问人数</title>
</head>
<body>

<%-- 声明式 --%>
<%!
    int count = 0;
%>

<%
    count = count + 1;
%>

<%="本站访问人数" + count%>

</body>
</html>
