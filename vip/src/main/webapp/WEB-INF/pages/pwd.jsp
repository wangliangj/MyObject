<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js" ></script>
</head>
<body>
<h3>当前操作修改密码，请按要求填写后点击"修改"按钮</h3>
<form id="pwdForm">
    <table align="center">
        <tr>
            <td>请输入现在的密码：</td>
            <td><input name="pwd" type="password"></td>
        </tr>
        <tr>
            <td>请输入新密码：</td>
            <td><input name="npwd" type="password"></td>
        </tr>
        <tr>
            <td>请再次输入新密码：</td>
            <td><input name="repwd" type="password"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="修改" onclick="changePwd()"></td>
        </tr>
    </table>

</form>

<script type="text/javascript">
    function changePwd() {
        $.ajax({
            url:"<%=request.getContextPath()%>/changepwd.html",
            data:$("#pwdForm").serialize(),
            type: "post",
            success:function (result) {
                if (result.error != null) {
                    alert(result.error);
                } else {
                    alert(result.message);
                }
            }

        })

    }

</script>







</body>
</html>
