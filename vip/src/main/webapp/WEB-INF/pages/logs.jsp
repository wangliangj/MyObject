<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js" ></script>

</head>
<body>
<h3 align="center">会员管理</h3>
<form action="<%=request.getContextPath()%>/logs.html" method="post" id="logForm">
    <input name="username" value="${param.username}">
    <input type="hidden" name="pn" id="pageNum">
    <input type="button" value="查询" onclick="changePage(1)">
</form>
<table border="1">
    <tr>
        <td>序号</td>
        <td>用户名</td>
        <td>用户类别</td>
        <td>用户状态</td>
        <td>最后修改时间</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="log">
    <tr>
        <td>${log.id}</td>
        <td>${log.username}</td>
        <td>${log.userType}</td>
        <td>
            <c:choose>
                <c:when test="${log.userStatus eq 1}">冻结</c:when>
                <c:when test="${log.userStatus eq 0}">正常</c:when>
            </c:choose>
        </td>
        <td>${log.updateTime}</td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <a href="#" onclick="changePage(1)">首页</a>
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="#" onclick="changePage(${pageInfo.prePage})">上一页</a>
            </c:if>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="#" onclick="changePage(${pageInfo.nextPage})">下一页</a>
            </c:if>
            <a href="#" onclick="changePage(${pageInfo.lastPage})">末页</a>
            第${pageInfo.pageNum}页/共${pageInfo.pages}页(共${pageInfo.total}条记录)
        </td>
    </tr>

</table>
<script type="text/javascript" >
    $(function () {
        $("tr:even").css("background", "yellow");

    });
    function changePage(pn) {
        $("#pageNum").val(pn);
        $("#logForm").submit();
    }
</script>
</body>
</html>
