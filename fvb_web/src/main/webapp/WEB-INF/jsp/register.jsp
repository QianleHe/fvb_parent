<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/18/17
  Time: 4:29 PM
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
        <form name="form1" action="/fvb_web/register/do" method="post" >
            <table width="300" border="1" align="center">
                <tr>
                    <td colspan="2">Register</td>
                </tr>
                <tr>
                    <td>UserName:</td>
                    <td><input type="text" name="friendname">
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input  type="text" name="email"/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input  type="password" name="password"/>
                    </td>
                </tr>
                <tr>
                    <td>PhoneNumber:</td>
                    <td><input  type="text" name="phone"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="submit" value="Sign up"/>
                    </td>
                </tr>
            </table>
        </form>

</body>
</html>
