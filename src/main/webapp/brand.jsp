<%--
  Created by IntelliJ IDEA.
  User: dai.yue
  Date: 2023/3/10
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${user.username}</h1>
<table>
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status ==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>
            <td><a href="/brand_demo/SelectByIdServlet?id=${brand.id}">修改</a> <a href="#">删除</a> </td>
        </tr>

    </c:forEach>


</table>
<input type="button" value="add" id="add"><br>
<script>
    document.getElementById("add").onclick = function(){
        location.href = "/brand_demo/addBrand.jsp";
    }
</script>
</body>


</html>
