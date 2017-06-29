<%@ page import="com.foodvotebox.pojo.DBEventMemberReturnType" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: FYG
  Date: 17/6/23
  Time: 下午2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${event.eventName}</title>
</head>
<body>
    <%--<h1>${memberList.get(0)}</h1>--%>
    <h1>${event.eventName}</h1>
    <h2>The event will be hold on ${event.eventDate}</h2>
    <p>${event.description}</p>
    <a href="/fvb_web/event${event.eventId}/deleteEvent">Delete</a>
    <%--<button type="submit" href="/fvb_web/event${event.eventId}/deleteEvent">Next</button>--%>
    <h1>Add restaurants </h1>
    <input type="text" name="restaurantName" id="restaurantName"/>
    <input type="submit" value="Add" onclick="addRestaurant();"/>

    <h1>Add Members </h1>
    <input type="text" name="memberName" id="memberName"/>
    <input type="submit" value="Add" onclick="addMember();"/>
    <div id="memberDiv">
        <table id="memeberTable">
            <div id="InitialMemberDisplay">
                <tr>
                    <td>UserId</td>
                    <td>UserName</td>
                </tr>
                <%
                    List<DBEventMemberReturnType> list = (List)request.getAttribute("memberList");
                    if (list.size() != 0) {
                        for (int i = 0; i < list.size(); i++) {
                %>
                <tr>
                    <td><%=list.get(i).getMemberId() %></td>
                    <td><%=list.get(i).getUserName() %></td>
                    <td><input type="submit" value="Delete" id="<%=list.get(i).getMemberId()%>" onclick="deleteMember(<%=list.get(i).getMemberId()%>)"/></td>
                </tr>
                <%
                    }
                }else{
                %>
                <tr><td colspan="6">数据库中没有数据！</td></tr>
                <%
                    }
                %>
            </div>
            <div id = "showdiv"></div>
        </table>
    </div>


    <script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
    <script src="../fvb_web/js/eventPage.js"></script>
    <script>
        function addRestaurant(){
            var data = {restaurantName: $("#restaurantName").val()};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "text",
                url:"listEvent" + "${event.eventId}" + "/addRestaurant",
                success: function(result){
                    //alert(result)
                    if(result == "true")
                    {
                        alert("Add restaurant successfully!!!");
                    }
                    else {
                        alert("No such restaurant or you have already added this restaurant");
                    }
                }
            });
        }
    </script>
    <script>
        $("#restaurantName").blur(function () {
            if ($(this).val()) {
                var data = {restaurantName: $(this).val()};
                console.log(data);
                $.ajax({
                    type: "GET",
                    url: "listEvent" + "${event.eventId}" + "/validRestName",
                    data: data,
                    dataType: "text",
                    success: function(result){
                        //alert(result)
                        if(result == "true")
                        {
                            $("#restaurantName").css("border", "5px solid green")
                        }
                        else if(result == "false"){
                            $("#restaurantName").css("border", "5px solid red");
                        }
                    }
                })
            }
        })
    </script>
    <script>
        $("#memberName").blur(function () {
            if ($(this).val()) {
                var data = {memberName: $(this).val()};
                $.ajax({
                    type: "GET",
                    url: "listEvent" + "${event.eventId}" + "/validMemberName",
                    data: data,
                    dataType: "text",
                    success: function(result){
                        //alert(result)
                        if(result == "true")
                        {
                            $("#memberName").css("border", "5px solid green")
                        }
                        else if(result == "false"){
                            $("#memberName").css("border", "5px solid red");
                        }
                    }
                })
            }
        })
    </script>
    <script>
        function addMember(){
            var data = {memberName: $("#memberName").val()};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "json",
                url:"listEvent" + "${event.eventId}" + "/addMember",
                success: function(result){
                    if (result) {
                        $("#showdiv").empty();
                        $("#memeberTable").remove();
                        var panelTable = $("<table></table>");
                        var panelheader = $("<tr><td>UserId</td> <td>UserName</td> <td></td></tr>");
                        for(a of result) {
                            var panelBody = $("<tr></tr>");
                            var panelBodyId = $("<td></td>").text(a.memberId);
                            var panelBodyName = $("<td></td>").text(a.userName);
//                            var url = "listEvent" + a.eventid + "/deleteMember" + a.memberId;
                            var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
//                            panelBodyDelete.attr("href", url);
                            panelBodyDelete.attr("id", a.memberId);
                            panelBodyDelete.attr("onclick", "deleteMember("+a.memberId+")");
                            panelBodyDelete = $("<td></td>").append(panelBodyDelete);
                            panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);
                            panelTable.append(panelBody);
                        }

                        $("#showdiv").append(panelheader,panelTable);
                    }
                },
                error: function(){
                    alert("No such user or you have already added this user");
                }
            });
        }
    </script>
    <script>
        function deleteMember(memberId){
            $.ajax({
                data: {memberId: memberId},
                type: "GET",
                dataType: "json",
                url:"listEvent" + "${event.eventId}" + "/deleteMember",
                success: function(result){
                    if (result) {
                        $("#showdiv").empty();
                        $("#memeberTable").remove();
                        var panelTable = $("<table></table>");
                        var panelheader = $("<tr><td>UserId</td> <td>UserName</td> <td></td></tr>");
                        for(a of result) {
                            var panelBody = $("<tr></tr>");
                            var panelBodyId = $("<td></td>").text(a.memberId);
                            var panelBodyName = $("<td></td>").text(a.userName);
//                            var url = "listEvent" + a.eventid + "/deleteMember" + a.memberId;
                            var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
                            panelBodyDelete.attr("onclick", "deleteMember("+a.memberId+")");
                            panelBodyDelete.attr("id", a.memberId);
                            panelBodyDelete = $("<td></td>").append(panelBodyDelete);
                            panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);
                            panelTable.append(panelBody);
                        }

                        $("#showdiv").append(panelheader,panelTable);
                    }
                },
                error: function(){
                    alert("Delet member failed");
                }
            });
        }
    </script>
</body>
</html>
