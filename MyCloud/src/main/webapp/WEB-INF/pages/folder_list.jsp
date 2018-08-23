<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-07-18
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.10.2.min.js"></script>
</head>
<body>
欢迎光临： <h2 style="display:inline-block">${sessionScope.SESSION_USER.username}</h2> <a href="#">退出登录</a>
<table border="1">
    <tr ><td colspan="3"><input type="button" value="+创建文件夹" onclick="$('#inputTr').show()"></td></tr>
    <tr>
        <td>文件夹</td>
        <td>大小</td>
        <td>修改日期</td>
        <td>操作</td>
    </tr>

        <c:forEach items="${dirlist}" var="dir">
            <tr id="${dir.id}">
                <td id="td-${dir.id}"><a href="<%=request.getContextPath()%>/file/list.html?id=${dir.id}">${dir.name}</a></td>
                <td>${dir.size}</td>
                <td><fmt:formatDate value="${dir.updateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td><a href="#" class="updateFolder" id="update-${dir.id}" onclick="upFolder(${dir.id})">修改</a><a href="#"  onclick="delFolder(${dir.id})" >删除</a></td>
            </tr>
        </c:forEach>
    <tr id="inputTr" style="display: none">
        <td colspan="4"><input id="newName"><input type="button" value="确定" onclick="addFolder()"><input type="button" value="取消" onclick="$('#inputTr').hide()"></td>
    </tr>

</table>
<script type="text/javascript">

    function upFolder(id){
        var t = $("#td-"+id+"");
        t.html("<input id='upip' type='text'value='"+$(t).text()+"'/>");
        var ival = $("#upip").val();
        $("#upip").blur(function () {
       $.get("<%=request.getContextPath()%>/dir/update.html",{"id":id,"name":$("#upip").val()},function (result) {
           if (result.status){
                   var va = $("#upip").val();
                   t.html("<a href='<%=request.getContextPath()%>/file/list.html?id=${id}'>"+va+"</a>")

               }

       })
    })
    }
    /*$(function () {
        $(".updateFolder").each(function (i, obj) {
            $(obj).click(function () {
                var td = $(this).parents("tr").find("td:eq(0)");
                var name = td.text();
                var form= $("<form>");
                var input = $("<input name='name' value='" + name + "'>");
                var id = $(obj).attr("id").split("-")[1];
                input.blur(function () {
                    $.ajax({
                        url:"<%=request.getContextPath()%>/dir/update.html",
                        data:$(this).parents("form").serialize(),
                        method: "post",
                        success:function (result) {
                            if (result.status) {
                                td.html("<a  href='<%=request.getContextPath()%>/file/list.html?id='"+id+">" + result.dir.name + "</a>");
                                $(td).parents("tr").find("td:eq(2)").html(result.dir.updateTime);
                            }
                        }
                    })
                })
                form.append(input);
                form.append("<input name='id' value='"+$(obj).attr("id").split("-")[1]+"' type='hidden'>")
                td.html(form);
            })
        });
    })*/
    
    function addFolder() {
        $.ajax({
            url: "<%=request.getContextPath()%>/dir/add.html",
            data:"name="+$("#newName").val(),
            method: "post",
            success:function (result) {
                if (result.status) {
                    $('#inputTr').hide();
                    var tr = "<tr>\n" +
                        "                <td><a href=\"#\">"+result.cloudDir.name+"</a></td>\n" +
                        "                <td>0M</td>\n" +
                        "                <td>"+result.cloudDir.updateTime+"</td>\n" +
                        "                <td><a href=\"#\">修改</a><a href=\"#\">删除</a></td>\n" +
                        "            </tr>";
                    $("#inputTr").before(tr);
                }
            }

        });
    }

    function delFolder(id) {

        alert(id)
        $.ajax({
            url: "<%=request.getContextPath()%>/dir/delete.html",
            data:"id="+id,
            method: "post",
            success:function (result) {
                if (result.status) {

                    $("#"+id).remove();
                }
            }

        });
    }

</script>


</body>
</html>
