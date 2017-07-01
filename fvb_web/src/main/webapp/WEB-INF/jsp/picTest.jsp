<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/29/17
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PicTestPage</title>
</head>
<body>
    <form action="/fvb_web/upload" method="post" enctype="multipart/form-data">
    Choose a file:<input type="file" name="file">
    <input type="submit" value="submit">
</form>
</body>
</html>
