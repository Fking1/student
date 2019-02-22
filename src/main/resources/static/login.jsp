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
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/exercise/style/jumbotron-narrow.css">
    <style>
        body {
            padding-top: 20px;
            padding-bottom: 40px;
            background-color: #fff;
        }

        .all{
            width: 1040px;
        }

        .header{
            padding-bottom: 20px;
            border-bottom: 2px solid #eee;
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
        .form-signin .checkbox {
            margin-bottom: 10px;
        }
        .form-signin .checkbox {
            font-weight: normal;
        }
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
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
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
                <li role="presentation"><a href="/exercise/register.jsp">Register</a></li>
                <li role="presentation" class="active"><a href="/exercise/login.jsp">Login</a></li>
            </ul>
        </nav>
        <img src="/exercise/images/icon.jpg" class="text-muted headerIcon">
    </div>

    <form class="form-signin" action="/exercise/servlet/user" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" id="inputUserName" class="form-control" placeholder="Your userName" required autofocus name="userName">
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="checkbox"> Remember me
            </label>
        </div>
        <input name="types" value="login" hidden>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js" type="text/javascript"></script>
<script>

    $(function () {
        $("#inputUserName").val("");
        $("#inputPassword").val("");
    });


    $(".headerIcon").on("click",function (event) {
        $(location).attr('href', '/userInfo.jsp');
    });
</script>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>
