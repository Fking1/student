<%--
  Created by IntelliJ IDEA.
  User: fang
  Date: 2018/9/19
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            padding-top: 20px;
            padding-bottom: 40px;
            background-color: #fff;
        }

        .all{
            width: 1024px;
        }

        .header{
            border-bottom: 2px solid #eee;
            padding-bottom: 20px;
        }

        .headerIcon{
            width: 50px;
            height: 50px;
            border-radius: 100%;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 80px auto;
        }
        .form-signin .form-signin-heading,
        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input{
            margin-bottom: 5px;
            border-radius: 3px;
        }
        .form-signin button{
            border-radius: 3px;
        }
    </style>
</head>
<body>

<div class="container-fluid all">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation"><a href="/exercise/home.jsp">Index</a></li>
                <li role="presentation" class="active"><a href="/exercise/register.jsp">Register</a></li>
                <li role="presentation"><a href="/exercise/login.jsp">Login</a></li>
            </ul>
        </nav>
        <img src="/exercise/images/icon.jpg" class="text-muted headerIcon">
    </div>
    <form class="form-signin" action="/exercise/servlet/user" method="post">
        <h1 class="form-signin-heading">Register</h1>
        <%--<label for="inputUserName" class="sr-only">userName</label>--%>
        <%--for应与input的id相对应 sr-only是对残障人士设置的屏幕可读 一般情况下不显示--%>
        <input type="text" id="inputUserName" class="form-control" placeholder="Your userName" required autofocus name="userName" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$">
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$">
        <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm your password" required name="password1" pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$">
        <input type="email" id="inputMail" class="form-control" placeholder="Input your mail" required name="mailAddress">
        <input name="types" value="register" hidden>
        <button class="btn btn-lg btn-primary btn-block" type="submit" id="submit" disabled>Register</button>
    </form>
</div>
<script>
    $("#inputPassword").on("input",function (event) {
        var password = $(this).val();
        var confirmPassword = $("#confirmPassword").val();
        if(password==confirmPassword){
            $("#submit").removeAttr("disabled");
        }
        else{
            $("#submit").attr("disabled",true);
        }
    })
    $("#confirmPassword").on("input",function (event) {
        var password = $("#inputPassword").val();
        var confirmPassword = $(this).val();
        if(password==confirmPassword){
            $("#submit").removeAttr("disabled");
        }
        else{
            $("#submit").attr("disabled",true);
        }
    })


    $(".headerIcon").on("click",function (event) {
        $(location).attr('href', '/userInfo.jsp');
    });
</script>
</body>
</html>

