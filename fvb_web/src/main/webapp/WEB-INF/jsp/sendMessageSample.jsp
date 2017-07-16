<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 7/7/17
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send a Message to others</title>
</head>
<body>
    <form name="MessageSend" action="/fvb_web/addMessage" method="post" >
        <table width="300" border="1" align="center">
            <tr><td colspan="2">Message</td></tr>
            <tr><td>To:</td>
                <td id="friend">
                </td>
            </tr>
            <tr><td>Content:</td><td><input name="content"></td></tr>
            <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
        </table>
    </form>
</body>



<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
<script>
    $(function (){
        displayFriend();
    });
    function displayFriend(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "displayFriendList",
            success: function(result){
                if (result) {
                    $("#friend").empty();
                    var aa = $("<select></select>");
                    aa.attr("name", "toId");
                    for(a of result) {
                        var b = $("<option></option>").text(a.friendname);
                        b.attr("value", a.friendid);
                        aa.append(b);
                    }
                    $("#friend").append(aa);

                }
            },
            error: function(){
                alert("Delete friend failed");
            }
        });
    }

</script>
</html>
