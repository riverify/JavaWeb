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
    <script type="text/javascript" src="js/jquery-3.6.1.min.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#uname").blur(function () {
                // 非空判断
                let f = $("#uname").val();
                if (f === "" || f == null) {
                    $("#uname_span").text("用户名不能为空!").css("color", "red");
                } else {
                    $("#uname_span").text("用户名合法").css("color", "green");
                }
            })

            $("#pwd").blur(function () {
                let f = $("#pwd").val();
                if (f === "" || f == null) {
                    $("#pwd_span").text("密码不能为空!").css("color", "red");
                } else {
                    $("#pwd_span").text("密码合法").css("color", "green");
                }
            })

        })
    </script>

</head>


<body>

<h3>登陆页面</h3>
<form action="DoLoginServlet" method="post">

    <p>
        用户名:<input type="text" name="uname" id="uname">
        <span id="uname_span"></span>
    </p>
    <p>
        密码:<input type="password" name="pwd" id="pwd">
        <span id="pwd_span"></span>
    </p>
    <p>
        <input type="submit" value="登陆">
    </p>
</form>
</body>
</html>
