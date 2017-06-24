<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/22/17
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="UserPasswordRevise" action="/fvb_web/updatePassword/do" method="post" >
        <table width="300" border="1" align="center">
            <tr><td colspan="2">UpdatePassword</td></tr>
            <%--<tr><td>UserName:</td><td><input name="username" value=${user.username}></td></tr>--%>
            <tr><td>OldPassword:</td><td><input name="oldpassword"></td></tr>
            <tr><td>NewPassword:</td><td><input name="newpassword"></td></tr>
            <tr><td>Retype your newPassword:</td><td><input name="retypepassword"></td></tr>
            <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
        </table>
    </form>
</body>
</html>
