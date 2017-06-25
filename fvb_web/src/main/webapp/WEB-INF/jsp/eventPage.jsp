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
    <h1>${event.eventName}</h1>
    <h2>The event will be hold on ${event.eventDate}</h2>
    <p>${event.description}</p>
    <a href="/fvb_web/event${event.eventId}/deleteEvent">Delete</a>
    <%--<button type="submit" href="/fvb_web/event${event.eventId}/deleteEvent">Next</button>--%>
</body>
</html>
