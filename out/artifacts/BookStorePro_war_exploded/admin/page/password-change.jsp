<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改密码</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- page style -->
    <style>
        .my_content{
            padding: 9% 30%;
            height: 60%;
            /*background: #f00;*/
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
                <!-- <li><a href="#"><i class="fa fa-dashboard"></i> </a></li> -->
                <!-- <li class="active"></li> -->
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">
            <div class="my_content">
                <!-- Horizontal Form -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">修改密码</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form id="form1" class="form-horizontal"  method="post" action="updatePassword.do">
                        <div class="box-body">
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="cpassword" placeholder="原密码" name="cpassword">
                                    <span class="msg-default "></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="npassword" placeholder="新密码" name="npassword">
                                    <span class="msg-default ">密码长度在6到12位之间</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-10">
                                    <input type="password" class="form-control" id="cnpassword" placeholder="再次输入密码" name="cnpassword">
                                    <span class="msg-default "></span>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <input type="button" class="btn btn-primary pull-right" onclick="sub();" id="submits" value="提交">
                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>
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
<script type="text/javascript">
    function sub() {
        var inputs = document.getElementsByTagName("input");
        var count = 0;
        for(var i = 0; i < inputs.length-1;i++){
            msg = inputs[i].nextElementSibling;
            if(msg.className=="msg-success")
                count++;
            //alert(msg);
        }
        //alert(count.toString());
        if(count==2) {
            alert("修改成功");
            document.getElementById("form1").submit();
        }
        else alert("请输入正确信息");
    }
</script>

<script>
    /*1.对用户名进行验证*/
    // 获取XML
    var xmlhttp = null;
    if(window.XMLHttpRequest){
        xmlhttp = new XMLHttpRequest();
    }
    else{
        xmlhttp = new ActiveXObject("Microsoft.XMLHttpRequest");
    }
    $('#cpassword').blur(function(){
        var u = document.getElementById("cpassword");
        var upwd = u.value;
        var name = ${admin.admin_name};
        //"product="+product+"&user_id="+user_id+"&count="+count;
        var url = "name="+name+"&upwd="+upwd;
        // 处理回调函数
        //console.log(name);
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.status==200&&xmlhttp.readyState==4){
                var msg = xmlhttp.responseText;
                if(msg=="true"){
                    u.nextElementSibling.innerHTML = '密码正确';
                    u.nextElementSibling.className = 'msg-success';
                }
                else{
                    u.nextElementSibling.innerHTML = '密码错误';
                    u.nextElementSibling.className = 'msg-error';
                }
                //console.log(msg);
            }
        }
        // 先执行这个,再执行上面的
        // 进入到wed.xml通过执行checkName.do进入到UserCheckNameSerlvet并把name值传到里面
        xmlhttp.open("get","checkPassword.do?"+url);
        //xmlhttp.open("get","saveCart.do?"+);
        xmlhttp.send();
    });


    $('#cnpassword').blur(function(){
        var u = document.getElementById("npassword");
        var v = document.getElementById("cpassword");
        var upwd = u.value;
        var upwd1 = v.value;
        var url = "upwd="+upwd+"&upwd1="+upwd1;
        // 处理回调函数
        //console.log(name);
        xmlhttp.onreadystatechange=function(){
            if(xmlhttp.status==200&&xmlhttp.readyState==4){
                var msg = xmlhttp.responseText;
                if(msg=="true"){
                    v.nextElementSibling.innerHTML = '密码一致';
                    v.nextElementSibling.className = 'msg-success';
                }
                else{
                    v.nextElementSibling.innerHTML = '密码不一致';
                    v.nextElementSibling.className = 'msg-error';
                }
                //console.log(msg);
            }
        }
        // 先执行这个,再执行上面的
        // 进入到wed.xml通过执行checkName.do进入到UserCheckNameSerlvet并把name值传到里面
        xmlhttp.open("get","checkPasswords.do?"+url);
        xmlhttp.send();
    });

</script>
</body>
</html>
