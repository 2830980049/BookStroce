<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城学子注册页面</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/login.css" rel="stylesheet"/>
</head>
<body>
<!--模态框-->
<div class="modal">
    <div class="modal_header">
        提示信息
    </div>
    <div class="modal_content">
        恭喜您已成功注册达内学子商城！
    </div>
</div>
<!-- 页面顶部-->
<header id="top">
    <div class="top">
        <img src="../img/header/logo.png" alt=""/>
        <span>欢迎注册</span>
    </div>
</header>
<div class="parent">
    <div class="container">
        <div class="panel rt">
            <form id="fm-register" method="post" action="regist.do">
                <div class="txt">
                    <p id="newuser">新用户注册
                        <span>
              <a href="login.html" id="dlogin">直接登录</a>
            </span>
                    </p>
                </div>
                <div class="form-group">
                    <label for="uname">用户名：</label>
                    <input autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus
                           name="uname" id="uname"/>
                    <span class="msg-default">用户名长度在6到9位之间</span>
                </div>
                <div class="form-group">
                    <label for="upwd">登录密码：</label>
                    <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="upwd"
                           autofocus id="upwd"/>
                    <span class="msg-default hidden">密码长度在6到12位之间</span>
                </div>
                <div class="form-group">
                    <label for="email">邮箱：</label>
                    <input autocomplete required type="email" placeholder="请输入邮箱地址" name="email" id="email"/>
                    <span class="msg-default hidden">请输入合法的邮箱地址</span>
                </div>
                <div class="form-group">
                    <label for="phone">手机号：</label>
                    <input id="phone" name="phone" placeholder="请输入您的手机号"
                           pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$"
                           required type="text"/>
                    <span class="msg-default hidden">请输入合法的手机号</span>
                </div>
                <div class="form-group">
                    <label></label>
                    <input type="button" value="提交注册信息" id="bt-register" onclick="sub();"/>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
    <div class="icon1 lf">
        <img src="../img/footer/icon1.png" alt=""/>

        <h3>品质保障</h3>
    </div>
    <div class="icon2 lf">
        <img src="../img/footer/icon2.png" alt=""/>

        <h3>私人定制</h3>
    </div>
    <div class="icon3 lf">
        <img src="../img/footer/icon3.png" alt=""/>

        <h3>学员特供</h3>
    </div>
    <div class="icon4 lf">
        <img src="../img/footer/icon4.png" alt=""/>

        <h3>专属特权</h3>
    </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
    <div id="foot">
        <div class="lf">
            <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
            <p class="footer2"><img src="../img/footer/footerFont.png" alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf">
            <ul>
                <li><a href="#"><h3>买家帮助</h3></a></li>
                <li><a href="#">新手指南</a></li>
                <li><a href="#">服务保障</a></li>
                <li><a href="#">常见问题</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>商家帮助</h3></a></li>
                <li><a href="#">商家入驻</a></li>
                <li><a href="#">商家后台</a></li>
            </ul>
            <ul>
                <li><a href="#"><h3>关于我们</h3></a></li>
                <li><a href="#">关于达内</a></li>
                <li><a href="#">联系我们</a></li>
                <li>
                    <img src="../img/footer/wechat.png" alt=""/>
                    <img src="../img/footer/sinablog.png" alt=""/>
                </li>
            </ul>
        </div>
        <div class="service">
            <p>达内商城客户端</p>
            <img src="../img/footer/ios.png" class="lf">
            <img src="../img/footer/android.png" alt="" class="lf"/>
        </div>
        <div class="download">
            <img src="../img/footer/erweima.png">
        </div>
    </div>
</div>
<!--弹出的小广告-->
<script src="../js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    function sub() {
        var inputs = document.getElementsByTagName("input");
        var count = 0;
        for (var i = 0; i < inputs.length - 1; i++) {
            var msg = inputs[i].nextElementSibling;
            if (msg.className == "msg-success") {
                count++;
            }
        }
        if (count == 4) {
            document.getElementById("fm-register").submit();
        } else {
            alert("请正确输入信息！");
        }
    }

