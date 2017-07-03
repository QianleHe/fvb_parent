<%--
  Created by IntelliJ IDEA.
  User: wuqi
  Date: 6/28/17
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import= "com.foodvotebox.pojo.FvbFriend" %>
<%@ page import= "java.util.List" %>
<html>
<head>
    <title>Friend List</title>
</head>
<body>
<%--<form name="DeleteFriend" action="/fvb_web/deleteFriend/do" method="post" >--%>
    <%--<table width="300" border="1" align="center">--%>
        <%--<tr><td colspan="2">FriendInfo</td></tr>--%>
        <%--<tr><td>FriendName:</td><td><input name="friendname" ></td></tr>--%>
        <%--<tr><td colspan="2"><input type="submit" value="Delete Friend"/></td></tr>--%>
    <%--</table>--%>
<%--</form>--%>

<h1>Friends list</h1>
<div id="FriendDiv">
    <table id="FriendTable">
        <div id="InitialFriendDisplay">
            <tr>
                <td>UserId</td>
                <td>UserName</td>
            </tr>
            <%
                List<FvbFriend> list = (List)request.getAttribute("friendList");
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%=list.get(i).getFriendid() %></td>
                <td><%=list.get(i).getFriendname() %></td>
                <td><input type="submit" value="Delete" id="<%=list.get(i).getFriendid()%>" onclick="deleteFriend(<%=list.get(i).getFriendid()%>)"/></td>
            </tr>
            <%
                }
            }else{
            %>
            <tr><td colspan="6">No data in the database！</td></tr>
            <%
                }
            %>
        </div>
        <div id = "showdiv"></div>
    </table>
</div>
<table>
    <tr>
        <td>Friend Info:</td>
        <td><input id="friendInput" placeholder="enter name or e-mail" onblur="checkFriend();"></td>
        <td><input id="submitFriend" type="submit" name="add" onclick="addFriend();"></td>
    </tr>
</table>
<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
<script>
    function deleteFriend(friendId){
        $.ajax({
            data: {friendId: friendId},
            type: "GET",
            dataType: "json",
            url: "deleteFriend",
            success: function(result){
                if (result) {
                    $("#showdiv").empty();
                    $("#FriendTable").remove();
                    var panelTable = $("<table></table>");
                    var panelheader = $("<tr><td>UserId</td> <td>UserName</td> <td></td></tr>");
                    for(a of result) {
                        var panelBody = $("<tr></tr>");
                        var panelBodyId = $("<td></td>").text(a.friendId);
                        var panelBodyName = $("<td></td>").text(a.friendname);
                        var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
                        panelBodyDelete.attr("onclick", "deleteFriend("+a.friendId+")");
                        panelBodyDelete.attr("id", a.friendId);
                        panelBodyDelete = $("<td></td>").append(panelBodyDelete);
                        panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);
                        panelTable.append(panelBody);
                    }

                    $("#showdiv").append(panelheader,panelTable);
                }
            },
            error: function(){
                alert("Delete friend failed");
            }
        });
    }
</script>
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
<script>
    function addFriend(){
        var data = {friendInput: $("#friendInput").val()};
        $.ajax({
            data: data,
            type: "GET",
            dataType: "json",
            url:"addFriend/bool",
            success: function(result){
                if (result) {
                    $("#showdiv").empty();
                    $("#FriendTable").remove();
                    var panelTable = $("<table></table>");
                    var panelheader = $("<tr><td>UserId</td> <td>UserName</td> <td></td></tr>");
                    for(a of result) {
                        var panelBody = $("<tr></tr>");
                        var panelBodyId = $("<td></td>").text(a.friendid);
                        var panelBodyName = $("<td></td>").text(a.friendname);
                        var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
                        panelBodyDelete.attr("onclick", "deleteFriend("+a.friendid+")");
                        panelBodyDelete.attr("id", a.friendid);
                        panelBodyDelete = $("<td></td>").append(panelBodyDelete);
                        panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);
                        panelTable.append(panelBody);
                    }

                    $("#showdiv").append(panelheader,panelTable);
                }
            },
            error: function(){
                alert("Add friend failed");
            }
        });
    }
</script>
</body>
</html>