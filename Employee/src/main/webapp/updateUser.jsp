<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>修改用户</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span>添加用户</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="EmployeeSaveServlet">
            <div class="form-group">
                ${requestScope.emp}
                <div class="label">
                    <label>用户名：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="ename" value="" style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>密码：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="pwd" value="" style="width:30%"/>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>性别：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    男:<input type="radio" name="sex" value="1"/>
                    女: <input type="radio" name="sex" value="0"/>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>爱好：</label>
                </div>
                <div class="field" style="padding-top:8px;">
                    抽烟 <input type="checkbox" name="hobby" value="cy"/>
                    喝酒 <input type="checkbox" name="hobby" value="hj"/>
                    烫头 <input type="checkbox" name="hobby" value="tt"/>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>出生年月：</label>
                </div>
                <div class="field">
                    <input type="date" class="input" name="birth" value="" style="width:30%"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>手机号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="phone" value="" style="width:30%"/>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label>描述：</label>
                </div>
                <div class="field">
                    <textarea type="text" class="input" name="remark" style="height:80px;"></textarea>
                </div>
            </div>


            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>