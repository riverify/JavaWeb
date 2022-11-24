<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 11/24/22
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<script>
    var xhr;

    function checkName() {
        var val = document.getElementById("uname").value;

        if (val == "" || val == null) {
            document.getElementById("uname_span").innerText = "x用户名不能为空";
        } else {
            // 发送ajax请求
            // a.创建XMLHttpRequest对象
            xhr = new XMLHttpRequest();

            // b.和服务器建立连接
            xhr.open("get", "SaveServlet?uname=" + val, true);

            // c.执行回调函数
            xhr.onreadystatechange = process;

            // d.发送请求数据
            xhr.send();
        }

        function process() {
            // 接收响应的数据
            var text = xhr.responseText;

            document.getElementById("uname_span").innerText = text;

        }

    }

</script>
<body>

<h3>注册页面</h3>
<form>
    <p>
        用户名:<input type="text"/>
    </p>
    <p>
        账号:<input type="text" name="uname" id="uname" onblur="checkName()"/>
        <span id="uname_span"></span>
    </p>
    <p>
        密码:<input type="text"/>
    </p>
    <p>
        用户名:<input type="submit" value="提交"/>
    </p>
</form>

</body>
</html>
