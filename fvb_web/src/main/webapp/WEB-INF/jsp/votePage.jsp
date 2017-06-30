<%--
  Created by IntelliJ IDEA.
  User: FYG
  Date: 17/6/28
  Time: 下午10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.foodvotebox.pojo.DBEventMemberReturnType" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>${event.eventName}</title>
</head>
<body>

<h1>${event.eventName}</h1>
<h2>Hi! ${user.username}</h2>
<h2>The event will be hold on ${event.eventDate}</h2>
<p>${event.description}</p>
<%--<button type="submit" href="/fvb_web/event${event.eventId}/deleteEvent">Next</button>--%>
<h1>restaurants</h1>

<h1>Members</h1>
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
    </table>
</div>


<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
</body>
</html>

