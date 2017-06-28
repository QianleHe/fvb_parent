<%--
  Created by IntelliJ IDEA.
  User: wuqi
  Date: 6/28/17
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>delete Friend</title>
</head>
<body>
<form name="DeleteFriend" action="/fvb_web/deleteFriend/do" method="post" >
    <table width="300" border="1" align="center">
        <tr><td colspan="2">FriendInfo</td></tr>
        <tr><td>FriendName:</td><td><input name="friendname" ></td></tr>
        <tr><td colspan="2"><input type="submit" value="Delete Friend"/></td></tr>
    </table>
</form>
</body>
</html>