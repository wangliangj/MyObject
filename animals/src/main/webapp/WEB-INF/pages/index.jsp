<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-16
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
<form action="<%=request.getContextPath()%>/index.html" id="idForm" method="post">
    <select id="selectkind" name="kind" >
        <option>--请选择--</option>
        <option >狗</option>
        <option >猫</option>
        <option >鸟</option>
        <option>老鼠</option>
    </select>
    <input type="hidden" name="pn" id="pageNum">
    <input type="button" value="查询" onclick="changePage(1)" >

</form>
<a href="<%=request.getContextPath()%>/goadd.html">新增宠物</a>
<div>
    <table border="1">
        <tr>
            <td>宠物昵称</td>
            <td>出生日期</td>
            <td>性别</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="animal">
        <tr>
            <td>${animal.name}</td>
            <td>${animal.birthday}</td>
            <td>${animal.sex}</td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="4">
                <a href="#"onclick="changePage(1)">首页</a>
                <c:if test="${pageInfo.hasPreviousPage}">
                    <a href="#" onclick="changePage(${pageInfo.prePage})">上一页</a>
                </c:if>
                <c:if test="${pageInfo.hasNextPage}">
                    <a href="#" onclick="changePage(${pageInfo.nextPage})" >下一页</a>
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
            $("#idForm").submit();
        }

    </script>


</div>


</body>
</html>
