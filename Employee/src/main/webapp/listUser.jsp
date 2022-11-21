<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户列表</strong> <a href=""
                                                                           style="float:right; display:none;">添加字段</a>
    </div>
    <div class="padding border-bottom">
        <form method="post" action="EmployeeServlet?method=empFindAll" id="listform">
            <ul class="search" style="padding-left:10px;">
                <li>
                    用户名:
                    <input type="text" placeholder="请输入搜索关键字" value="${requestScope.ename}" name="ename" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    手机号:
                    <input type="text" placeholder="请输入搜索关键字" value="${requestScope.phone}" name="phone" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <input type="submit" class="button border-main icon-search" value="搜索">
                </li>
            </ul>
        </form>
    </div>

    <table class="table table-hover text-center">
        <tr>
            <th width="100" style="text-align:left; padding-left:20px;">ID</th>
            <th width="10%">姓名</th>
            <th>手机号</th>
            <th>性别</th>
            <th>出生年月</th>
            <th width="310">操作</th>
        </tr>

        <c:forEach items="${requestScope.list}" var="emp">
            <tr>
                <td style="text-align:left; padding-left:20px;">${emp.eid}</td>
                <td>${emp.ename}</td>
                <td>${emp.phone}</td>
                <td>
                    <c:if test="${emp.sex=='1'}">男</c:if>
                    <c:if test="${emp.sex=='0'}">女</c:if>
                </td>
                <td>
                    <fmt:formatDate value="${emp.birth}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>

                <td>
                    <div class="button-group"><a class="button border-main"
                                                 href="EmployeeFindOneServlet?eid=${emp.eid}"><span
                            class="icon-edit"></span> 修改</a> <a class="button border-red" href="javascript:void(0)"
                                                                onclick="return del(${emp.eid})"><span
                            class="icon-trash-o"></span> 删除</a></div>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="8">
                <div class="pagelist"><a href="">上一页</a> <span class="current">1</span><a href="">2</a><a
                        href="">3</a><a href="">下一页</a><a href="">尾页</a></div>
            </td>
        </tr>
    </table>
</div>

<script type="text/javascript">

    //搜索
    function changesearch() {

    }

    //单个删除
    function del(id) {
        if (confirm("您确定要删除吗?")) {
            window.location.href = "EmployeeRemoveServlet?eid=" + id;
        }
    }

    //全选
    $("#checkall").click(function () {
        $("input[name='id[]']").each(function () {
            if (this.checked) {
                this.checked = false;
            } else {
                this.checked = true;
            }
        });
    })

    //批量删除
    function DelSelect() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var t = confirm("您确认要删除选中的内容吗？");
            if (t == false) return false;
            $("#listform").submit();
        } else {
            alert("请选择您要删除的内容!");
            return false;
        }
    }

    //批量排序
    function sorts() {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");
            return false;
        }
    }


    //批量首页显示
    function changeishome(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量推荐
    function changeisvouch(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {


            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量置顶
    function changeistop(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }


    //批量移动
    function changecate(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {

            $("#listform").submit();
        } else {
            alert("请选择要操作的内容!");

            return false;
        }
    }

    //批量复制
    function changecopy(o) {
        var Checkbox = false;
        $("input[name='id[]']").each(function () {
            if (this.checked == true) {
                Checkbox = true;
            }
        });
        if (Checkbox) {
            var i = 0;
            $("input[name='id[]']").each(function () {
                if (this.checked == true) {
                    i++;
                }
            });
            if (i > 1) {
                alert("只能选择一条信息!");
                $(o).find("option:first").prop("selected", "selected");
            } else {

                $("#listform").submit();
            }
        } else {
            alert("请选择要复制的内容!");
            $(o).find("option:first").prop("selected", "selected");
            return false;
        }
    }

</script>
</body>
</html>