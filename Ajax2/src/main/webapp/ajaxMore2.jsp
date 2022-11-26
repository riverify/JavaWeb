<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 11/25/22
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        var xhr;

        function demo1() {
            xhr = new XMLHttpRequest();

            xhr.open("get", "AjaxServlet2?", true);

            xhr.onreadystatechange = process;

            xhr.send(null);
        }

        function process() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var text = xhr.responseText;
                console.log(text);
            }
        }

    </script>
</head>
<body>

<input type="button" onclick="demo1()" value="ajax请求"/>

</body>
</html>
