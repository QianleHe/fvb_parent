<%--
  Created by IntelliJ IDEA.
  User: wuqi
  Date: 7/5/17
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.foodvotebox.pojo.DBEventMemberReturnType" %>
<%@ page import="com.foodvotebox.pojo.FvbFriend" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>${event.eventName}</title>
</head>
<body>
<%--<h1>${memberList.get(0)}</h1>--%>
<h1>${event.eventName}</h1>
<h2>The event will be hold on ${event.eventDate}</h2>
<p>${event.description}</p>
<h1>Add restaurants </h1>
<div id = "showRestaurantdiv"></div>
<%--在这显示已经加入event的Restaurant--%>
<%--已经加入的restaurantke--%>
<label for="term">Term</label>
<input type="text" name="term" id="term"/>
<label for="location">Location</label>
<input type="text" name="location" id="location"/>
<select name="show" id="show">
    <option value="1">1</option>
    <option value="3">3</option>
    <option value="5">5</option>
</select>
<%--每个--%>
<button onclick="searchRestaurantList()">
    SEARCH
</button>

<br>
<div id="cardBoard" class="row"></div>
<br>

<h1>Add Members </h1>
<%--friend list --%>
<div id="FriendDiv"></div>

<input type="text" name="memberName" id="memberName"/>
<input type="submit" value="Add" id="addMember" onclick="addMember();"/>
<input type="submit" value="Add from my friend" onclick="displayFriend();">
<div id="memberDiv">
    <div id = "showdiv"></div>
</div>

<a href="/fvb_web/listEvent${event.eventId}/deleteEvent">Delete</a>
</body>

<script type="text/javascript" src="../fvb_web/js/jquery-3.1.1.js"></script>
<script src="../fvb_web/js/eventPage.js"></script>
<script>
    function DisplayMember(result) {
        $("#showdiv").empty();
        var panelTable = $("<table></table>");
        var panelheader = $("<tr><td>UserId</td> <td>UserName</td> <td></td></tr>");
        for(a of result) {
            var panelBody = $("<tr></tr>");
            var panelBodyId = $("<td></td>").text(a.memberId);
            var panelBodyName = $("<td></td>").text(a.userName);
            var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
            panelBodyDelete.attr("onclick", "deleteMember("+a.memberId+")");
            panelBodyDelete.attr("id", a.memberId);
            panelBodyDelete = $("<td></td>").append(panelBodyDelete);
            panelBody.append(panelBodyId,panelBodyName,panelBodyDelete);
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
            url:"listEvent" + "${event.eventId}" + "/displayMember",
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

    function addMember(){
        var data = {memberName: $("#memberName").val()};
        $.ajax({
            data: data,
            type: "POST",
            dataType: "json",
            url:"listEvent" + "${event.eventId}" + "/addMember",
            success: function(result){
                if (result) {
                    DisplayMember(result);
                }
            },
            error: function(){
                alert("No such user or you have already added this user");
            }
        });
    }


    function deleteMember(memberId){
        $.ajax({
            data: {memberId: memberId},
            type: "GET",
            dataType: "json",
            url:"listEvent" + "${event.eventId}" + "/deleteMember",
            success: function(result){
                if (result) {
                    DisplayMember(result);
                }
            },
            error: function(){
                alert("Delete member failed");
            }
        });
    }
    function addFromFriend(name){
        var data = {memberName: name};
        $.ajax({
            data: data,
            type: "POST",
            dataType: "json",
            url:"listEvent" + "${event.eventId}" + "/addMember",
            success: function(result){
                if (result) {
                    DisplayMember(result);
                }
            },
            error: function(){
                alert("No such user or you have already added this user");
            }
        });
    }
    function displayFriend(){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "displayFriendList",
            success: function(result){
                if (result) {
                    $("#FriendDiv").empty();
                    var panelTitle = $("<h2>Friend List</h2>");
                    var panelTable = $("<table></table>");
                    var panelheader = $("<tr> <td>UserName</td> <td></td></tr>");
                    for(a of result) {
                        var panelBody = $("<tr></tr>");
                        var panelBodyName = $("<td></td>").text(a.friendname);
                        var panelBodyDelete = $("<input type=\"submit\" value=\"Add\" />")
                        panelBodyDelete.attr("onclick", "addFromFriend('"+a.friendname+"')");
                        panelBodyDelete.attr("id", a.friendname);
                        panelBodyDelete = $("<td></td>").append(panelBodyDelete);
                        panelBody.append(panelBodyName,panelBodyDelete);
                        panelTable.append(panelBody);
                    }

                    $("#FriendDiv").append(panelTitle,panelheader,panelTable);
                }
            },
            error: function(){
                alert("Delete friend failed");
            }
        });
    }
</script>

