<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
<div align="center">
    <h1>商务会员管理系统</h1>
    <form method="post">
        <table align="center">
            <tr>
                <td>用户名:</td>
                <td><input name="username"></td>
            </tr><br/>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"></td>
            </tr><br/>
            <tr>
            <td colspan="2" align="center"><input type="button" value="登录" onclick="login()"></td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function login() {
        $.ajax({
            url: "<%=request.getContextPath()%>/login.html",
            data: $("form").serialize(),
            type: "post",
            success: function (result) {
                if (result.error != null) {
                    alert(result.error);
                } else {
                    alert(result.message);
                    window.location.href = "<%=request.getContextPath()%>/goindex.html";
                }
            }

        })
    }

</script>
</body>
</html>
