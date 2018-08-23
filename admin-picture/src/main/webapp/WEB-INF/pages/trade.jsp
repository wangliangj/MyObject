<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-14
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.8.3.js"></script>
</head>
<body>
<h3>当前操作转账，请按要求填写后点击"转账"按钮</h3>
<form id="tradeForm">
    <table align="center">
        <tr>
            <td>卡号：</td>
            <td><input name="card"></td>
        </tr>
        <tr>
            <td>金额：</td>
            <td><input name="amount"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="修改" onclick="trade()"></td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function trade() {
        $.ajax({
            url:"<%=request.getContextPath()%>/trade.html",
            data:$("#tradeForm").serialize(),
            type:"post",
            success:function (result) {

            }

        })


    }


</script>


</body>
</html>