</script>
<script>
    //1.获取AJAX对象
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    /*1.对用户名进行验证*/
    $('#uname').blur(function () {
        if (this.validity.valueMissing) {
            this.nextElementSibling.innerHTML = '用户名不能为空';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('用户名不能为空');
        } else if (this.validity.tooShort) {
            this.nextElementSibling.innerHTML = '用户名不能少于6位';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('用户名不能少于6位');
        } else {
            //获取输入框中的值
            var u = document.getElementById("uname");
            var name = u.value;
            //处理回调函数
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
                    var msg = xmlhttp.responseText;
                    if (msg == "true") {
                        u.nextElementSibling.innerHTML = '用户名已被注册';
                        u.nextElementSibling.className = 'msg-error';
                    } else {
                        u.nextElementSibling.innerHTML = '用户名可用';
                        u.nextElementSibling.className = 'msg-success';
                    }
                }
            }
            xmlhttp.open("get", "checkName.do?name=" + name);
            xmlhttp.send();
        }
    });
    $('#uname').focus(function () {
        this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
        this.nextElementSibling.className = 'msg-default';
    });
    /*2.对密码进行验证*/
    $('#upwd').blur(function () {
        if (this.validity.valueMissing) {
            this.nextElementSibling.innerHTML = '密码不能为空';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('密码不能为空');
        } else if (this.validity.tooShort) {
            this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('密码长度在尽量别少于6位');
        } else {
            this.nextElementSibling.innerHTML = '密码格式正确';
            this.nextElementSibling.className = 'msg-success';
            this.setCustomValidity('');
        }
    });
    $('#upwd').focus(function () {
        this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
        this.nextElementSibling.className = 'msg-default';
    });
    /*3.对邮箱地址进行验证*/
    $('#email').blur(function () {
        if (this.validity.valueMissing) {
            this.nextElementSibling.innerHTML = '邮箱不能为空';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('邮箱不能为空');
        } else if (this.validity.typeMismatch) {
            this.nextElementSibling.innerHTML = '邮箱格式不正确';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('邮箱格式不正确');
        } else {
            this.nextElementSibling.innerHTML = '邮箱格式正确';
            this.nextElementSibling.className = 'msg-success';
            this.setCustomValidity('');
            //  var data =document.getElementById("email").value;
            var data = $("#email").val();
            if (!data) {   //用户没有输入任何内容
                return;
            }
        }
    });
    $('#email').focus(function () {
        this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
        this.nextElementSibling.className = 'msg-default';
    });
    /*4.对手机号进行验证*/
    $('#phone').blur(function () {
        if (this.validity.valueMissing) {
            this.nextElementSibling.innerHTML = '手机号不能为空';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('手机号不能为空');
        } else if (this.validity.patternMismatch) {
            this.nextElementSibling.innerHTML = '手机号格式不正确';
            this.nextElementSibling.className = 'msg-error';
            this.setCustomValidity('手机号格式不正确');
        } else {
            //获取输入框中的值
            var u = document.getElementById("phone");
            var phone = u.value;
            //处理回调函数
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
                    var msg = xmlhttp.responseText;
                    if (msg == "true") {
                        u.nextElementSibling.innerHTML = '手机号已被注册';
                        u.nextElementSibling.className = 'msg-error';
                    } else {
                        u.nextElementSibling.innerHTML = '手机号可用';
                        u.nextElementSibling.className = 'msg-success';
                    }
                }
            }
            xmlhttp.open("get", "checkPhone.do?phone=" + phone);
            xmlhttp.send();
        }
    });
    $('#phone').focus(function () {
        this.nextElementSibling.innerHTML = '请输入合法的手机号';
        this.nextElementSibling.className = 'msg-default';
    });
</script>
</body>
</html>
    