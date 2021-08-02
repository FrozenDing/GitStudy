<%--
  Created by IntelliJ IDEA.
  User: d2013
  Date: 2021/7/28
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/save14" method="post">
    <input type="text" name="userList[0].username">
    <input type="text" name="userList[0].age">
    <input type="text" name="userList[1].username">
    <input type="text" name="userList[1].age">
    <input type="submit" value="提交">
</form>
</body>
</html>
