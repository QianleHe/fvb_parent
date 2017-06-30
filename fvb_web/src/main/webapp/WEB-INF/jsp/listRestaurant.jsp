<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/27/17
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <p>Click the button to get restaurants nearby.</p>

    <button onclick="getLocation()">Try It</button>
    <button href="/fvb_web/listRestaurant" onclick="getRes()">getList</button>

    <p id="demo"></p>

    <p>${resInfo}</p>

    <script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
    <script>
        var x = document.getElementById("demo");

        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition);
                navigator.geolocation.getCurrentPosition(sendLocation);
            } else {
                x.innerHTML = "Geolocation is not supported by this browser.";
            }
        }

        function showPosition(position) {
            x.innerHTML = "Latitude: " + position.coords.latitude +
                "<br>Longitude: " + position.coords.longitude;
        }

        function sendLocation(position){
            var data = {latitude: position.coords.latitude, longitude: position.coords.longitude};
            $.ajax({
                data: data,
                type: "POST",
                dataType: "json",
                url:"/fvb_web/listRestaurant",
                success: function(result){
                    //alert(result)
                    if (result != "1233")
                        alert(result.total);
                }
            });
        }

    </script>
</body>
</html>
