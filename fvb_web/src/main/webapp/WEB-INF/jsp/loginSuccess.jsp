<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/17/17
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCUTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>This is FoodVoteBox!</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-deep_orange.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="shortcut icon" href="https://github.com/JiamengWang/ImageStore/raw/master/box347643540.ico" type="image/x-icon" />
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

    <style>
        .flip-container {
            perspective: 1000px;
            margin: 1%;
        }
        /* flip the pane when hovered */
        .flip-container.hover .flipper {
            transform: rotateY(180deg);
        }

        .flip-container, .front, .back {
            width: 300px;
            height: 330px;
        }

        /* flip speed goes here */
        .flipper {
            transition: 0.6s;
            transform-style: preserve-3d;
            width:100%;
            height:100%;
        }
        .flipbtn {
            position: absolute;
            bottom: 0.9em;
            left: 5.8em;
        }

        /* hide back of pane during swap */
        .front, .back {
            backface-visibility: hidden;
            position: absolute;
            top: 0;
            left: 0;
        }

        /* front pane, placed above back */
        .front {
            /*z-index: 2;*/
            padding: 2%;
            background: rgba(158, 172, 193,0.6);
            /*opacity: 0.6;*/
            /*background: rgb(158, 172, 193);*/
            transform: rotateY(0deg);
            border-radius: 2.5em;
        }

        /* back, initially hidden pane */
        .back {
            padding: 2%;
            background: rgba(161, 163, 168,0.6);
            /*opacity: 0.6;*/
            /*z-index:1;*/
            /*background: rgb(158, 172, 193);*/
            transform: rotateY(180deg);
            border-radius: 2.5em;
        }

        .fliper table {
            width:100%;
            height:100%;
        }

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
        /*body {*/
        /*background-image: url("https://github.com/JiamengWang/ImageStore/raw/master/635938589851171129-1119557603_food-buffet-1134498.jpg");*/
        /**/
        /*}*/
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
            /*padding-left: 1px;*/
            /*padding-right: 1px;*/
            border-left: 2px solid lightgrey;
            border-right: 2px solid lightgrey;
            border-style: inset;
        }

        .bottom {
            border-bottom-left-radius: 0.5em;
            border-bottom-right-radius: 0.5em;
            border-bottom: solid lightgrey;
        }
    </style>

    <style>
        .demo-layout-transparent {
            /*background: url('https://github.com/JiamengWang/ImageStore/raw/master/winter_scenery_2-wallpaper-1920x1200.jpg') center / cover;
            -moz-filter: blur(5px);
            -webkit-filter: blur(5px);
            -o-filter: blur(5px);
            -ms-filter: blur(5px);
            filter: blur(5px);
            filter:alpha(opacity=80);*/
        }
        .demo-layout-transparent .mdl-layout__header,
        .demo-layout-transparent .mdl-layout__drawer-button {
            /* This background is dark, so we set text to white. Use 87% black instead if
               your background is light. */
            color: white;
        }
        .drawer_pic {
            width:100%;
            background: url("https://github.com/JiamengWang/ImageStore/raw/master/harry_potter_icon_6825007.jpg");
            /*background: :url("./img/03-8-ways-to-hate-junk-food-trail-mix.jpg");*/
            background-size: cover;
            height: 240px;
        }

        .page-content {
            margin-top: 200px;
            height: 100vh;
            border-radius: 1em;
            /*border: 1px solid;*/
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
            /*font-size: 2em;*/
            padding: 10px;
            /*color: #fff;*/
            /*border: 2px solid #06D85F;*/
            /*border-radius: 20px/50px;*/
            text-decoration: none;
            /*cursor: pointer;*/
            transition: all 0.3s ease-out;
        }
        /*.button:hover {
        background: #06D85F;
        }*/

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
        .mdl-layout__drawer-button {
            top: 10px;
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
            <nav class="mdl-navigation mdl-layout--large-screen-only">
                <a class="button mdl-navigation__link" href="/fvb_web/logout">LOGOUT</a>
                <%--<a class="mdl-navigation__link" href="#signup_pop">SIGN UP</a>--%>
            </nav>
        </div>
    </header>
    <div class="mdl-layout__drawer">
        <!-- <span class="mdl-layout-title">Title</span> -->
        <div class="drawer_pic"></div>
        <nav class="mdl-navigation">
            <a class="mdl-navigation__link" href="/fvb_web/memberinfo">Check my infomation</a>
            <a class="mdl-navigation__link" href="/fvb_web/">Return to login page</a>
            <a class="mdl-navigation__link" href="/fvb_web/logout">Log out!</a>
            <a class="mdl-navigation__link" href="/fvb_web/userInfo">Check UserInfo</a>
            <a class="mdl-navigation__link" href="/fvb_web/updateUser">UPDATE BIO</a>
            <a class="mdl-navigation__link" href="/fvb_web/updatePassword">UPDATE PASSWORD</a>

        </nav>
    </div>
    <main class="mdl-layout__content">
        <div class="page-content"><!-- Your content goes here -->
            <%--<div id="login_pop" class="overlay">--%>
                <%--<div class="popup">--%>
                    <%--<a class="close" href="#">&times;</a>--%>
                    <%--<div class="content center">--%>
                        <%--<h4>LOGIN</h4>--%>
                        <%--<form action="/fvb_web/login" method="post">--%>
                            <%--<table>--%>
                                <%--<tr><td><input id="loginusername" class="top" type='text' name='email' placeholder="Username"></td></tr>--%>
                                <%--<tr><td><input id="loginpass" class="bottom" type='text' name='password' placeholder="Password"></td></tr>--%>
                            <%--</table>--%>
                            <%--<div class="flipbtn"><button id="loginbtn"class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" disabled>--%>
                                <%--SUBMIT--%>
                            <%--</button></div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <%--<div id="signup_pop" class="overlay">--%>
                <%--<div class="popup">--%>
                    <%--<a class="close" href="#">&times;</a>--%>
                    <%--<div class="content center">--%>
                        <%--<h4>SING UP</h4>--%>
                        <%--<form action="/fvb_web/register/do" method="post">--%>
                            <%--<table>--%>
                                <%--<tr><td><input id='signUsername' class="top" type='text' name='username' placeholder="Username"></td></tr>--%>
                                <%--<tr><td><input id='signEmail'lass="middle" type='text' name='email' placeholder="Email"></td></tr>--%>
                                <%--<tr><td><input id='signPass' clas="middle" type='text' name='password' placeholder="Password"></td></tr>--%>
                                <%--<tr><td><input class="bottom" type='text' name='phone' placeholder="Phone Number"></td></tr>--%>
                            <%--</table>--%>
                            <%--<div class="flipbtn"><button id='signbtn'class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" disabled>--%>
                                <%--SUBMIT--%>
                            <%--</button></div>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>

            <form name="UserInfo" method="get" >
                <table width="300" border="1" align="center">
                    <tr>
                        <td colspan="2">UserInfo</td>
                    </tr>
                    <tr>
                        <td>UserName:</td>
                        <td>${user.username}
                        </td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${user.email}
                        </td>
                    </tr>
                    <tr>
                        <td>PhoneNumber:</td>
                        <td>${user.phone}
                        </td>
                    </tr>
                    <tr>
                        <td>CreateTime:</td>
                        <td>${user.created}
                        </td>
                    </tr>
                </table>
            </form>


        </div>
    </main>
</div>
</body>

<script>
    function flip(id) {
        $('#'+id)[0].classList.toggle('hover');
    }

    function passwordValidate(pass) {
        // check if the password meet the mininum requirements
        console.log('check pass:',pass);
        if (!pass) {
            return false;
        }
        var DEFAULT_PASSWORD_PATTERN = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8}/;
        return pass.match(DEFAULT_PASSWORD_PATTERN);
    }

    function userNameValidate(username) {
        console.log('check username',username);
        if (!username || typeof(username)!= 'string' || username.length == 0) {
            return false;
        }
        return true;
    }

    function emailValidate(email) {
        console.log('in check email',email);
        if (!email || typeof(email)!= 'string' || email.length == 0) {
            return false;
        }
        var DEFAULT_EMAIL_PATTERN = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;
        return email.match(DEFAULT_EMAIL_PATTERN);

    }

    function loginValidate(username,pass,button,email) {
        $('#'+pass).on('keyup',function () {
//            if (passwordValidate($('#'+pass).val())) {
//                if (userNameValidate($('#'+username).val())) {
//                    $('#'+button).prop("disabled",false);
//                } else {
//                    $('#'+button).prop("disabled",true);
//                }
//            } else {
//                $('#'+button).prop("disabled",true);
//            }

            if (userNameValidate($('#'+username).val()) && passwordValidate($('#'+pass).val())) {
                if (!email || emailValidate($('#'+email).val())) {
                    $('#'+button).prop("disabled",false);
                } else {
                    $('#'+button).prop("disabled",true);
                }
            } else {
                $('#'+button).prop("disabled",true);
            }
        });

        $('#'+username).on('keyup',function () {
//            if (userNameValidate($('#'+username).val())) {
//                if (passwordValidate($('#'+pass).val())) {
//                    $('#'+button).prop("disabled",false);
//                } else {
//                    $('#'+button).prop("disabled",true);
//                }
//            } else {
//                $('#'+button).prop("disabled",true);
//            }

            if (userNameValidate($('#'+username).val()) && passwordValidate($('#'+pass).val())) {
                if (!email || emailValidate($('#'+email).val())) {
                    $('#'+button).prop("disabled",false);
                } else {
                    $('#'+button).prop("disabled",true);
                }
            } else {
                $('#'+button).prop("disabled",true);
            }
        });

        if (email) {
            if (emailValidate($('#'+email).val()) && userNameValidate($('#'+username).val()) && passwordValidate($('#'+pass).val())) {
                $('#'+button).prop("disabled",false);
            } else {
                $('#'+button).prop("disabled",true);
            }
        }
    }

    $(document).ready(function () {
        console.log('ready');
        loginValidate('loginusername','loginpass','loginbtn');
        loginValidate('signUsername','signPass','signbtn','signEmail');
    });
</script>

<script>
    $.ajax({
        url:"/fvb_web/userInfo",
        method:"GET",
        dataType:"json",
        success:function(user) {
            alert("received JSON:" + JSON.stringify(user));//把json的数据打印出来
        },
        error:function() {
            alert("error");
        }
    });
</script>

</html>


