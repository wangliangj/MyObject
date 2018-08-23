<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-11
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/login.html" method="post">
    用户名：<input type="text" name="username" value="${param.username}"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit" value="登录"/>${message}
    <a href="<%=request.getContextPath()%>/regist.jsp">注册</a>
</form>
</body>
</html>
