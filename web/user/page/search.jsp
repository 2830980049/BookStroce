<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.tarena.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城学子餐饮页</title>
    <link href="../css/item.food.css" rel="stylesheet" />
    <link href="../css/header.css" rel="stylesheet" />
    <link href="../css/footer.css" rel="stylesheet" />
    <link href="../css/slide.css" rel="stylesheet" />
    <script type="text/javascript" src="../js/search.js">	
    </script>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img src="../img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a onclick="Search();" class="rt">
        <img id="search" src="../img/header/search.png" alt="搜索"/>
        </a>
    </div>
    <div class="rt">
        <ul class="lf">
            <li><a href="index.jsp">首页</a><b>|</b></li>
            <li><a href="collections.do">收藏</a><b>|</b></li>
            <li><a href="order.html">订单</a><b>|</b></li>
            <li><a href="CartDetailQuery.do">购物车</a><b>|</b></li>
            <li><a href="password-change.html">设置</a><b>|</b></li>
            <%
                HttpSession s = request.getSession();
                User user = (User) s.getAttribute("user");
                if (user != null) {
            %>
            <li><a href="#"><%=user.getUname()%>
            </a><b>|</b></li>
            <li><a href="exit.do">退出</a><b>|</b></li>
            <%} else { %>
            <li><a href="login.jsp">登录</a><b>|</b></li>
            <%} %>
            <li><a href="lookforward.html">帮助</a></li>
        </ul>
    </div>
</header>
<!-- nav主导航-->
<div>&nbsp;</div>
<!-- banner部分-->
<div class="ck-slide">
    <ul class="ck-slide-wrapper">
        <li>
            <a href="detail.html"><img src="../img/banner/banner1.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="detail.html"><img src="../img/banner/banner2.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="detail.html"><img src="../img/banner/banner3.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="detail.html"><img src="../img/banner/banner4.png" alt=""></a>
        </li>
        <li style="display:none">
            <a href="detail.html"><img src="../img/banner/banner5.png" alt=""></a>
        </li>
    </ul>
    <a href="javascript:;" class="ctrl-slide ck-prev">上一张</a> <a href="javascript:;" class="ctrl-slide ck-next">下一张</a>
    <div class="ck-slidebox">
        <div class="slideWrap">
            <ul class="dot-wrap">
                <li class="current"><em>1</em></li>
                <li><em>2</em></li>
                <li><em>3</em></li>
                <li><em>4</em></li>
                <li><em>5</em></li>
            </ul>
        </div>
    </div>
</div>
<!--商品-->
<div class="store">
    <div class="store_top">
        <img src="../img/banner/icon.png" alt=""/>
        热搜排行
    </div>
	<div class="store_content">
		<c:forEach items="${pageBean.listBean}" var="list">
			<div>
	            <a href="detail.html"><img src="../img/goods/${list.isbn}/index.jpg" alt=""/></a>
	            <p class="one">${list.title}</p>
	            <p class="two">
	                <span>
	                    	价格：<span>￥${list.price}</span>
	                </span>
	            </p>
	            <p class="three">
	                <span>
	               	 		出版社：<span>${list.press}</span>
	                </span>
	            </p>
        	</div>
		</c:forEach>
	</div>
<p style="text-align: center;">
		<span>当前第${pageBean.pageCode}页/共${pageBean.totalPage}页</span>
		<a href="search.do?page=1&title=${title}">首页</a>
		<c:if test="${pageBean.pageCode>1}">
			<a href="search.do?page=${pageBean.pageCode-1}&title=${title}">上一页</a>
		</c:if>
		<c:choose>
			<c:when test="${pageBean.totalPage<=5}">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="${pageBean.totalPage}"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${pageBean.pageCode-2}"></c:set>
				<c:set var="end" value="${pageBean.pageCode+2}"></c:set>
				<c:if test="${begin<=0}">
					<c:set var="begin" value="1"></c:set>
					<c:set var="end" value="5"></c:set>
				</c:if>
				<c:if test="${end>pageBean.totalPage}">
					<c:set var="begin" value="${pageBean.totalPage-4}"></c:set>
					<c:set var="end" value="${pageBean.totalPage}"></c:set>
				</c:if>
			</c:otherwise>
		</c:choose>
		<c:forEach begin="${begin}" end="${end}" var="i">
			<a href="search.do?page=${i}&title=${title}">${i}</a>
		</c:forEach>
		<c:if test="${pageBean.pageCode<pageBean.totalPage}">
			<a href="search.do?page=${pageBean.pageCode+1}&title=${title}">下一页</a>
		</c:if>
		<a href="search.do?page=${pageBean.totalPage}&title=${title}">尾页</a>
		<input id="page" type="text" size="1">
		<span hidden="true">${pageBean.totalPage}</span>
		<input type="button" value="Go" onclick="trun('${title}');">
	</p>
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
            <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
            <!-- 页面底部-备案号 #footer -->
            <div class="record">
                2001-2016 版权所有 京ICP证8000853号-56
            </div>
        </div>
        <div class="foot_left lf" >
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
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<script src="../js/slide.js"></script>
<script>
    $('.ck-slide').ckSlide({
        autoPlay: true,//默认为不自动播放，需要时请以此设置
        dir: 'x',//默认效果淡隐淡出，x为水平移动，y 为垂直滚动
        interval:3000//默认间隔2000毫秒
    });
    function trun(val) {
		var input = document.getElementById("page");
		var total = input.nextElementSibling.innerHTML;
		var spage = input.value;
		var totalPage = parseInt(total);
		var page = parseInt(spage);
		console.log(val);
		if(page!=null&&page!=""){
			if(page<=totalPage&&page>0){
				window.location.href="search.do?page="+page+"&title="+val;
			}else{
				alert("请正确输入页码");
				input.value="";
			}
		}
	}
</script>
</body>
</html>
    