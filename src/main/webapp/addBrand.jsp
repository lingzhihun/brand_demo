<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2023/3/11
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/brand_demo/AddServlet" method="post">
  品牌名称：<input name="brandName"><br>
  企业名称：<input name="companyName"><br>
  排序：<input name="ordered"><br>
  描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
  状态：
  <input type="radio" name="status" value="0">禁用
  <input type="radio" name="status" value="1">启用<br>

  <input type="submit" value="提交">
</form>
</body>
</html>
