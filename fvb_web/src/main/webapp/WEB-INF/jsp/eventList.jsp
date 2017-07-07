<%--
  Created by IntelliJ IDEA.
  User: FYG
  Date: 17/6/29
  Time: 下午5:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.foodvotebox.pojo.DBEventReturnType" %>
<html>
<head>
    <title>${user.username}'s events</title>
</head>
<body>
    <h1>Your events</h1>
    <div id="memberDiv">
        <table id="memeberTable">
            <tr>
                <td>Event ID</td>
                <td>Event Name</td>
                <td>Event Date</td>
                <td>Created By</td>
                <td>Description</td>
                <td>Already voted</td>
                <%--<td>Edit event</td>--%>
            </tr>
            <%
                List<DBEventReturnType> list = (List)request.getAttribute("eventList");
                if (list.size() != 0) {
                    for (int i = 0; i < list.size(); i++) {
            %>
            <tr>
                <td><%=list.get(i).getEventId() %></td>
                <td><a href="/fvb_web/event<%=list.get(i).getEventId()%>"><%=list.get(i).getEventName() %></a></td>
                <td><%=list.get(i).getEventDate() %></td>
                <td><%=list.get(i).getUserName() %></td>
                <td><%=list.get(i).getDescription() %></td>
                <td><%=list.get(i).isVoted() %></td>
                 <%
                    if (list.get(i).getMemberId() == list.get(i).getOwnerId()) {
                 %>
                <td>
                    <form action="/fvb_web/listEvent<%=list.get(i).getEventId()%>/deleteEvent" method="POST">
                        <button type="sumbit">Delete event</button>
                    </form>
                </td>
                 <%
                    }
                 %>
            </tr>
            <%
                }
            }else{
            %>
            <tr><td colspan="6">Your don't have any event</td></tr>
            <%
                }
            %>
        </table>
    </div>
</body>
</html>
