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
<form id="myForm" method="post" action="<%=request.getContextPath()%>/login.html">
用户名：<input type="text" id="username" name="username" onblur="onname()"><br/>
密码：<input type="password" name="password" id="pwd" onblur="onpwd()"><br/>
<input type="submit" value="登录" >
<input type="button" value="重填" onclick="rechangeLogin()">
</form>
${message}
<script type="text/javascript" >

    function rechangeLogin() {
        $("#myForm")[0].reset();
    }

    function onname() {
        var username = $("#username").val();
        //判断用户名输入框是否为空
        if (username.trim().length == 0) {
            $("#username").after("<span>用户名不能为空</span>")
        }
    };
    function onpwd() {
        var pwd = $("#pwd").val();
        //判断用户名输入框是否为空
        if (pwd.trim().length == 0) {
            $("#pwd").after("<span>密码不能为空</span>")
        }
    }

</script>
</body>
</html>
