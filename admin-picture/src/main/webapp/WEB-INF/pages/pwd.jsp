<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-13
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>当前操作修改密码，请按要求填写后点击"修改"按钮</h3>
<form id="pwdForm">
    <table align="center">
        <tr>
            <td>请输入旧密码：</td>
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
            <td colspan="2" align="center"><input type="button" value="提交" onclick="changePwd()"></td>
        </tr>

    </table>
</form>
<script type="text/javascript">
    function changePwd() {
        $.ajax({
            url: "<%=request.getContextPath()%>/changepwd.html",
            data:$("#pwdForm").serialize(),
            type:"post",
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
