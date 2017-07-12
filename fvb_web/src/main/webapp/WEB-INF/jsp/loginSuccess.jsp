<%--
Date: 6/17/17
Time: 6:18 PM
To change this template use File | Settings | File Templates.
auther:wjm
--%>


<!DOCUTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is FoodVoteBox!</title>
    <meta charset="UTF-8">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-deep_orange.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="shortcut icon" href="https://github.com/JiamengWang/ImageStore/raw/master/box347643540.ico" type="image/x-icon" />
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.3.0/vue.js"></script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Compiled and minified JavaScript -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.99.0/js/materialize.min.js"></script>
    <style>
        form {
            margin: auto;
            padding: 10px;
        }
        form tr {
            text-align: center;
            height: 30px;
        }

        .center {
            margin: auto;

            text-align: center;
        }
        .topspace{
            margin-top: 50px;
        }

        #background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 300px;
            /*background-image: url('./img/winter_scenery_2-wallpaper-1920x1200.jpg');*/
            background-image: url("https://github.com/JiamengWang/ImageStore/raw/master/winter_scenery_2-wallpaper-1920x1200.jpg");
            background-repeat: repeat-y;
            background-attachment: fixed;
            background-size: 100%;
            /*opacity: 0.8;*/
            -moz-filter: blur(5px);
            -webkit-filter: blur(5px);
            -o-filter: blur(5px);
            -ms-filter: blur(5px);
            filter: blur(5px);
            z-index: -1;
            filter:alpha(opacity=80);
        }
        table {
            width:100%;
        }
        input {

            padding-left: 6px;
            padding-right: 6px;
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .top {
            border-top-left-radius: 0.5em;
            border-top-right-radius: 0.5em;
            border-top: solid lightgrey;
        }

        .middle {
            border-left: 2px solid lightgrey;
            border-right: 2px solid lightgrey;
            border-style: inset;
        }

        .bottom {
            border-bottom-left-radius: 0.5em;
            border-bottom-right-radius: 0.5em;
            border-bottom: solid lightgrey;
        }
        .mdl-layout__drawer-button {
            top: 10px;
        }
    </style>


    <style>
        .demo-layout-transparent {
        }
        .demo-layout-transparent .mdl-layout__header,
        .demo-layout-transparent .mdl-layout__drawer-button {
            color: white;
        }
        .drawer_pic {
            width:100%;
            background: url("https://github.com/JiamengWang/ImageStore/raw/master/harry_potter_icon_6825007.jpg");
            background-size: cover;
            height: 240px;
        }

        .page-content {
            margin-top: 200px;
            min-height: 100vh;
            border-radius: 1em;
            background: rgba(255, 255, 255,1.0);
            text-align: center;
            padding: 10px;
        }
    </style>
    <style>
        .box {
            width: 40%;
            margin: 0 auto;
            background: rgba(255,255,255,0.2);
            padding: 35px;
            border: 2px solid #fff;
            border-radius: 20px/50px;
            background-clip: padding-box;
            text-align: center;
        }

        .button {
            padding: 10px;
            text-decoration: none;
            transition: all 0.3s ease-out;
        }

        .overlay {
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background: rgba(0, 0, 0, 0.7);
            transition: opacity 500ms;
            visibility: hidden;
            opacity: 0;
            z-index: 1;
        }
        .overlay:target {
            visibility: visible;
            opacity: 1;
            z-index: 3;
        }

        .popup {
            margin: 200px auto;
            padding: 20px;
            background: rgba(255, 255, 255,0.9);
            border-radius: 5px;
            width: 250px;
            position: relative;
            transition: all 5s ease-in-out;
            height: 330px;
        }

        .popup h2 {
            margin-top: 0;
            color: #333;
            font-family: Tahoma, Arial, sans-serif;
        }
        .popup .close {
            position: absolute;
            top: 20px;
            right: 30px;
            transition: all 200ms;
            font-size: 30px;
            font-weight: bold;
            text-decoration: none;
            color: #333;
        }
        .popup .close:hover {
            color: #06D85F;
        }
        .popup .content {
            margin-top: 40px;
            height: 80%;
            overflow: auto;
        }

        @media screen and (max-width: 700px){
            .box{
                width: 70%;
            }
            .popup{
                width: 70%;
            }
        }
    </style>

    <style>
        .card-square.mdl-card {
            width: 230px;
            height: 320px;
            margin: 10px;
        }
        .card-square > .mdl-card__title {
            color: #fff;
            background-size: 220px auto;
            background-image: url() bottom right 20% no-repeat #020202;
        }
        .mdl-card__supporting-text {
            height:120px;
            overflow: scroll;
        }

        .card-list-item {
            width: 100%;
            height: 100px;
            overflow: scroll;
        }
        .mdl-button {
            width: 100%;
        }
        .mdl-card__supporting-text p {
            text-align: left;
            font-size: 0.9em;
            margin-bottom: 5px;
        }
        #cardBoard {
            padding:20px;
        }
        .container {
            width:100%;
        }
        #jsontext {
            width: 100%;
            height: 250px;
        }

        .textcenter {
            text-align: center;
        }

        .mdl-textfield{
            /*width: 20%;*/
            max-width: 20%;
        }

        .blockquote {
            margin: 20px 0;
            padding-left: 24px;
            font-weight: 300;
            text-align: left;
        }
        .card-image{
            width: 100%;
            max-width: 100%;
            height: auto;
            background-size: 100% auto;
            background-repeat: no-repeat;
        }

        .img {
            height: auto;
        }
        .card-action {
            text-align: left;
        }
        .card {
        }
        .card-img-bottom{
            width: 100%;
            height: 73px;
        }
    </style>
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div id="background"></div>
<div class="demo-layout-transparent mdl-layout mdl-js-layout">
    <header class="mdl-layout__header mdl-layout__header--transparent">
        <div class="mdl-layout-icon"></div>
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">Hello ${user.username}</span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <div class="mdl-navigation mdl-layout--large-screen-only">
                <a class="button mdl-navigation__link" href="/fvb_web/logout">LOGOUT</a>
            </div>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <div class="drawer_pic"></div>
        <div class="mdl-navigation">
            <a class="mdl-navigation__link" href="/fvb_web/memberinfo">Check my infomation</a>
            <a class="mdl-navigation__link" href="/fvb_web/">Return to login page</a>
            <a class="mdl-navigation__link" href="/fvb_web/logout">Log out!</a>
            <a class="mdl-navigation__link" href="/fvb_web/userInfo">Check UserInfo</a>
            <a class="mdl-navigation__link" href="/fvb_web/updateUser">UPDATE BIO</a>
            <a class="mdl-navigation__link" href="/fvb_web/updatePassword">UPDATE PASSWORD</a>
            <a class="mdl-navigation__link" href="/fvb_web/displayFriend">Friend List</a>
            <a class="mdl-navigation__link" href="/fvb_web/listEvent">Create an event</a>
            <a class="mdl-navigation__link" href="/fvb_web/myEvents">My events</a>

        </div>
    </div>

    <main class="mdl-layout__content">
        <div class="page-content">
            <div class="container">
                <div id="searchBar" class="col-md-12">
                    <div class="col-md-12">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" id="term">
                            <label class="mdl-textfield__label" for="term">Term</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" id="location">
                            <label class="mdl-textfield__label" for="location">Location</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <input class="mdl-textfield__input" type="text" id="category">
                            <label class="mdl-textfield__label" for="category">Category</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <select id="sort" type="text" class="mdl-textfield__input">
                                <option value="0" disabled selected>Sort By</option>
                                <option value="0">Best Match</option>
                                <option value="1">Distance</option>
                                <option value="2">Highest Rated</option>
                            </select>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                            <button class="textcenter mdl-textfield__input mdl-js-button mdl-button--raised mdl-button--accent" onclick="searchResturantList()">
                                SEARCH
                            </button>
                        </div>
                    </div>
                </div>

                ​
                <div class="col-md-12">
                    <div id="todo-list-example">
                        <ul>
                            <li v-for="(todo,index) in resturants">
                                <div class="col-md-12">
                                    <div class="card horizontal hoverable">
                                        <div class="card-image" v-bind:style="{'background-image':'url('+todo.image_url+')'}">
                                        </div>
                                        <div class="card-stacked">
                                            <div class="card-content">
                                                <div class="row">
                                                    <div class="input-field col s12">
                                                        <div class="blockquote condensed light" style="border-left: 5px solid #263238" >
                                                            <p style="font-size: 35px;">{{todo.name}}</p>
                                                        </div>
                                                    </div>
                                                    <div class=" col s12">
                                                        <div class="blockquote condensed light" style="border-left: 5px solid #263238" >
                                                            <p style="font-size: 20px">Contact: {{todo.display_phone}}</p>
                                                            <p v-for="ad in todo.location.display_address"style="font-size: 13px">{{ad}}</p>
                                                            <p style="font-size: 13px">Web: <a :href="todo.url" class="btn-small waves-effect waves-light" style="font-size: 20px"><i class="material-icons" style="font-size: 15px;color: #263238">web</i></a></p>
                                                        </div>
                                                    </div>
                                                    <div class=" col s12">
                                                        <div class="blockquote condensed light" style="border-left: 5px solid #263238" >
                                                            <p style="font-size: 20px">Price: {{todo.price}}</p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                </div>
                                            </div>
                                            <div class="card-action">
                                                <a v-on:click="fav()" class="btn-floating waves-effect waves-light blue-grey darken-4 "><i class="material-icons">add</i></a>
                                                <a v-on:click="fav()" class="blue-grey-text text-darken-4">&nbsp&nbsp&nbsp&nbsp&nbspAdd as favourite</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>

