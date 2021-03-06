<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 从session中获取参数:islogin,identity,id,name,islock(user)显示欢迎信息、登录登出按钮、论坛图标、搜索框等 -->
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/nprogress.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/nprogress.js"></script>
    <script src="js/jquery.lazyload.min.js"></script>
    <!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href = 'upgrade-browser.html';</script>
    <![endif]-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet">
    <!-- Google Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <style>
        div {
            text-align: center; /*让div内部文字居中*/
        }
    </style>

</head>


<body style="font-family:STKaiTi">
<header class="header">
    <nav class="navbar navbar-default" id="navbar">
        <div class="container">
            <div class="header-topbar hidden-xs link-border">
                <div class="row">
                    <div class="col-md-4 col-sm-4">
                        <a href="homepage.jsp" title="南邮论坛">
                            <img src="images/icon_nanyou.jpg" alt="欢迎来到南邮论坛~">
                        </a>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <c:if test="${islogin==true}">
                            <c:if test="${username!=null}">
                                <h1>欢迎您的到来!</h1>
                                <h1>${username}</h1>
                            </c:if>
                            <c:if test="${adminname!=null}">
                                <h1>欢迎您的到来!</h1>
                                <h1>管理员${adminname}</h1>
                            </c:if>
                        </c:if>
                        <c:if test="${(username==null)&&(adminname==null)}">
                            <h1>欢迎您的到来，游客！</h1>
                        </c:if>
                    </div>
                    <div class="col-md-2 col-sm-2">
                        <c:if test="${islogin==true}">
                            <a href="Logout" class="btn btn-default btn-lg">Log Out</a>

                        </c:if>
                        <c:if test="${(username==null)&&(adminname==null)}">
                            <a href="login.jsp" class="btn btn-default">Sign In</a>
                            OR
                            <a href="register.jsp" class="btn btn-default">Sign Up</a>
                        </c:if>
                        <c:if test="${islogin!=true}">
                            <a href="adminlogin.jsp" class="btn btn-default" title="管理员登录">管理员登录</a>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="collapse navbar-collapse" id="header-navbar">
                <div class="row">
                    <div class="col-md-4 col-sm-4">
                        <form class="navbar-form" action="Search" method="post">
                            <div class="input-group">
                                <input type="text" name="keyword" class="form-control" size="35" placeholder="请输入关键字"
                                       maxlength="15" autocomplete="off">
                                <span class="input-group-btn">
								<button class="btn btn-default btn-search" name="search" type="submit">搜索</button>
							</span>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-8 col-sm-8">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a data-cont="最新" title="最新" href="Board?board=1">最新</a></li>
                            <li><a data-cont="课程" title="课程" href="Board?board=2">课程</a></li>
                            <li><a data-cont="饭堂" title="饭堂" href="Board?board=3">饭堂</a></li>
                            <li><a data-cont="宿舍" title="宿舍" href="Board?board=4">宿舍</a></li>
                            <li><a data-cont="教室" title="教室" href="Board?board=5">教室</a></li>
                            <li><a data-cont="图书馆" title="图书馆" href="Board?board=6">图书馆</a></li>
                            <li><a data-cont="留言板" title="留言板" href="Board?board=7">留言板</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>

</body>
</html>