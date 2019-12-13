<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11
  Time: 00:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商品编辑</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>
        .my-input{
            width: 22.77777778% !important;
        }
        .my-label{
            width: 10.55555555% !important;
        }
        .my-img{
            padding-right: 2.0% !important;
            padding-left: 8.0% !important;
        }
        .datepicker{
            z-index: 9999 !important;
        }
    </style>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../css/AdminLTE/AdminLTE.min.css">
    <!-- AdminLTE Skin -->
    <link rel="stylesheet" href="../css/AdminLTE/skin/skin-blue.min.css">
    <!-- Google Font -->
    <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>书城</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">学子书城管理系统</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">导航切换</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <!-- /.messages-menu -->
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="../img/setting.png" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${user.uname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header">
                                <img src="../img/word.jpg" class="img-circle" alt="User Image">
                                <p>让学习成为一种习惯</p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="password-change.jsp" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a href="login.jsp" class="btn btn-default btn-flat">退出</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">&nbsp;</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>订单管理</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="orderList.do">所有订单</a></li>
                        <li><a href="orderClassify.do?sta=待处理">待处理</a></li>
                        <li><a href="orderClassify.do?sta=处理中">处理中</a></li>
                        <li><a href="orderClassify.do?sta=已发货">已发货</a></li>
                        <li><a href="orderClassify.do?sta=已交付">已交付</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-link"></i> <span>商品管理</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="queryBooks.do">所有商品</a></li>
                        <li><a href="product-add.jsp">添加商品</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1><small></small></h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard">&nbsp;商品管理</i></li>
                <li><a href="product-list.jsp"><i class="fa"></i>所有商品</a></li>
                <li class="active">商品编辑</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
            <!-- Horizontal Form -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">详细编辑</h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form class="form-horizontal" action="updatePrice.do" role="form" id="form1">
                    <div class="box-body">

                        <div class="form-group">
                            <label for="isbn" class="col-sm-2 control-label my-label">图书编号</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="isbn" id="isbn" value="${admin_book.isbn}" readonly>
                            </div>
                            <label for="title" class="col-sm-2 control-label my-label">书名</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="title" id="title" value="${admin_book.title}" readonly>
                            </div>
                            <label for="author" class="col-sm-2 control-label my-label">作者</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="author" id="author" value="${admin_book.author}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="price" class="col-sm-2 control-label my-label">价格</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="price" id="price" value="${admin_book.price}">
                            </div>
                            <label for="pages" class="col-sm-2 control-label my-label">页数</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="pages" id="pages" value="${admin_book.pages}" readonly>
                            </div>
                            <label for="words" class="col-sm-2 control-label my-label">字数</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="words" id="words" value="${admin_book.words}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="press" class="col-sm-2 control-label my-label">出版社</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="press" id="press" value="${admin_book.press}" readonly>
                            </div>
                            <label for="edition" class="col-sm-2 control-label my-label">版次</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="edition" id="edition" value="${admin_book.edition}" readonly>
                            </div>
                            <label for="published" class="col-sm-2 control-label my-label">出版日期</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="published" id="published" value="${admin_book.published}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="format" class="col-sm-2 control-label my-label">开本</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="format" id="format" value="${admin_book.fromat}" readonly>
                            </div>
                            <label for="packaging" class="col-sm-2 control-label my-label">包装</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="packaging" id="packaging" value="${admin_book.packaging}" readonly>
                            </div>
                            <label for="form" class="col-sm-2 control-label my-label">用纸</label>
                            <div class="col-sm-10 my-input">
                                <input type="text" class="form-control" name="form" id="form" value="${admin_book.form}" readonly>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-4 my-img">
                                <img class="img-responsive" src="../../user/img/goods/${admin_book.isbn}/detail1big.jpg" alt="暂无图片">
                            </div>
                            <div class="col-sm-4 my-img">
                                <img class="img-responsive" src="../../user/img/goods/${admin_book.isbn}/detail2big.jpg" alt="暂无图片">
                            </div>
                            <div class="col-sm-4 my-img">
                                <img class="img-responsive" src="../../user/img/goods/${admin_book.isbn}/detail3big.jpg" alt="暂无图片">
                            </div>
                        </div>

                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <input type="button" onclick="sub();" class="btn btn-primary pull-right" value="提交">
                    </div>
                    <!-- /.box-footer -->
                </form>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            缔造年轻人的中国梦
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2021 <a href="http://www.tedu.cn">达内教育</a>.</strong> All rights reserved.
    </footer>

    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>
    var isbn = $("#isbn").val();
    var price = $("#price").val();
    $.ajax({
        type:'post',
        data:'isbn='+isbn+'&price='+price,
        url:'productEdit.action',
        success:function(data){
            console.log('开始处理响应数据');
            // alert("*"+data+"*");
            if(data=='yes'){
                window.location.href="../page/product-detail.html";
            }
        }
    });
    function sub() {
        var price = document.getElementById("price");
        var x = price.value;
        var flag = false;
        //alert(x.toString());
        if(x!=null&&x!="")
            flag = true;
        if(flag){
            alert("修改成功");
            document.getElementById("form1").submit();
        }
        else alert("价格不能为空");
    }
</script>
</body>
</html>