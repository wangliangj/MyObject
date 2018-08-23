<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-25
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
<table border="1">
    <tr ><td colspan="3"><input type="button" value="+上传文件" ><input type="text" placeholder="搜索文件名"><input type="button" value="搜索"></td></tr>
    <tr>
        <td>文件名</td>
        <td>大小</td>
        <td>修改日期</td>
    </tr>
    <c:forEach  items="${fileList}" var="file">
        <tr>
            <td><a href="#">${file.name}</a></td>
            <td>${file.size}</td>
            <td><fmt:formatDate value="${file.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>

    </c:forEach>

<script type="text/javascript">

</script>

</body>
</html>
