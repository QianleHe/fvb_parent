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
    <div id="restaurantDiv">
        <div id = "showRestaurantdiv"></div>
    </div>

    <h1>Members</h1>
    <div id="memberDiv">
        <div id = "showdiv"></div>
    </div>
    <br/>
    <a href="/fvb_web/myEvents"> Return to my events</a>
    <br/>


<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
    <script>
        function DisplayMember(result) {
            $("#showdiv").empty();
            var panelTable = $("<table></table>");
            var panelheader = $("<tr><td>UserId</td> <td>UserName</td> </tr>");
            for(a of result) {
                var panelBody = $("<tr></tr>");
                var panelBodyId = $("<td></td>").text(a.memberId);
                var panelBodyName = $("<td></td>").text(a.userName);
                panelBody.append(panelBodyId,panelBodyName);
                panelTable.append(panelBody);
            }
            $("#showdiv").append(panelheader,panelTable);
        }

        $(function (){
            initialDisplayMember();
        });
        function initialDisplayMember() {
            $.ajax({
                type: "GET",
                dataType: "json",
                url:"event" + "${event.eventId}" + "/displayMember",
                success: function(result){
                    if (result) {
                        DisplayMember(result);
                    }
                },
                error: function(){
                    alert("Display member failed");
                }
            });
        }
    </script>
    <script>
        function displayRestaurant(result) {
            $("#showRestaurantdiv").empty();
            var panelTable = $("<table></table>");
            var panelHeader = $("<tr><td>RestaurantName</td> <td>Location</td> <td>Price</td> <td>Link</td> <td>Votes</td></tr>");
            for(a of result) {
                var panelBody = $("<tr></tr>");
                var panelBodyName = $("<td></td>").text(a.restaurantName);
                var panelBodyLocation = $("<td></td>").text(a.address + "," + a.city);
                var panelBodyPrice = $("<td></td>").text(a.price);
                var panelBodyVotes = $("<td></td>").text(a.votes);
                var panelBodyLink = $("<a></a>").text("Details");
                panelBodyLink.attr("href", a.yelpUrl);
                panelBody.append(panelBodyName,panelBodyLocation,panelBodyPrice,panelBodyLink);
                var panelBodyVote = $("<input type=\"submit\" value=\"Vote it\" />")
                panelBodyVote.attr("onclick", "voteRestaurant("+a.restaurantId+")");
                //panelBodyVote.attr("id", a.restaurantId);
                if (!${curUser.voted}) {
                    panelBodyVote = $("<td></td>").append(panelBodyVote);
                    panelBody.append(panelBodyVote);
                } else {
                    panelBody.append(panelBodyVotes);
                }
                panelTable.append(panelBody);
            }
            $("#showRestaurantdiv").append(panelHeader,panelTable);
        }

        function displayRestaurantAfterVoted(result) {
            $("#showRestaurantdiv").empty();
            var panelTable = $("<table></table>");
            var panelHeader = $("<tr><td>RestaurantName</td> <td>Location</td> <td>Price</td> <td>Link</td> <td>Votes</td> </tr>");
            for(a of result) {
                var panelBody = $("<tr></tr>");
                var panelBodyName = $("<td></td>").text(a.restaurantName);
                var panelBodyLocation = $("<td></td>").text(a.address + "," + a.city);
                var panelBodyPrice = $("<td></td>").text(a.price);
                var panelBodyVotes = $("<td></td>").text(a.votes);
                var panelBodyLink = $("<a></a>").text("Details");
                panelBodyLink.attr("href", a.yelpUrl);
                panelBody.append(panelBodyName,panelBodyLocation,panelBodyPrice,panelBodyLink,panelBodyVotes);
                panelTable.append(panelBody);
            }
            $("#showRestaurantdiv").append(panelHeader,panelTable);
        }

        $(function (){
            initialDisplayRestaurant();
        });
        function initialDisplayRestaurant() {
            $.ajax({
                type: "GET",
                dataType: "json",
                url:"event" + "${event.eventId}" + "/displayRestaurant",
                success: function(result){
                    if (result) {
                        displayRestaurant(result);
                    }
                },
                error: function(){
                    alert("Failed todisplay restaurant ");
                }
            });
        }
    </script>
    <script>
        function voteRestaurant(restaurantId){
            var data = {restaurantId: restaurantId};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "json",
                url:"event" + "${event.eventId}" + "/voteRestaurant",
                success: function(result){
                    if (result) {
                        displayRestaurantAfterVoted(result);
                    }
                },
                error: function(){
                    alert("Failed to vote");
                }
            });
        }
    </script>
</body>
</html>

