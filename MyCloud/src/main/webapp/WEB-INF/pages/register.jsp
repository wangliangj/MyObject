<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-18
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
<style>
    span {
        color: red
    }
</style>
<form id="main-form" action="<%=request.getContextPath()%>/register.html " method="post">
用户名：<input type="text" id="username" name="username"><br/>
密码:<input type="password" name="password" id="pwd" onblur="onSubmitpwd()"><br/>
确认密码:<input type="password" name="repwd" id="repwd" onblur="onSubmitrepwd()"><br/>
<input type="submit" value="注册" id="reBtn" disabled="disabled">
<input type="button" value="重填" id="resetbut"  onclick="changeReset()">
</form>
<script type="text/javascript">

    $(function () {
        $("span").remove();
        $("#username").change(function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/check.html",
                data: "username=" + $("#username").val(),
                method: "post",
                success:function (result) {
                    if (result > 0) {
                        $("#username").after("<span>用户名已经存在</span>");
                    } else {
                        $("span").remove();
                        $("#reBtn").removeAttr("disabled")
                    }
                }
            })
        });
    });

    function onSubmitrepwd() {
        $("span").remove();
        var pwd = $("#pwd").val();
        var repwd = $("#repwd").val();
        if (pwd != repwd) {
            $("#repwd").after("<span>两次密码不一致</span>");
        }

    }
    
    function onSubmitpwd() {
        $("span").remove();
        var pwd = $("#pwd").val();
        if (pwd.trim().length == 0) {
            $("#pwd").after("<span>密码不能为空</span>");
        }
    }

    function changeReset() {
        $("#main-form")[0].reset();
    }

</script>

</body>
</html>