​
<script>
    Vue.prototype.$consoleLog = function() {console.log(...arguments)}
    Vue.component('todo-item', {
        props: ['title']
    })
    var yelp = new Vue({
        el: '#todo-list-example',
        data: {
            resturants:[
            ],
        },
        methods:{
            getIndex:function(index){
                // this.click = 1;
                console.log(1,index);
            },
            fav:function() {
                console.log('you like this resturant!');
            }
        }
    });
</script>

<script>
    var DealQueryParameter = function (config) {
        var term = $('#term').val();
        var location = $('#location').val();
        var category = $('#category').val();
        term = replaceSpace(term);
        location = replaceSpace(term);
        category = replaceSpace(category);
        if (term) {
            config['term'] = term;
        }
        if (location) {
            config['location'] = location;
        }
        if (category) {
            config['category_filter'] = category;
        }

        return config;
    }

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
        square.classList.add('card-square','mdl-card','mdl-shadow--2dp','col-md-4');
        var title = document.createElement('div');
        title.classList.add('mdl-card__title','mdl-card--expand');
        title.style.backgroundImage = "url('"+data.image_url+"')";
        var title_text = document.createElement('h2');
        title_text.innerHTML = data.name;
        title_text.classList.add('mdl-card__title-text');
        title.appendChild(title_text);
        square.appendChild(title);
        var support = document.createElement('div');
        support.classList.add('mdl-card__supporting-text');
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
        var detail = document.createElement('a');
        // detail.classList.add('mdl-button','mdl-button-colored','mdl-js-button mdl-js-ripple-effect');
        detail.className = 'mdl-button mdl-button-colored mdl-js-button';
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
        config['data'] = {latitude: position.coords.latitude, longitude: position.coords.longitude};
        var term = $('#term').val();
        var location = $('#location').val();
        var category = $('#category').val();
        term = replaceSpace(term);
        location = replaceSpace(location);
        category = replaceSpace(category);
        if (term) {
            config['data']['term'] = term;
        }
        if (location) {
            config['data']['location'] = location;
        }
        if (category) {
            config['data']['category_filter'] = category;
        }
        Comunicate(config,TextResponseHandler,config);
    }

    var getResturantList = function (talble_id,url_id,method_id) {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    }

    var searchResturantList = function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);
        } else {
            alert("Geolocation is not supported by this browser.");
        }
    }

    var test = function (talble_id,url_id,method_id) {
        var config = {};
        config['url'] = $('#'+url_id).val();
        config['method'] = $('#'+method_id).val();
        config['table_id'] = talble_id;
        config['type'] = 'json';
        config['data'] = "";
        console.log(config);
        Comunicate(config,JsonResposneHandler,config);

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
            success: function (data) {
                callback(data,callback_para);
            }
        });
    }
    var TextResponseHandler = function(data,callback_para) {
        var jsonarea = $('#jsontext')[0];
        var jsonobj = JSON.parse(data);
        yelp.resturants = jsonobj['businesses'];
    }
    var JsonResposneHandler = function(data,callback_para) {
        var jsonarea = $('#jsontext')[0];
    }
    var prettfy = function (json) {
        return JSON.stringify(json,undefined,4);
    }
    var GenerateCell = function(data) {
        var row = $('#'+data.table_id)[0].insertRow();
        var url = document.createElement('td');
        var method = document.createElement('td');
        var blank = document.createElement('td');
        url.innerHTML = data.url;
        method.innerHTML = data.method;
        row.append(url);
        row.append(method);
        row.append(blank);

    }

</script>


</body>

</html>