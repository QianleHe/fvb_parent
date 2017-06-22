<%--
  Created by IntelliJ IDEA.
  User: qianle
  Date: 6/17/17
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>This is FoodVoteBox!</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
            bottom: 2em;
            left: 6em;
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
            z-index: 2;
            padding: 2%;
            background: rgba(252, 150, 141,0.6);
            /*opacity: 0.6;*/
            transform: rotateY(0deg);
            border-radius: 2.5em;
        }

        /* back, initially hidden pane */
        .back {
            padding: 2%;
            background: rgba(128, 176, 252,0.6);
            /*opacity: 0.6;*/
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
            height: 40px;
        }

        .center {
            margin: auto;
            margin-top: 50px;
            text-align: center;
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
            height: 100%;
            background-image: url('https://github.com/JiamengWang/ImageStore/raw/master/winter_scenery_2-wallpaper-1920x1200.jpg');
            /*background-image: url("https://github.com/JiamengWang/ImageStore/raw/master/635938589851171129-1119557603_food-buffet-1134498.jpg");*/
            background-repeat: repeat-y;
            background-attachment: fixed;
            background-size: 100%;
            opacity: 0.8;
            -moz-filter: blur(5px);
            -webkit-filter: blur(5px);
            -o-filter: blur(5px);
            -ms-filter: blur(5px);
            filter: blur(5px);

            filter:alpha(opacity=80);
        }

        table,tr,h4{
            opacity: 1.0;
        }
        input {
            border-radius: 0.5em;
        }

    </style>
</head>
<body>
    <div id="background"></div>
    <div class="row">
        <div class="col-md-12 col-sm-12"><div class="center"><h1>Welcome to FoodVoteBox</h1></div></div>
        <div class="col-md-12 col-sm-12">
            <div id="login" class="flip-container center">
                <div class="flipper ">
                    <div class="front center">
                        <h4>Login</h4>
                        <form action="/fvb_web/login" method="post">
                            <table>
                                <tr><th>Username: </th><td><input type='text' name='email'></input></td></tr>
                                <tr><th>Password: </th><td><input type='text' name='password'></input></td></tr>

                                <!-- <tr><td><button onclick="flip('login')">Do not have account? Sign up</button></td></tr> -->
                            </table>
                            <div class="center"><input type="submit" value="Login"/></div>
                        </form>

                        <div class="flipbtn"><button onclick="flip('login')">Do not have account?</button></div>
                    </div>
                    <div class="back center">
                        <h4>Register</h4>
                        <form action="/fvb_web/register/do" method="post">
                            <table>
                                <tr><th>Username: </th><td><input type='text' name='username'></input></td></tr>
                                <tr><th>Email: </th><td><input type='text' name='email'></input></td></tr>
                                <tr><th>Password: </th><td><input type='text' name='password'></input></td></tr>
                                <tr><th>Phone: </th><td><input type='text' name='phone'></input></td></tr>
                            </table>
                            <input type="submit" value="Sign Up"/>
                        </form>
                        <div class="flipbtn"><button onclick="flip('login')">Back to Login Page</button></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script>
    function flip(id) {
        $('#'+id)[0].classList.toggle('hover');
    }
</script>

</html>
