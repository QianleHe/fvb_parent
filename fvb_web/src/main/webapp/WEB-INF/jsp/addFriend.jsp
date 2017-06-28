<%--
  Created by IntelliJ IDEA.
  User: wuqi
  Date: 6/27/17
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Friend</title>
</head>
<body>
<form name="AddFriend" action="/fvb_web/addFriend/do" method="post" >
    <table width="300" border="1" align="center">
        <tr><td colspan="2">UserInfo</td></tr>
        <tr><td>FriendName:</td><td><input name="friendname" ></td></tr>
        <tr><td colspan="2"><input type="submit" value="Add Friend"/></td></tr>
    </table>
</form>
</body>
</html>
