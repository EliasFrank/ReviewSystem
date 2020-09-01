<%--
  Created by IntelliJ IDEA.
  User: hl2333
  Date: 2020/9/1
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<c:if test="${user.userId != 1}">
    <a href="/ReviewSystem/jsp/login.jsp">您的权限不够，请以专家账号登录</a>
</c:if>
<c:if test="${user.userId == 1}">
<head>
    <title>专家选择界面</title>
</head>
<body>
    <a href="/ReviewSystem/jsp/userPage.jsp">以用户身份登录</a>
    <a href="/ReviewSystem/SelectItemsServlet">以专家身份登录</a>
</body>
</c:if>
</html>
