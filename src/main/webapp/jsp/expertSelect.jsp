<%--
  Created by IntelliJ IDEA.
  User: hl2333
  Date: 2020/9/1
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>



<html>

<head>
    <title>专家选择界面</title>
</head>
<link rel="icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
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
<body>
    <div class="container">
        <div class="col-md-3"></div>
            <div class="col-md-6">
                <div class="well well-lg" style="margin-top: 120px; background-color: #eee;">
                    <center>
                        <h2>登录</h2>
                    </center>
                    <br>
                    
                    
                            <!-- 下面这个我不知道怎么改，黄雷你待会改一下 -->
                            <!-- ${user.userflag} -->
                            <c:if test="${user.userflag == 1}">
                                <div class="form-group text-center">
                                    <a class="btn btn-info" href="/ReviewSystem/jsp/userPage.jsp">以用户身份登录</a>
                                    <a class="btn btn-success" href="/ReviewSystem/SelectItemsServlet">以专家身份登录</a>
                                </div>
                            </c:if>
                           <c:if test="${user.userflag != 1}">
                                <a href="/ReviewSystem/jsp/login.jsp">权限不足，请切换管理员账号登录</a>
                            </c:if>
                            <!-- <label for="my-input">Text</label> -->
                    </form>
                </div>
                
            </div>
            <div class="col-md-3"></div>
    </div>

</body>



</html>
