<%--
  Created by IntelliJ IDEA.
  User: ZhangDabin
  Date: 2019/7/10
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>所有订单</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>

    </style>
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="../css/datatables.net-bs/dataTables.bootstrap.min.css">
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
        <a href="index.jsp" class="logo">
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
                    <a href="index.jsp"><i class="fa fa-link"></i> <span>订单管理</span>
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
            <h1>
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><i class="fa fa-dashboard">&nbsp;订单管理</i></li>
                <li class="active">所有订单</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
            <div class="box box-primary">
                <div class="box-body">
                    <table id="my_order" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>订单编号</th>
                            <th>订单状态</th>
                            <th>创建时间</th>
                            <th>订单总额</th>
                            <th>可选操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${bean}" var="orderlist">
                            <tr>
                                <td>${orderlist.order_id}</td>
                                <c:choose>
                                    <c:when test="${orderlist.sta=='待处理'}">
                                        <td><span class="label bg-yellow">${orderlist.sta}</span></td>
                                    </c:when>
                                    <c:when test="${orderlist.sta=='处理中'}">
                                        <td><span class="label bg-aqua">${orderlist.sta}</span></td>
                                    </c:when>
                                    <c:when test="${orderlist.sta=='已发货'}">
                                        <td><span class="label bg-green">${orderlist.sta}</span></td>
                                    </c:when>
                                    <c:when test="${orderlist.sta=='已交付'}">
                                        <td><span class="label bg-red">${orderlist.sta}</span></td>
                                    </c:when>
                                </c:choose>
                                <td>${orderlist.placed}</td>
                                <td>￥${orderlist.payment}</td>
                                <td><a href="lookOrderDetail.do?order_id=${orderlist.order_id}">查看</a>丨
                                    <c:choose>
                                        <c:when test="${orderlist.sta=='已交付'}">
                                            处理
                                        </c:when>
                                        <c:otherwise>
                                            <a href="OrderProcess.do?order_id=${orderlist.order_id}">处理</a>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
                <!-- /.box-body -->
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
<!-- DataTables -->
<script src="../js/datatables.net/jquery.dataTables.min.js"></script>
<script src="../js/datatables.net-bs/dataTables.bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script><!-- moment -->
<!-- <script src="../js/moment/moment.min.js"></script> -->
<!-- page script -->
<script>
    $(function () {
        $('#my_order').DataTable({
            'paging': true,
            'lengthChange': false,
            'searching': false,
            'ordering': false,
            'info': true,
            'autoWidth': false,
            'pagingType': 'full_numbers'/*,
     'processing': true,
     'serverSide': true,
     'ajax': '../servlet/all-order',
     'columns': [
    	    { 'data': 'orderId' },// 订单编号219
    	    { 'data': 'sta' , 'render': function (data, type, row, meta) {
    	    	var content = null;
    	    	switch(meta.row%4){
    	    		case 0:content = '<span class="label bg-yellow">'+data+'</span>';break;
    	    		case 1:content = '<span class="label bg-aqua">'+data+'</span>';break;
    	    		case 2:content = '<span class="label bg-green">'+data+'</span>';break;
    	    		case 3:content = '<span class="label bg-red">'+data+'</span>';break;
    	    	}
    	    	return content;
		      }
		    },// 订单状态<span class="label bg-red">已交付</span>
    	    { 'data': 'placed' , 'render': function (data, type, row, meta) {
	    	    	return moment(data).format('YYYY-MM-DD HH:mm');
		    	}
	    	},// 创建时间2014-11-7 11:31
    	    { 'data': 'payment' , 'render': function (data, type, row, meta) {
	    	    	return '￥'+data.toFixed(2);
    	    	}
    	    },// 订单总额￥10.70
    	    { 'data': 'sta' , 'render': function (data, type, row, meta) {
    	    	var content = '<a href="../servlet/order-detail?orderId='+row.orderId+'">查看</a>丨';
    	    	if(data=='已交付'){
    	    		content+='处理';
    	    	}else{
    	    		content+='<a href="../servlet/order-process?orderId='+row.orderId+'">处理</a>';
    	    	}
    	    	return content;
	    	  }
	    	}// 可选操作<a href="#">查看</a>丨处理
    	  ]
	 */
        })
    })
</script>
</body>
</html>

