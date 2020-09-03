<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
${user.userId}
<c:choose>
    <c:when test="${user.userId == null}">
        <a href="/ReviewSystem/jsp/login.jsp">您还未登录，请先进行登录</a>
    </c:when>
    <c:otherwise>
        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <title>项目创建</title>
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
                                <li class="active" role="presentation"><a href="personInfo.html">主页</a></li>
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
                                        <li role="menuitem" class="disabled"><a href="#" class="">正在开发</a></li>

                                    </ul>
                                </li>
                            </ul>

                        </div>
                    </div>

                </nav>
                <div class="jumbotron" style="background-color: rgb(111, 168, 243);">
                    <h2>
                        欢迎创建项目
                    </h2>
                    <p>
                        在下方你需要填写你的项目的相关信息并提交项目文件。
                    </p>

                </div>

            </div>
            <div class="col-md-1"></div>
            <div class="col-md-10 project-info well well-lg">
                <form action="/ReviewSystem/UserUploadServlet" method="post"  enctype="multipart/form-data" id="myform" name="myform">
                    <table class="table">
                        <tbody class="">
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>项目类型</span></td>
                            <td>
                                <select name="types" id="selected" class="form-control">
                                    <c:forEach var = "g" items="${gameslist}">
                                        <option value="${g.gameId}">${g.gameName}</option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td><small>项目提交成功后不可修改类型</small></td>
                        </tr>
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>项目名称</span></td>
                            <td><input type="text" class="form-control" placeholder="简洁清晰，不多于30字" name="name" id="projectName"></td>
                            <td><small>项目提交成功后不可修改名称</small></td>
                        </tr>
                        </tbody>
                        <tbody class="">
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>项目介绍</span></td>
                            <td><textarea name="introduce" cols="80" rows="10" id="introduce" placeholder="对项目的描述，项目背景，用户群体等。"></textarea></td>
                            <td><small></small></td>
                        </tr>
                        </tbody>
                        <tbody class="">
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>项目企划书</span></td>
                            <td><input type="file" class="" id="exampleInputFile" name="file"></td>
                            <td><small></small></td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <input type="submit" class="btn btn-info" value="提交">
                    </div>
                </form>
            </div>
            <div class="col-md-1"></div>

        </div>

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

        <script src="<c:url value="/js/jquery-3.4.1.min.js"/>"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <!-- <script src="js/scripts.js"></script> -->
        </body>
    </c:otherwise>
</c:choose>

</html>