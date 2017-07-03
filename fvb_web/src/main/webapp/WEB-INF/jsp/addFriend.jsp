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
    <table width="500" border="1" align="center">
        <tr><td colspan="2">FriendInfo</td></tr>
        <tr><td>FriendName:</td><td><input name="friendname" id="friendInput" placeholder="enter name or e-mail" onblur="checkFriend();" style="width: 200px"></td></tr>
        <tr><td colspan="2"><input type="submit" value="Add Friend"/></td></tr>
    </table>
</form>
<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
<script>
    function checkFriend() {
        var data = {friendInput: $("#friendInput").val()};
        $.ajax({
            data: data,
            type: "GET",
            dataType:"text",
            url:"checkFriend",
            success: function(result){
                if(result == "true")
                {
                    $("#friendInput").css("border", "5px solid green")
                }
                else if(result == "false"){
                    $("#friendInput").css("border", "5px solid red");
                }
            }
        });
    }

</script>

</body>
</html>
