<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用户个人信息</title>


    <link rel="icon" href="/ReviewSystem/img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/ReviewSystem/img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <style>
		body{
			margin-top: 50px;
            background-color: rgb(241, 239, 239);
			
		}
        .project-created{
            width: 300px;
            height: 200px;
            margin-top: 20px;
            background-color: white;
        }
		
        .plus{
            font-size: 100px;
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
						<li class="active" role="presentation"><a href="userPage.html">主页</a></li>
						<li role="presentation"><a href="" ></a></li>
						
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
								<li role="menuitem"><a href="#">正在开发</a></li>
							</ul>
						</li>
					</ul>
	
				</div>
			</div>
			
		</nav>
        <div class="jumbotron" style="background-color: rgb(111, 168, 243);">
				<h2>
					欢迎使用评审系统
				</h2>
				<p>
					在下方你可以填写你的个人信息和提交你的项目。
				</p>

        </div>
        <div class="row clearfix">
            <div class="col-md-1"></div>
            <div class="col-md-1 column">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active">
                         <a href="#">首页</a>
                    </li>
                    <li class="disabled">
                         <a href="#">简介</a>
                    </li>
                    <li class="disabled">
                         <a href="#">信息</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-8 column">
                <h3>
                    您好，申请人！
                </h3>
                <div class="tabbable" id="tabs-79421">
                    <ul class="nav nav-tabs">
                        <li class="active">
                             <a href="#panel-395407" data-toggle="tab">我的个人资料</a>
                        </li>
                        <li>
                             <a href="#panel-601064" data-toggle="tab" id="create">我创建的项目</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-395407">                       
                           <form action="/ReviewSystem/User_update_information_servlet" method="POST" class="" id="update">
                             <input type="hidden" class="" name="id" value="${user.userId}">
                             <input type="hidden" class="" name="flag" value="${user.userflag}">
                                <div class="form-horizontal">
                                	<div class="form-group">
                                        <label class="col-md-1">用户名字：</label>
                                        <div class="col-md-8" id="userInput">
                                            <input type="text" class="" name="name" value="${user.name}">
                                        </div>                          
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-1">学号：</label>
                                        <div class="col-md-8" id="userInput1">
                                            <input type="text" class="" name="number" value="${user.number}" readonly="readonly">不可修改
                                        </div>                          
                                    </div>  
                                    <div class="form-group">
                                        <label class="col-md-1">密码：</label>
                                        <div class="col-md-8" id="userInput2">
                                            <input type="text" class="" name="password" value="${user.password}">
                                        </div>                          
                                    </div> 
                                    <div class="form-group">
                                        <label class="col-md-1" >电子邮箱：</label>
                                        <div class="col-md-8" id="ocuInput">
                                            <input type="text" class="" name="email" value="${user.email}">
                                        </div>    
                                    </div>                                   
                                    <div class="form-group">
                                        <label class="col-md-1">电话号码：</label>
                                        <div class="col-md-8" id="schInput">
                                            <input type="text" class="" name="tel" value="${user.tel}">
                                        </div>    
                                    </div>       
                                        <div>
							      			  	<input type="submit" class="btn btn-info" value="提交">
    									</div>>                       
                                </div>       
                                      	           
                            </form>
                        </div>
                        <div class="tab-pane" id="panel-601064">
							                         <div class="col-md-10 project-info well well-lg">
									           <table class="table table-hover ">
									                <thead>
									                    <tr>
									                        <td><label>序号</label></td>
									                        <td><label>我的项目名称</label></td>
									                        <td><label>参加的项目类型</label></td>
									                        <td><label>申请人</label></td>
									                    </tr>
									                </thead>
									                <tbody>
										                <c:forEach items = "${items}" var="item">
										                    <tr>
										                        <td><span>${item.itemId}</span></td>
										                        <td><span>${item.itemName}</span></td>
										                        <td><span>${item.gameName}</span></td>
										                        <td><span>${item.userName}</span></td>
										                    </tr>
										                </c:forEach>
									                </tbody>
									           </table>
							        </div>
                            <div class="mycreated">
                                <ul class="project-list list-unstyled">
                                    <li class="project-created btn btn-default">
                                        <a id="createNew" href="addProject.jsp">
                                            <div class="plus">+</div>
                                            <p>创建新项目</p>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-1"></div>
        </div>

    </div>


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

    <script src="/ReviewSystem/js/jquery-3.4.1.min.js"></script>
    <script src="/ReviewSystem/js/bootstrap.min.js"></script>
    <!-- <script src="js/scripts.js"></script> -->
  </body>
</html>