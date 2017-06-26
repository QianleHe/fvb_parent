<%--
  Created by IntelliJ IDEA.
  User: FYG
  Date: 17/6/22
  Time: 下午5:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start an event</title>
</head>
<body>
    <form id="listEventForm" action="/fvb_web/listSuccess" method="POST">
        <div class="form-group">
            <p> Fields with an asterisk (*) are required </p>
        </div>
        <div class="form-group">
            <label for="eventName"> * Listing Title: </label>
            <input type="text" class="form-control" name="eventName" id="eventName" placeholder="Listing Title" required>
        </div>
        <div class="form-group">
            <label for="eventDate"> * Event date: </label>
            <input type="datetime" class="form-control" name="eventDate" id="eventDate" placeholder="Event date" required>
        </div>
        <div class="form-group">
            <label for="description"> Description: </label>
            <br>
            <textarea rows="5" cols="55" name="description" id="description"></textarea>
        </div>
        <button type="submit" class="btn btn-default">Next</button>
    </form>
</body>
</html>
