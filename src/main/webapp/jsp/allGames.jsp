<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hl2333
  Date: 2020/8/15
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>所有比赛</title>
</head>
<body>

<script src="<c:url value="/js/allGames.js"/>"></script>
    <table border="1">
        <tr>
            <td>比赛名称</td>
            <td>欢迎标语</td>
            <td>比赛类型</td>
            <td>比赛介绍</td>
            <td>相关文件</td>
            <td>开始时间</td>
            <td>提交截止时间</td>
            <td>提交参赛申请</td>
        </tr>
        <c:forEach items="${games}" var="game">
            <tr>
                <td>${game.gameName}</td>
                <td>${game.welcome}</td>
                <td>${game.type}</td>
                <td><textarea cols="10" rows="10">${game.introduction}</textarea></td>

                <td>
                    <form action="/ReviewSystem/GameDownloadServlet">
                        <input type="hidden" name="annex" value="${game.annex}"/>
                        <input type="submit" value="下载文件"/>
                    </form>
                </td>
                <td>${game.startTime}</td>
                <td>${game.endTime}</td>
                <td><a href="/ReviewSystem/UserApplyGameServlet?gameId=${game.gameId}">申请参加</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
