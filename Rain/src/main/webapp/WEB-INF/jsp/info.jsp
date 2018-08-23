<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-06-25
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息</title>
    <script type="text/javascript" src="js/my.js"></script>
    <script type="text/javascript">

        var pageNo = 1;
        var pageSum = 0;
        /*  function gopage(n) {
              if (pageNo+n>0&&pageNo+n<=pageSum){
                  pageNo=pageNo+n;
                  onbuttonclick(pageNo)
              }
          }*/

        function onbuttonclick(pageno) {
            var xml = getXMLHttpRequest();
            xml.onreadystatechange = function () {
                if (xml.readyState == 4 && xml.status == 200) {
                    var jsonStr = xml.responseText;
                    var jsonObject = JSON.parse(jsonStr);
                    pageNo = jsonObject.pageNo;
                    pageSum = jsonObject.pageSum;

                    var array = jsonObject.list;
                    var html = "";
                    for (var i = 0; array != null && i < array.length; i++) {
                        var info = array[i];
                        var station = info.station
                        if (i == 0) {
                            html = html + "<tr><td>id</td><td>区域</td><td>监测日期</td><td>监测站</td><td>雨量范围</td><td>操作</td></tr>";
                        }
                        html = html + "<tr><td>" + info.id + "</td><td>" + info.area + "</td><td>" + info.raintime + "</td><td>" + station.name + "</td><td>" + info.minrainfall + "-" + info.maxrainfall + "</td><td><a href='editinfo?id="+info.id+"' >修改</a><a href='deleteinfo?id="+info.id+"' >删除</a></td></tr>";

                    }
                    //使得table中的innerHTML是html1
                    document.getElementById("table").innerHTML = html;

                    //在网页上显示按钮
                    var divpages = document.getElementById("divpages");
                    var html1 = "<button onclick='gopage(-1)' >上一页</button>"
                    var html2 = "";
                    for (var i = 0; i < pageSum; i++) {
                        html2 = html2 + "<button onclick='onbuttonclick(" + (i + 1) + ")' >" + (i + 1) + "</button>"
                    }
                    var htmllast = "<button onclick='gopage(1)' >下一页</button>"

                    divpages.innerHTML = html1 + html2 + htmllast;
                }
            };
            var url = "showrainbypage?pageNo=" + pageno + "&pageSize=2";
            xml.open("get", url);
            xml.send();
            return false;
        }

        function gopage(n) {
            if (pageNo + n > 0 && pageNo + n <= pageSum) {
                pageNo = pageNo + n;
            }
            onbuttonclick(pageNo);
        }
        onbuttonclick(1);

        function gopages(n) {
            if (pageNo + n > 0 && pageNo + n <= pageSum) {
                pageNo = pageNo + n;
            }
            onbuttonclicks(pageNo);
        }



        function onbuttonclicks(pageno) {
            var xmlhttp = getXMLHttpRequest();
            var area = document.getElementById("area").value;
            xmlhttp.onreadystatechange=function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var text = xmlhttp.responseText;
                   var jsonObject = JSON.parse(text);
                   pageNo= jsonObject.pageNo;
                    pageSum = jsonObject.pageSum;
                    var array = jsonObject.list;
                    var html = "";
                    html = html + "<tr><td>id</td><td>区域</td><td>监测日期</td><td>监测站</td><td>雨量范围</td><td>操作</td></tr>";
                    for (var i = 0; array!=null&&i < array.length; i++) {
                        var info = array[i];
                        var station = info.station;
                        html = html + "<tr><td>" + info.id + "</td><td>" + info.area + "</td><td>" + info.raintime + "</td><td>" + station.name + "</td><td>" + info.minrainfall + "-" + info.maxrainfall + "</td><td><a href='#' >修改</a><a href='deleteinfo?id="+info.id+"' >删除</a></td></tr>";

                    }
                    document.getElementById("table").innerHTML = html;

                    //在网页上显示按钮
                    var divpages = document.getElementById("divpages");
                    var html1 = "<button onclick='gopages(-1)' >上一页</button>";
                    var html2 = "";
                    for (var i = 0; i < pageSum; i++) {
                        html2 = html2 + "<button onclick='onbuttonclicks(" + (i + 1) + ")' >" + (i + 1) + "</button>";
                    }
                    var htmllast="<button onclick='gopages(1)' >下一页</button>"
                }
            };
            var url = "showrainbyareapage?pageNo="+pageno+"&pageSize=2&area="+area;
            xmlhttp.open("get",url);
            xmlhttp.send();

        }



    </script>


</head>
<body  >
区域名称：<input type="text" id="area" name="area"/>
<button onclick="return onbuttonclicks(1);">搜索</button>
<a href="addinfo">+添加监测记录</a>
<a href="stationlist">+监测站管理</a><br/>
<table border="1" name="table" id="table">
    <%-- <tr>
         <td>id</td>
         <td>区域</td>
         <td>监测日期</td>
         <td>监测站</td>
         <td>雨量范围</td>
         <td><a href="#"></a> <a href="#"></a></td>
     </tr>--%>

</table>
<div name="divpages" id="divpages">


</div>

</body>
</html>
