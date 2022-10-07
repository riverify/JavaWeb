<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/5/22
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>服务器/浏览器时间</title>
    <script type="text/javascript">
        function demo1() {
            let date = new Date();
            document.getElementById("sp1").innerText = date.toLocaleString();
        }
    </script>
</head>


<body onload="demo1()">

获取浏览器时间:<span id="sp1"></span> <br/>
<%-- 小脚本，可以书写java代码 --%>
<%
    Date date = new Date();
    String time = date.toLocaleString();
%>
<%-- 表达式 --%>
<%--获取服务器时间:<span id="sp2"><%=time%></span>--%>
<%="获取服务器时间:" + time%>
</body>
</html>
