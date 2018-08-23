<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-13
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<body>
<div>
    卡号:${sessionScope.SESSION_USER.cardId}<a href="#" onclick="logout()">退出登录</a>
</div>
<div>
<div style="float: left">
    <a href="#" onclick="changeFrame('')">查询余额</a><br/>
    <a href="#" onclick="changeFrame('gotrade.html')">转账</a><br/>
    <a href="#" onclick="changeFrame('logs.html?pn=1')">查询交易记录</a><br/>
    <a href="#" onclick="changeFrame('gopwd.html')">修改密码</a><br/>

</div>
<div style="border:2px solid #ccc;height: 500px;width: 600px;float: left">
    <iframe id="main-frame" src="" style="width:100%;height: 100%">
    </iframe>
</div>
</div>
<script type="text/javascript" >
    function changeFrame(url) {
        $("#main-frame").attr("src", "<%=request.getContextPath()%>/" + url)
    }

    function logout() {
        if (confim("确定要退出吗")) {
            window.location.href="<%=request.getContextPath()%>/logout.html"
        }
    }


</script>
</body>
</html>
