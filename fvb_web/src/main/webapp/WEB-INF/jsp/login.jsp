<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/17/17
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <br>
    <br>
    <br>
    <br>
    <br>
    <form name="form1" action="/fvb_web/login" method="post" >
        <table width="300" border="1" align="center">
            <tr>
                <td colspan="2">Login window</td>
            </tr>
            <tr>
                <td>UserName:</td>
                <td><input type="text" name="email">
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input  type="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="submit" value="Signin"/>
                </td>
            </tr>
        </table>
        <a href="/fvb_web/register">Do not have account? Sign up</a>
    </form>
</body>
</html>
