<%@ page import="java.util.List" %>
<%@ page import="com.qfedu.rain.pojo.Station" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-06-26
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="js/my.js"></script>
    <script type="text/javascript" >
        var xml = getXMLHttpRequest();

        function onchange() {
            xml.onreadystatechange=function () {
                if (xml.readyState == 4 && xml.status == 200) {
                    var text = xml.responseText;
                   var jsonObject= JSON.parse(text);

                    var html = "";
                    var html=html+" <tr><td>id</td> <td>监测站名称</td><td>操作</td></tr>"
                    for (var i = 0;jsonObject!=null&&i < jsonObject.length; i++) {
                        var station = jsonObject[i];
                        html = html + "<tr><td>" + station.id + "</td>";
                        html = html + " <td>" + station.name + "</td>";
                        html = html + "<td><a href='deletestation?id="+station.id+"'>删除</a></td></tr>";
                    }
                    document.getElementById("table").innerHTML = html;

                }
            };
            var url ="showstationlist"
            xml.open("post", url);
            xml.send();

            return false;
        }

        onchange();




    </script>


</head>
<body>
<a href="addstation">+添加监测站</a>
<a href="info">雨量信息列表</a><br>
<form action="#" >
<table border="1" id="table" name="table" >




</table>
</form>
</body>
</html>
