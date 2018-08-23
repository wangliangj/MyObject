<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-04
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

    <script type="text/javascript">
        function login() {
            var cardId = $("input[name=cardId]");
            if (cardId.val().trim().length != 16) {
                alert("请输入16位卡号");
                return;
            }

            var password = $("input[name=password]");
            if (password.val().trim().length != 6) {
                alert("请输入6位密码");
                return;
            }

            $.ajax({
                url:"<%=request.getContextPath()%>/login.html",
                data:$("form").serialize(),
                type: "post",
                success:function (result) {
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


</head>
<body>
<form  method="post">
    卡号：<input type="text" name="cardId" placeholder="用户名"><br/>
    密码：<input type="password" name="password" placeholder="密码"><br/>
    <input type="button" value="登录" onclick="login()">
</form>
</body>
</html>
