<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <title>登录</title>
    <link rel="icon" href="../img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <style>
        body{
            background-image: url("../img/bg.jpg");
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            -moz-background-size: cover;
             -ms-background-size: cover;
        }
        /* input.infos{
            border-bottom: 2px solid #46350059;
            border-left: 0;
            border-right: 0;
            border-top: 0;
            background-color: transparent;
        } */
    </style>
</head>
<body>
    <div class="container">
        <div class="col-md-4"></div>
            <div class="col-md-4">
                <div class="well well-lg" style="margin-top: 120px; background-color: #eee;">
                    <center>
                        <h2>登录</h2>
                    </center>
                    <br>
                    <form action="" method="POST" target="hidden" id="loginForm">
                        <div class="input-group input-group-lg">
                            <input type="text" class="form-control well well-lg infos" placeholder="用户名" name="UserName" id="UserName">
                            <span class="input-group-addon glyphicon glyphicon-exclamation-sign btn btn-link" aria-hidden="true" data-toggle="tooltip" data-placement="left" title="忘记用户名"><a href=""></a></span>
                        </div>
                        <br>
                        <div class="input-group input-group-lg">
                            <input type="password" class="form-control well well-lg infos" placeholder="密码" name="Password" id="Password">
                             <a class="input-group-addon glyphicon glyphicon-exclamation-sign btn btn-link" aria-hidden="true" data-toggle="tooltip" data-placement="left" title="忘记密码" href="forgetPwd.jsp"></a>
                        </div>
                        <br>
                        <!-- <div class="input-group">
                            <iframe name="hidden" style="display: none;"></iframe>
                                <input type="tel" id="inputImg" class="form-control well well-lg" placeholder="请输入图形验证码">
                                <a class="input-group-addon" href="#" id="changeImg" ><canvas id="canvas" width="110" height="35"></canvas></a>
                            
                        </div> -->
                        
                        <p id="msg" class="text-center text-danger"></p>
                        <div class="form-group text-center  ">
                            <!-- <label for="my-input">Text</label> -->
                            <input id="userlogin" class="btn btn-info" type="submit" name="log" value="登录" onclick="login()"/>
                        </div>
                    </form>
                </div>
                <div class="well well-lg" style="margin-bottom: 50px; background-color: #eee;">
                    <h3 class="text-center">没有账号？</h3>
                    <br> 
                    <a href="register.jsp" class="form-control btn btn-info"><span class="text-center">创建账户</span></a>
                    <div class="text-center">
                        <br>
                        <ul class="list-inline">
                            <li>@ JXAU</li>
                            <li>|</li>
                            <li><a href="#" class="text-danger">使用条款</a></li>
                            <li>|</li>
                            <li><a href="#" class="text-danger">隐私政策</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-4"></div>
    </div>
</body>
 
<script src="/ReviewSystem/js/jquery-3.4.1.min.js"></script>
<script src="/ReviewSystem/js/bootstrap.min.js"></script>
<script src="/ReviewSystem/js/login.js"></script>


</html>