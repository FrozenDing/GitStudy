<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form action="/userServlet" method="post">
    <input name="name">
    <input name="age">
    <input type="submit" value="Submit" />
</form>
<h1>文件提价表单：</h1>
<form action="${pageContext.request.contextPath}/save20" method="post" enctype="multipart/form-data">

    名称：<input type="text" name="name"><br>
    文件：<input type="file" name="dingFile"><br>
    <input type="submit" value="提交"><br>

</form>
</body>
</html>