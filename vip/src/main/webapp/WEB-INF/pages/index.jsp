<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js" ></script>
</head>
<body>
<h3 align="center">商务会员管理系统</h3><br/>
<div>
    用户名:${sessionScope.SESSION_USER.username}
    用户类型：${sessionScope.SESSION_USER.userType}

    <a href="#" onclick="logout()" >退出</a><br/>
</div>
<div>
    <div style="float: left">
        <a href="#" onclick="changeFrame('gopwd.html')">修改密码</a><br/>
        <c:choose>
            <c:when test="${sessionScope.SESSION_USER.userType eq '管理员' }"> <a href="#" onclick="changeFrame('logs.html?pn=1')">查看所有会员</a><br/></c:when>
            <c:when test="${sessionScope.SESSION_USER.userType eq '普通会员' }"></c:when>
        </c:choose>


    </div>
    <div style="border:2px solid #ccc;height: 500px;width: 600px;float: left">
        <iframe id="main-frame" src="" style="width:100%;height: 100%">
        </iframe>
    </div>
</div>

</body>
<script type="text/javascript">
    function logout() {
        if (confirm("你确定要退出吗")) {
            window.location.href = "<%=request.getContextPath()%>/logout.html";
        }
    }

    function changeFrame(url) {
        $("#main-frame").attr("src", "<%=request.getContextPath()%>/" + url);

    }


</script>

</html>
