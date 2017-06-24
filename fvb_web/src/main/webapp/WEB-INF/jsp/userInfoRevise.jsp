<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/22/17
  Time: 4:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserInfoRevise</title>
</head>
<body>
    <form name="UserInfoRevise" action="/fvb_web/doUpdate" method="post" >
        <table width="300" border="1" align="center">
            <tr><td colspan="2">UserInfo</td></tr>
            <tr><td>UserName:</td><td><input name="username" value=${user.username}></td></tr>
            <tr><td>Email:</td><td><input name="email" value=${user.email}></td></tr>
            <tr><td>PhoneNumber:</td><td><input name="phone" value=${user.phone}></td></tr>
            <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
        </table>
    </form>
</body>
</html>
