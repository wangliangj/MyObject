<%@ page import="java.util.List" %>
<%@ page import="com.qfedu.rain.pojo.Station" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-06-27
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

    </script>


</head>
<body>
<form action="doeditinfo">
    区域:<input type="text" name="area" value=""><br>
    监测站：<select  name="sid">
    <%
        List<Station> stations = (List<Station>) request.getAttribute("allStation");
        for (int i = 0; stations!=null&&i < stations.size(); i++) {
            Station station = stations.get(i);
            out.print("<option value='"+station.getId()+"' >"+station.getName()+"</option>");
        }

    %>


</select>
    <a href="addstation">+添加监测站</a><br>
    最大降雨量：<input type="text" name="maxrainfall" id="maxrainfall"  /><br>
    最小降雨量：<input type="text" name="minrainfall"  id="minrainfall" /><br>
    降雨日期<input type="text" name="raintime" id="raintime"><br>
    <button id="button" >添加</button>
</form>
</body>
</html>
