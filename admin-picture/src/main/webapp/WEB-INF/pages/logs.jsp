<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 09:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
<h3>当前操作查询交易记录，请按要求填写后点击"查询"按钮</h3>
<form action="<%=request.getContextPath()%>/logs.html" method="post" id="logForm">
    查询时间范围:<input name="startDate" value="${param.startDate}" >
    到<input name="endDate" value="${param.endDate}">
    <input type="hidden" name="pn" id="pageNum" >
    <input type="button" value="查询" onclick="changePage(1)">

</form>

<table border="1">
    <tr>
        <td>交易日期</td>
        <td>支出</td>
        <td>存入</td>
        <td>账户余额</td>
        <td>交易类型</td>
        <td>备注</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="trade">
        <tr>
            <td><fmt:formatDate value="${trade.createdDate}" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate></td>
            <td><c:if test="${trade.type eq 4}">${trade.amount/100}</c:if></td>
            <td><c:if test="${trade.type eq 3}">${trade.amount/100}</c:if></td>
            <td>${trade.balance/100}</td>
            <td>
                <c:choose>
                    <c:when test="${trade.type eq 1}">存款</c:when>
                    <c:when test="${trade.type eq 2}">消费</c:when>
                    <c:when test="${trade.type eq 3}">转入</c:when>
                    <c:when test="${trade.type eq 4}">转出</c:when>
                    ${trade.typeString}
                </c:choose>
            </td>
            <td>${trade.remark}</td>
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
            第${pageInfo.pageNum}页/共${pageInfo.pages}页（${pageInfo.total}条记录）
        </td>
    </tr>
</table>
<script type="text/javascript">
    $(function () {
       $("tr:even").css("background","yellow")
    });
    function changePage(pn) {
        $("#pageNum").val(pn);
        $("#logForm").submit();
    }
</script>
</body>
</html>
