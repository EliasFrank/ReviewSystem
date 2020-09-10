<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hl2333
  Date: 2020/8/15
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有比赛</title>
</head>
<link rel="icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
<link rel="shortcut icon" href="<c:url value="/img/favicon.ico"/>" type="image/x-icon">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
<style>
    body{
			margin-top: 50px;
            background-color: rgb(241, 239, 239);
			
		}
    .project-info{
        background-color: white;
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
    #textarea{
        font-size: small;
        resize: none;
    }
</style>
<body>

<script src="<c:url value="/js/allGames.js"/>"></script>

    <div class="container-fluid">
        <div class="row">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a href="#" class="navbar-brand">@</a>
                    </div>
        
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav" id="mytab" role="tablist">
                            <li class="active" role="presentation"><a href="professor.html">主页</a></li>
                            <li role="presentation"><a href="professor.html" ></a></li>
                            
                        </ul>
        
                    
        
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" placeholder="搜索" class="form-control">
                            </div>
                            <button class="btn btn-info" type="submit">搜索</button>
                        </form>
        
                        <ul class="nav navbar-nav navbar-right">
                            <li role="presentation" class="">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-comment"><span class="badge"></span></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li role="menuitem"><a href="#">我的私信</a></li>
                                    <li role="menuitem"><a href="#">系统通知</a></li>
                                </ul>
                            </li>
                            <li><a href="login.html">退出</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">More<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li role="menuitem"><a href="#">python</a></li>

                                </ul>
                            </li>
                        </ul>
        
                    </div>
                </div>
                
            </nav>
            <div class="jumbotron" id="giant" style="background-color: rgb(111, 168, 243);">
                <h2>
                    欢迎查看所有可以参加的比赛
                </h2>
                <p>
                    在下方你可以申请参加项目或查看比赛的相关信息。
                </p>
    
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-10 project-info">
                <table class="table" border="1">
                    <thead>
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
                    </thead>
                <tbody>
                    <c:forEach items="${games}" var="game">
                    <tr>
                        <td>${game.gameName}</td>
                        <td>${game.welcome}</td>
                        <td>${game.type}</td>
                        <td><textarea cols="20" rows="3" id="textarea" readonly="readonly" >${game.introduction}</textarea></td>

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
                </tbody>
       
    </table>
            </div>
        </div>
    </div>

    
</body>
</html>
