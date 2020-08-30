<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: hl2333
  Date: 2020/8/2
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ranks</title>
</head>
<body>
    <h1>本项目的所有排名</h1>
    <table id="rank" border="1">
        <tr>
            <td>项目名称</td>
            <td>作者姓名</td>
            <td>分数</td>
            <td>排名</td>
        </tr>
        <c:forEach items="${requestScope.ranks}" var="grade">
            <tr>
                <td>${grade.itemName}</td>
                <td>${grade.userName}</td>
                <td>${grade.grade}</td>
                <td>${grade.rank}</td>
            </tr>
        </c:forEach>
    </table><br/>
<input type="button" onclick="exportRank()" value="导出结果">

</body>
<script src="../js/ranks.js"></script>
</html>
