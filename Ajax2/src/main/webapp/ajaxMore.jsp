<%--
  Created by IntelliJ IDEA.
  User: river
  Date: 11/25/22
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax二级联动</title>
    <script>
        var xhr;

        function process() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var text = xhr.responseText;

                // 处理字符串 [xxx, xxx, xxx]
                var t2 = text.substring(1, text.length - 1);
                // console.log(t2);

                var t3 = t2.split(","); // Returns: An Array of strings, split at each point where the separator occurs in the given string.
                // console.log(t3);

                var s = document.getElementById("sl");

                // 二级联动
                s.innerHTML = "<option>--请选择--</option>"; // 先清空
                // 防止出现点击"--请选择--"时回调的null
                if (t3[0] == "ul") {
                    return;
                }
                for (var i in t3) {
                    s.innerHTML += "<option value=" + (i + 1) + ">" + t3[i] + "</option>";
                }
            }
        }

        function change(val) {
            // 发送ajax请求
            // 创建ＸＨＲ对象
            xhr = new XMLHttpRequest();

            // 和服务器建立联系
            xhr.open("get", "AjaxServlet?val=" + val, true);

            // 执行回调函数
            xhr.onreadystatechange = process;

            // 发送数据
            xhr.send(null);

        }
    </script>
</head>
<body>

<select onchange="change(this.value)">
    <option>--请选择--</option>
    <option value="1">动作冒险</option>
    <option value="2">枪战射击</option>
    <option value="3">体育运动</option>
</select>
<select id="sl">
    <option>--请选择--</option>
</select>

</body>
</html>
