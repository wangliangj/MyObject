<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-16
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
<h3 align="center">宠物的基本信息</h3>
<form action="#" id="myForm" method="post">
    昵称:<input name="name" id="name" ><br/>
    品总:<select name="kind" id="kind">
                <option>--请选择--</option>
                <option>狗</option>
                <option >猫</option>
                <option>鸟</option>
                <option>鼠</option>
</select><br/>
    性别:<input type="radio" name="sex" value="雌">雌
        <input type="radio" name="sex" value="雄">雄<br/>
    出生日期:<input type="date" name="birthday" id="birthday"><br/>
    宠物描述:<input name="description" id="description"><br/>
    <input type="button" value="提交" onclick="return changeForm()">
    <input type="button" value="重置" onclick="changeRep()">

</form>
<script type="text/javascript">
    function changeForm(){
        $.ajax({
            url:"<%=request.getContextPath()%>/add.html",
            data:$("#myForm").serialize(),
            type:"post",
            success:function (result) {
                if (result.error != null) {
                    alert(result.error);
                } else {
                    alert(result.message);
                }
            }


        });

        return false;
    }



    function changeRep() {
        $("#myForm")[0].reset();
    }

</script>

</body>
</html>