<script>
    function displayRestaurant(result) {
        $("#showRestaurantdiv").empty();
        var panelTable = $("<table></table>");
        var panelHeader = $("<tr><td>RestaurantName</td> <td>Location</td> <td>Price</td> <td>Votes</td> <td>Link</td> <td></td></tr>");
        for(a of result) {
            var panelBody = $("<tr></tr>");
            var panelBodyName = $("<td></td>").text(a.restaurantName);
            var panelBodyLocation = $("<td></td>").text(a.address + "," + a.city);
            var panelBodyPrice = $("<td></td>").text(a.price);
            var panelBodyVotes = $("<td></td>").text(a.votes);
            var panelBodyLink = $("<a></a>").text("Details");
            panelBodyLink.attr("href", a.yelpUrl);
            var panelBodyDelete = $("<input type=\"submit\" value=\"Delete\" />")
            panelBodyDelete.attr("onclick", "deleteRestaurant("+a.restaurantId+")");
            panelBodyDelete.attr("id", a.restaurantId);
            panelBodyDelete = $("<td></td>").append(panelBodyDelete);
            panelBody.append(panelBodyName,panelBodyLocation,panelBodyPrice,panelBodyVotes,panelBodyLink,panelBodyDelete);
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
            url:"listEvent" + "${event.eventId}" + "/displayRestaurant",
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


    function addRestaurant(name,city,address,phone,price,rating,yelpUrl,imgUrl){
        $.ajax({
            data: {restaurantName: name,
                city: city,
                address: address,
                phone: phone,
                price: price,
                rating: rating,
                yelpUrl: yelpUrl,
                imgUrl: imgUrl},
            type: "POST",
            dataType: "json",
            url:"listEvent" + "${event.eventId}" + "/addRestaurant",
            success: function(result){
                if (result) {
                    displayRestaurant(result);
                }
            },
            error: function(){
                alert("Failed to add restaurant to the event");
            }
        });
    }

    function deleteRestaurant(restaurantId){
        $.ajax({
            data: {restaurantId: restaurantId},
            type: "GET",
            dataType: "json",
            url:"listEvent" + "${event.eventId}" + "/deleteRestaurant",
            success: function(result){
                if (result) {
                    displayRestaurant(result);
                }
            },
            error: function(){
                alert("Delete restaurant failed");
            }
        });
    }
</script>
<script>
    var replaceSpace = function (str) {
        if (!str || str.length == 0) {
            return null;
        }
        str = str.trim();
        str = str.replace(/\s+/g,"+");
        console.log(str);
        return str;
    }
    var generateCard = function (root,data) {
        var square = document.createElement('div');
//            square.classList.add('card-square','mdl-card','mdl-shadow--2dp','col-md-4');
        var title = document.createElement('div');
//            title.classList.add('mdl-card__title','mdl-card--expand');
        title.style.backgroundImage = "url('"+data.image_url+"')";
        var title_text = document.createElement('h2');
        title_text.innerHTML = data.name;
//            title_text.classList.add('mdl-card__title-text');
        title.appendChild(title_text);
        square.appendChild(title);
        var support = document.createElement('div');
//            support.classList.add('mdl-card__supporting-text');
        var location = document.createElement('P');
        var loca_text = document.createTextNode('Location:'+data.location.city+'/'+data.location.address1);
        location.appendChild(loca_text);
        var price = document.createElement('P');
        var price_text = document.createTextNode('Price:'+data.price);
        price.appendChild(price_text);
        var contact = document.createElement('P');
        var contact_text = document.createTextNode('Contact:'+data.display_phone);
        contact.appendChild(contact_text);
        support.appendChild(location);
        support.appendChild(price);
        support.appendChild(contact);
        square.appendChild(support);

        var addToEvent = document.createElement('input');
        addToEvent.setAttribute('type', 'submit');
        addToEvent.setAttribute('value', 'ADD');
        addToEvent.setAttribute('onclick', "addRestaurant('"+data.name+"', '"+data.location.city+"', '"+data.location.address1+"', '"+data.display_phone+"', '"+data.price+"', '', '"+data.url+"', '"+data.image_url+"')");
        square.appendChild(addToEvent);
        var detail = document.createElement('a');
        // detail.classList.add('mdl-button','mdl-button-colored','mdl-js-button mdl-js-ripple-effect');
//            detail.className = 'mdl-button mdl-button-colored mdl-js-button';
        detail.innerHTML = 'DETAIL';
        detail.setAttribute('href',data.url);
        square.appendChild(detail);
        root.appendChild(square);
    }

    var generateCardBoard = function (id,data) {
        console.log(data);
        var root = $('#'+id)[0];
        while (root.firstChild) {
            root.removeChild(root.firstChild);
        }
        for (var i in data) {
            generateCard(root,data[i]);
        }
    }

    var showPosition = function(position) {
        var config = {};
        config['url'] = "/fvb_web/listAllRestaurants";
        config['method'] = "POST";
        config['table_id'] = "jsontest";
        config['type'] = 'text';
        config['data'] ={latitude: position.coords.latitude, longitude: position.coords.longitude};

        var term = $('#term').val();
        var location = $('#location').val();
        var category = $('#category').val();
        var show = $('#show').val();
        term = replaceSpace(term);
        location = replaceSpace(location);
        category = replaceSpace(category);
        show = replaceSpace(show);
        if (term) {
            config['data']['term'] = term;
        }
        if (location) {
            config['data']['location'] = location;
        }
        if (category) {
            config['data']['category_filter'] = category;
        }
        if (show) {
            config['data']['limit'] = show;
        }

        Comunicate(config,TextResponseHandler,config);
    }

    var searchRestaurantList = function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    }

    var Comunicate = function(config,callback,callback_para) {
        if (!config) {
            console.log('wrong format');
            return;
        }
        console.log(config);
        var c_url = config.url;
        var c_method = config.method;
        var c_data = config.data;
        var c_type = config.type;
        $.ajax({
            data:c_data,
            url:c_url,
            method:c_method,
            dataType:c_type,
            success:function (data) {
//                console.log('Server says: ',data);
                //could assign some flag in json return value. Based on this value we determine next action
                callback(data,callback_para);
            }
        });
    }
    var TextResponseHandler = function(data,callback_para) {
        var jsonarea = $('#jsontext')[0];
        var jsonobj = JSON.parse(data);
        generateCardBoard('cardBoard',jsonobj['businesses']);
//        jsonarea.innerHTML = prettfy(jsonobj);

//        GenerateCell(callback_para);
    }
</script>
</html>
