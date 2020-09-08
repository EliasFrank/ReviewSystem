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
</style>
<body>
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
                    欢迎查看项目的排名
                </h2>
                <p>
                    在下方你可以为申请的项目进行查看和导出。
                </p>
    
            </div>
        
            <div class="col-md-1"></div>
            <div class="col-md-10 project-info">
                <h1>本项目的所有排名</h1>
                <table id="rank" border="1" class="table table-hover">
                    <thead>
                        <tr>
                            <td>项目名称</td>
                            <td>作者姓名</td>
                            <td>分数</td>
                            <td>排名</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.ranks}" var="grade">
                            <tr>
                                <td>${grade.itemName}</td>
                                <td>${grade.userName}</td>
                                <td>${grade.grade}</td>
                                <td>${grade.rank}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                        
                </table><br/>
                
            </div>

            <div class="col-md-1"></div>
            
            
        </div>
        <br>
        <div class="col-md-1"></div>
        <div class="text-right col-md-10">
            <input class="btn btn-info" type="button" onclick="exportRank()" value="导出结果">
        </div>
        <div class="col-md-1"></div>

    </div>
   
</body>
<script src="/ReviewSystem/js/ranks.js"></script>
</html>
