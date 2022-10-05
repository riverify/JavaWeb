<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 10/5/22
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function demo1() {
            let date = new Date();
            document.getElementById("sp1").innerText = date.toLocaleString();

        }
    </script>
</head>
<body onload="demo1()">

获得时间:<span id="sp1"></span>

</body>
</html>
