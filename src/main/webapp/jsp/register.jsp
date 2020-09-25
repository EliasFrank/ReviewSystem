<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
    <title>注册账户</title>
    <link rel="icon" href="/ReviewSystem/img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/ReviewSystem/img/favicon.ico" type="image/x-icon">
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
        input.infos{
            border-bottom: 2px solid #46350059;
            border-left: 0;
            border-right: 0;
            border-top: 0;
            background-color: transparent;
        }
        
        td
        {
            border: 1px solid transparent !important ;
        }
        tr{
            border: 1px solid transparent !important ;
        }
        tbody{
            border: 1px solid transparent !important ;
        }
        
        
    </style>
</head>
<body>
    <div class="container">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <div class="well well-lg" style="margin-top: 60px; background-color: rgb(253, 248, 245);">
                <center>
                    <h1>创建您的账户</h1>
                </center>
                <br>
                <p class="text-center">已有账号？  <a class="text-danger" href="login.jsp">登录</a></p>
                <br>
                <form class="" action="" method="POST" target="hidden" id="register">
                    <iframe name="hidden" style="display: none;"></iframe>
                    <table class="table" id="mytab">
                        <tbody class="">
                            <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">电话号码</span></td>
                                <td><input id="inputTel" class="infos form-control" type="text"  name="Tel" /> </td>
                                <td><small>您的电话号码可以帮助您找回您的账号信息</small></td>
                            </tr>
                      
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td id="telError" class="text-danger"></td>
                                <td></td>
                            </tr>
                        </tbody>
                            <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">用户账号</span></td>
                                <td><input id="inputName" class="infos form-control" type="text"  name="UserName" /> </td>
                                <td><small>您的用户账号可以用来登录账户使用(8位的纯数字)</small></td>
                            </tr>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td id="userError" class="text-danger"></td>
                                    <td></td>
                                </tr>
                            </tbody>
                            <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">设置密码</span></td>
                                <td><input id="inputPwd" class="infos form-control" type="password"  name="Password" /> </td>
                                <td><small>密码必须包含字母和至少 1 个数字</small></td>
                            </tr>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td id="pwdError" class="text-danger"></td>
                                    <td></td>
                                </tr>
                            </tbody>
                            <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">再次输入密码</span></td>
                                <td><input id="inputSame" class="infos form-control" type="password"  name="Password" /> </td>
                                <td><small></small></td>
                            </tr>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td id="sameError" class="text-danger"></td>
                                    <td></td>
                                </tr>
                            </tbody>
                            <!-- <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">电话</span></td>
                                <td><input id="inputTel" class="infos form-control" type="text"  name="Tel" /> </td>
                                <td><small></small></td>
                            </tr>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td id="telError" class="text-danger"></td>
                                    <td></td>
                                </tr>
                            </tbody> -->
                            <tr class="">
                                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                <td><span class="">姓名</span></td>
                                <td><input class="infos form-control" type="text" placeholder="" name="RealName" id="RealName"/> </td>
                                <td><small></small></td>
                            </tr>
                            
                            <tr>
                                <td></td>
                            </tr>

                            <tr>
                                <td></td>
                                <td></td>
                                <td><input class="btn btn-success" type="submit" value="注册" onclick="register()"></td>
                                
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
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
           
        <div class="col-md-1"></div>
    </div>
    </div>
</body>
 
<script src="../js/jquery-3.4.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/register.js"></script>



</html>