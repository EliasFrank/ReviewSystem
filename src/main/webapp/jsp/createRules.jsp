<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html lang="en">
<c:if test="${user.userflag != 0}">
    <a href="/ReviewSystem/jsp/login.jsp">您的权限不够，请以管理员账号登录</a>
</c:if>
<c:if test="${user.userflag == 0}">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>主页</title>


    <link rel="icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon">
    <link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- <link rel="stylesheet" href="css/bootstrap.min.css"> -->

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
        #del{
            margin-left: 3px;
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
                            <li class="active" role="presentation"><a href="">主页</a></li>
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
                                    <li role="menuitem"><a href="#">python</a></li>

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
            <form action="" method="POST" id="gameForm" enctype="multipart/form-data">
                <table class="table">
                    <tbody id="standard">
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>设置项目类型</span></td>
                            <td><input type="text" class="form-control" id="type" name="type"></td>
                            <td><small>设置本次比赛的项目类型</small></td>
                        </tr>
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>设置项目名称</span></td>
                            <td><input type="text" class="form-control" id="name" name="name"></td>
                            <td><small>设置本次比赛的项目名称</small></td>
                        </tr>
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>设置欢迎标语</span></td>
                            <td><input type="text" class="form-control" id="welcome" name="welcome"></td>
                            <td><small>设置本次比赛的欢迎标语</small></td>
                        </tr>
                        <tr name="">
                            <td><span class="star">*</span></td>
                            <td><span>项目评分标准（不超过十项）</span></td>
                            <td><input type="text" class="form-control" placeholder="评分标准名" name="standard" id="standard1"></td>
                            <td><input type="text" class="form-control" placeholder="分数占比" name="standardGrade" id="standardGrade1"></td>
                            <td><button class="btn btn-info" type="button" id="add">添加</button><button class="btn btn-danger" type="button" id="del">删除</button></td>

                        </tr>
                    </tbody>
                    <tbody class="">
                        <tr>
                            <td><span>*</span></td>
                            <td><span>起始日期</span></td>
                            <td class="date input-group" id="start-date"><input type="text" class="form-control" id="startTime" name="startTime"><span class="input-group-addon">
                                <i class="glyphicon glyphicon-calendar"></i>
                            </span>  </td>
                            <td><span></span></td>
                        </tr>
                        <tr>
                            <td><span>*</span></td>
                            <td><span>终止日期</span></td>
                            <td class="date input-group" id="end-date"><input type="text" class="form-control" id="endTime" name="endTime"><span class="input-group-addon">
                                <i class="glyphicon glyphicon-calendar"></i>  
                            </span>  </td>
                            <td><span></span></td>
                        </tr>
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>申报说明</span></td>
                            <td><textarea name="introduce" cols="80" rows="10" id="introduce" placeholder="对项目的描述，项目背景，用户群体等。"></textarea></td>
                            <td><small></small></td>
                        </tr>
                        <tr>
                            <td><span class="star">*</span></td>
                            <td><span>大赛文件上传</span></td>
                            <td><input type="file" class="" id="exampleInputFile" name="inputFile"></td>
                            <td><small></small></td>
                        </tr>
                    </tbody>
                   
                </table>
            </form>
        </div>
        <div class="col-md-1"></div>
        
    </div>
    <div class="text-center">
        <a class="btn btn-info" onclick="addGame();">发布</a>
        <a href="<c:url value='/jsp/admin.jsp'/>" class="btn btn-default">取消</a>
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

    <script src="/ReviewSystem/js/jquery-3.4.1.min.js"></script>
    <script src="/ReviewSystem/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcss.com/moment.js/2.18.1/moment-with-locales.min.js"></script>  
    <link href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
    <script src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script> 
    <script src="/ReviewSystem/js/createRules.js"></script>
    <script type="text/javascript">
     $(function () {  
        $('#start-date').datetimepicker({  
            format: 'YYYY-MM-DD',  
            locale: moment.locale('zh-cn')  
        });  
    });
     $(function () {  
        $('#end-date').datetimepicker({  
            format: 'YYYY-MM-DD',  
            locale: moment.locale('zh-cn')  
        });  
    });
         
    </script>

    <!-- <script src="js/scripts.js"></script> -->
  </body>
</c:if>
</html>