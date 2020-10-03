<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${user.userflag == 1}">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>所有项目</title>


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
        .center-block {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
        .star{
            color: red;
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
        #giant{
            height: 180px;
        }
	</style>

  </head>
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
                            <li class="active" role="presentation"><a href="professor.jsp">主页</a></li>
                            <li role="presentation"><a href="professor.jsp" ></a></li>
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
                            <li><a href="/ReviewSystem/LogoutServlet">退出</a></li>
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
                        欢迎查看项目
                    </h2>
                    <p>
                        在下方你可以为申请的项目进行查看和打分。
                    </p>

            </div>

        </div>
        <div class="col-md-1"></div>
        <div class="col-md-10 project-info well well-lg">
           <table class="table table-hover ">
                <thead>
                    <tr>
                        <td><label>用户名</label></td>
                        <td><label>比赛名称</label></td>
                        <td><label>项目名称</label></td>
                        <td><label>项目总分</label></td>
                        <td><label>操作</label></td>                                        
                    </tr>
                </thead>
                <tbody>
	                <c:forEach var = "i" items="${items}">
	                    <tr>
	                        <td><span>${i.userName}</span></td>
	                        <td><span>${i.gameName}</span></td>
	                        <td><span>${i.itemName}</span></td>
	                        <td><span>${i.grade}</span></td>
	                        <td>
                                <c:if test="${i.isUsed == 0}">
                                    <a href="/ReviewSystem/getPartServlet?itemId=${i.itemId}&gameId=${i.gameId}">评分</a>
                                </c:if>
                                <c:if test="${i.isUsed == 1}">
                                    已评分
                                </c:if>
                            </td>
	                    </tr>
	                </c:forEach>
                </tbody>
           </table>
        </div>
        <div class="col-md-1"></div>
        
        
    </div>
    <div class="navbar navbar-fixed-bottom">
        <div class="container">
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
    

    <script src="<c:url value="/js/jquery-3.4.1.min.js"/>"></script>
    <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
    <!-- <script src="js/scripts.js"></script> -->
  </body>
</c:if>
<c:if test="${user.userflag != 1}">
    <a href="/ReviewSystem/jsp/login.jsp">您的权限不够，请以专家账号登录</a>
</c:if>
</html>