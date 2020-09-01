<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<c:if test="${user.userId != 1}">
    <a href="/ReviewSystem/jsp/login.jsp">您的权限不够，请以管理员账号登录</a>
</c:if>
<c:if test="${user.userId == 1}">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>管理员页面</title>


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
						<li class="active" role="presentation"><a href="admin.jsp">主页</a></li>
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
					欢迎使用评审后台管理系统
				</h2>
				<p>
					在下方你可以可以管理用户们的数据和更改其权限，并发布相应的申请项目。
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
                             <a href="#panel-1" data-toggle="tab">我创建的项目</a>
                        </li>
                        <li>
                             <a href="#panel-2" data-toggle="tab" onclick="selectAllCheck()">专家管理</a>
                        </li>
                        <li>
                             <a href="#panel-3" data-toggle="tab" onclick="checkUserApply()">用户申报管理</a>
                        </li>
                        <li>
                             <a href="#panel-4" data-toggle="tab" onclick="chooseExpert()">项目分配专家</a>
                        </li>
                        <li>
                             <a href="#panel-5" data-toggle="tab" onclick="selectAllGames()">所有项目</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-1">
                            <div class="mycreated">
                                <ul class="project-list list-unstyled">
                                    <li class="project-created btn btn-default">
                                        <a id="createNew" href="jsp/createRules.jsp">
                                            <div class="plus">+</div>
                                            <p>创建项目</p>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="tab-pane" id="panel-2">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td><label>用户名</label></td>
                                        <td><label>用户类型</label></td>
                                        <td><label>用户邮箱</label></td>
                                    </tr>
                                </thead>
                                <tbody id="checkUser">
                                 <%--后台ajax加入数据--%>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane" id="panel-3">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td><label>用户账号</label></td>
                                        <td><label>用户名</label></td>
                                        <td><label>项目类型</label></td>
                                        <td><label>项目名称</label></td>
                                    </tr>
                                </thead>
                                <tbody id="checkUserApply">
                                    <%--后台ajax加入数据--%>
                                </tbody>
                            </table>
                        </div>
                        <div class="tab-pane" id="panel-4">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td><label>申请人</label></td>
                                        <td><label>申报项目名称</label></td>
                                        <td><label>比赛项目名称</label></td>
                                        <td><label>申报项目的申请时间</label></td>
                                        <td><label>选择审核专家(ctrl键实现多选)</label></td>
                                    </tr>
                                </thead>
                                <tbody id="chooseExpert">
                                    <%--后台ajax加入数据--%>
                                </tbody>
                            </table>
                        </div>

                        <div class="tab-pane" id="panel-5">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td><label>项目编号</label></td>
                                        <td><label>项目类型</label></td>
                                        <td><label>项目名</label></td>
                                    </tr>
                                </thead>
                                <tbody id="games">
                                    <%--后台ajax加入数据--%>
                                </tbody>
                            </table>
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
    <script src="/ReviewSystem/js/admin.js"></script>
    <script>
        $('#grade').on('shown.bs.modal', function () {
  $('#myInput').focus()
})
    </script>
    <!-- <script src="js/scripts.js"></script> -->
  </body>
</c:if>
</html>