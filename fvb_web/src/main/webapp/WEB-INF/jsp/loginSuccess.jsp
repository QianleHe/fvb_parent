<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/17/17
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Login Success!
<br>
    Hello!${user.friendname}

    <br>
    <a href = "/fvb_web/memberinfo">Check my infomation</a><br>
    <a href = "/fvb_web/">Return to login page</a><br>
    <a href = "/fvb_web/logout">Log out!</a><br>
    <a href="/fvb_web/userInfo">Check UserInfo</a><br>
    <a href="/fvb_web/updateUser">updateInfo</a><br>
    <a href="/fvb_web/updatePassword">updatePassword</a>


    <form name="UserInfo" method="get" >
        <table width="300" border="1" align="center">
            <tr>
                <td colspan="2">UserInfo</td>
            </tr>
            <tr>
                <td>UserName:</td>
                <td>${user.username}
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${user.email}
                </td>
            </tr>
            <tr>
                <td>PhoneNumber:</td>
                <td>${user.phone}
                </td>
            </tr>
            <tr>
                <td>CreateTime:</td>
                <td>${user.created}
                </td>
            </tr>
        </table>
    </form>
</body>

<%--<script>--%>
    <%--function generateInfo(Object userInfo){--%>
        <%--var html;--%>
        <%--html += "<form name="UserInfo" method="get"> <table width="300" border="1" align="center">";--%>
        <%--html += "<tr><td colspan="2">UserInfo</td></tr>";--%>
        <%--for(var key in jsonObj){--%>
            <%--html += "<tr><td>key + ":"</td><td>userInfo[key]</td></tr>"--%>
            <%--$("#out").append(html);--%>
        <%--}--%>
        <%--html += "</table></form>";--%>
    <%--}--%>
<%--</script>--%>
<script>
    $.ajax({
        url:"/fvb_web/userInfo",
        method:"GET",
        dataType:"json",
        success:function(user) {
            alert("received JSON:" + JSON.stringify(user));//把json的数据打印出来
        },
        error:function() {
            alert("error");
        }
    });
</script>
</html>
