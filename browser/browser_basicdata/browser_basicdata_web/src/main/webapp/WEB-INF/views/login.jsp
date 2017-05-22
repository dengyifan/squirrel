<%--
  Created by IntelliJ IDEA.
  User: yifan
  Date: 17-5-14
  Time: 下午8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 引入 Bootstrap -->
    <link href="../statics/scripts/common/bootstrap/css/bootstrap.css" rel="stylesheet">

    <style type="text/css">
        body {
            padding-top:40px;
            padding-bottom:40px;
            background-color: #eee;
        }

        .form-signin{
            max-width:330px;
            padding:15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading, .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox{
            font-weight:normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding:10px;
            font-size:16px;
        }

        .form-signin .form-control:focus{
            z-index:2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius:0;
            border-top-right-radius: 0;
        }
    </style>

</head>
<body>

<div class="container">

    <form class="form-signin">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">邮箱地址：</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="邮箱地址" required autofocus>
        <label for="inputPassword" class="sr-only">密码：</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="../scripts/common/jquery.js"></script>

<!-- 包括所有已编译的插件 -->
<script src="../scripts/common/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
