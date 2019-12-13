<%@ page import="com.tarena.entity.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>达内商城学子详情页</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/pro.details.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <script type="text/javascript" src="../js/search.js">
    </script>
</head>
<body>
<!-- 页面顶部-->
<header id="top">
    <div id="logo" class="lf">
        <img class="animated jello" src="../img/header/logo.png" alt="logo"/>
    </div>
    <div id="top_input" class="lf">
        <input id="input" type="text" placeholder="请输入您要搜索的内容"/>

        <a href="" class="rt"><img id="search" src="../img/header/search.png" alt="搜索"/></a>
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
<!-- 内容-->
<!--细节导航-->
<div id="nav_detail">
    <h5>${book.title}></h5>
</div>
<!--产品预览-->
<div id="shop_detail">
    <!-- 左侧-->
    <div id="preview" class="lf">
        <div id="mediumDiv">
            <img id="mImg" src="../img/goods/${book.isbn}/detail1big.jpg"/>
        </div>
        <div id="icon_all">
            <ul id="icon_list">
                <li class="i1"><img src="../img/goods/${book.isbn}/detail1.jpg"/></li>
                <li class="i1"><img src="../img/goods/9787115435101/detail2.jpg" onerror="this.style.display='none'"/>
                </li>
                <li class="i1"><img src="../img/goods/9787115435101/detail3.jpg" onerror="this.style.display='none'"/>
                </li>
                <li class="i1"><img src="../img/goods/9787115435101/detail4.jpg" onerror="this.style.display='none'"/>
                </li>
                <li class="li"><img src="../img/goods/9787115435101/detail5.jpg" onerror="this.style.display='none'"/>
                </li>
            </ul>
        </div>
    </div>
    <!-- 右侧-->
    <div class="right_detail lf">
        <!-- 图书名称-->
        <h1>${book.title}</h1>
        <!-- 图书作者 -->
        <h3>${book.author}</h3>
        <!-- 价格部分-->
        <div class="price">
            <div id="pro_price"><b>价格：</b><span>￥${book.price}</span></div>
            <div class="promise">
                <b>服务承诺：</b>
                <span>*退货补运费</span>
                <span>*30天无忧退货</span>
                <span>*48小时快速退款</span>
                <span>*72小时发货</span>
            </div>
        </div>
        <!-- 参数部分 客服-->
        <p class="parameter">
            <b>客服：</b>
            <span class="connect">联系客服</span><img class="gif" src="../img/product_detail/kefuf.gif">
        </p>
        <!-- 出版社 -->
        <p class="style" id="choose_color">
            <s class="color">出版社：</s>
            <span>${book.press}</span>
        </p>
        <!-- 出版日期 -->
        <p>
            <s>出版日期：</s>
            <span>${book.published }</span>
        </p>
        <!-- 未选择规格，颜色时状态-->
        <div class="message"></div>
        <!-- 数量-->
        <p class="accountChose">
            <s>数量：</s>
            <button class="numberMinus">-</button>
            <input type="text" value="1" class="number" id="buy-num">
            <button class="numberAdd">+</button>
        </p>
        <!-- 购买部分-->
        <div class="shops">
            <a href="#" onclick="buyNow();" class="buy lf" id="buy_now">立即购买</a>
            <a href="#" onclick="addCart();" class="shop lf" id="add_cart"><img
                    src="../img/product_detail/product_detail_img7.png" alt=""/>加入购物车</a>
            <a href="#" onclick="collect();" class="collection lf" id="collect">
                <span>收藏</span></a><b>
            <img id="image" src="../img/product_detail/product_detail_img6${mess==true?'2':'' }.png" alt=""/>
        </b>
        </div>
    </div>
</div>
<!--为你推荐-->
<div id="recommended">
    <p>为你推荐<span>大家都在看</span></p>
    <div id="demo" style="width:1000px;overflow:hidden;">
        <div id="indemo" style="float: left;width: 200%;">
            <div id="demo1" style="float:left"><!-- 第一个宽度显示 -->
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <a href="detail.html?isbn=9787302435167"><img src="../img/recommend/recommend_img1.jpg"
                                                                      border="0"></a>
                    </div>
                    <p>大数据架构师指南</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <a href="detail.html?isbn=9787115335500"><img src="../img/recommend/recommend_img2.jpg"
                                                                      border="0"></a>
                    </div>
                    <p>深入浅出Node.js</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <a href="detail.html?isbn=9787111213826"><img src="../img/recommend/recommend_img3.jpg"
                                                                      border="0"></a>
                    </div>
                    <p>Java编程思想</p>
                </div>
                <div class="detail_1 lf">
                    <div class="detail_img1">
                        <a href="detail.html?isbn=9787111545682"><img src="../img/recommend/recommend_img4.jpg"
                                                                      border="0"></a>
                    </div>
                    <p>Linux运维最佳实践</p>
                </div>
                <!--</div>-->
            </div>
            <div id="demo2" style="float:left">
            </div>
        </div>
        <!-- 宽度超大 -->
    </div>
    <!-- 外面大框 -->
</div>
<!--商品详情-->
<div id="iteminfo">
    <div id="tab">
        <div class="tab lf">
            <div class="cat">
                <span class="active"><a href="">商品详情</a></span>
                <span><a href="lookforward.html">商品评价</a></span>
            </div>
        </div>
        <div class="cart rt">
            <img src="../img/product_detail/product_detail_img9.png" alt=""/>
        </div>
    </div>
    <div class="left lf">
        <div class="all">
            <!--<p><img src="img_x/pin_logo.png" alt=""/></p>-->
            <div id="parm">
                <div id="specification_parameter">
                    <p>
                        规格参数
                        <img src="../img/product_detail/product_detail_icon_1.png" alt="" class="ys5"/>
                    </p>
                    <!--<img src="img_x/canshu.png" alt="" class="ys5"/>-->
                </div>
                <ul>
                    <li><a href="#">图书编号：${book.isbn}</a></li>
                    <li>
                        <a href="#">图书名称：${book.title}
                        </a>
                    </li>
                    <li>
                        <a href="#">作者：${book.author}</a>
                    </li>
                    <li><a href="#">价格：￥${book.price}</a></li>
                    <li><a href="#">出版社：${book.press}</a></li>
                    <li><a href="#">版次：${book.edition}</a></li>
                    <li><a href="#">出版日期：${book.published }</a></li>
                    <li><a href="#">页数：${book.pages}</a></li>
                    <li>
                        <a href="#">字数：${book.words}
                        </a>
                    </li>
                    <li><a href="#">包装：${book.packaging}</a></li>
                    <li><a href="#">开本：${book.format}</a></li>
                    <li><a href="#">用纸：${book.form}</a></li>
                </ul>
            </div>
            <div id="product_introduction">
                <p>
                    商品介绍
                    <img src="../img/product_detail/product_detail_icon_4.png" alt="" class="ys5"/>
                </p>
                <img src="../img/goods/${book.isbn}/intro.jpg" alt=""/>
            </div>
            <div id="sale_protection">
                <p>
                    售后保障
                    <img src="../img/product_detail/product_detail_icon_3.png" alt="" class="ys5"/>
                </p>

                <div class="sale_content">
                    <p class="paper" id="sale_protect">
                        <img src="../img/product_detail/product_detail_img16.png" alt=""/>
                        正品保障
                    </p>

                    <p class="content">
                        达内学子商城向您保证所售商品均为正品行货，达内自营商品开具机打发票或电子发票。
                    </p>

                    <p class="paper">
                        <img src="../img/product_detail/product_detail_img16.png" alt=""/>
                        全国联保
                    </p>

                    <p class="content">
                        凭质保证书及达内商城发票，可享受全国联保服务，与您亲临商场选购的商品享受相同的质量保证。达内商城还为您提供具有竞争力的商品价格和运费政策，请您放心购买！
                        注：因厂家会在没有任何提前通知的情况下更改产品包装、产地或者一些附件，本司不能确保客户收到的货物与商城图片、产地、附件说明完全一致。只能确保为原厂正货！并且保证与当时市场上同样主流新品一致。若本商城没有及时更新，请大家谅解！
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div class="right rt">
        <div class="aside_nav">
            <p><i><img src="../img/product_detail/product_detail_icon_g_1.png" alt=""/></i><a
                    href="#specification_parameter">规格参数</a></p>
            <p><i><img src="../img/product_detail/product_detail_icon_t_1.png" alt=""/></i><a
                    href="#product_introduction">商品介绍</a></p>
            <p><i><img src="../img/product_detail/product_detail_icon_d_1.png" alt=""/></i><a href="#sale_protection">售后保障</a>
            </p>
            <p><i><img src="../img/product_detail/product_detail_icon_up_1.png" alt=""/></i><a href="#">回到顶部</a></p>
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
    <span id="mess" hidden="true">${mess}</span>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script src="../js/index.js"></script>
<!--图片轮播悬停进入详情页效果-->
<script>
    var speed = 20;
    var tab = document.getElementById("demo");
    var tab1 = document.getElementById("demo1");
    var tab2 = document.getElementById("demo2");
    tab2.innerHTML = tab1.innerHTML;

    function Marquee() {
        if (tab2.offsetWidth - tab.scrollLeft <= 0)
            tab.scrollLeft -= tab1.offsetWidth
        else {
            tab.scrollLeft++;
        }
    }

    var MyMar = setInterval(Marquee, speed);
    tab.onmouseover = function () {
        clearInterval(MyMar)
    };
    tab.onmouseout = function () {
        MyMar = setInterval(Marquee, speed)
    };
</script>
<!--添加到购物车 立即购买 收藏部分-->
<script>
    $(function () {
        var nav = $("#tab"); //得到导航对象
        var aside = $(".aside_nav");//右侧导航
        var win = $(window); //得到窗口对象
        var sc = $(document);//得到document文档对象。
        win.scroll(function () {
            if (sc.scrollTop() >= 1000) {
                nav.addClass("fixed_tab");
                aside.addClass("fixed_aside");
            } else {
                nav.removeClass("fixed_tab");
                aside.removeClass("fixed_aside");
            }
        })

        win.scroll(function () {
            if (sc.scrollTop() >= 60 && sc.scrollTop() < 1000) {
                $("#top").addClass("fixed_nav");
            } else {
                $("#top").removeClass("fixed_nav");
            }
        })
        //介绍区域右侧导航
        $("#iteminfo .right p").click(function () {
            //$(this).addClass("clic").siblings().removeClass("clic");
            $(this).css("background-color", "#0AA1ED").siblings().css("background-color", "#e8e8e8");
            $(this).find("a").css("color", "#fff").parent().siblings().find("a").css("color", "#828282")
        })
        /**数量添加**/
        var n = $("#buy-num").val() * 1;
        $(".numberMinus").click(function () {
            if (n >= 1) {
                $("#buy-num").val(n -= 1);
            }
        })
        $(".numberAdd").click(function () {
            $("#buy-num").val(n += 1);
        })
        /**选择商品进行添加 悬停效果**/
        $(".avenge").mouseover(function () {
            $(this).css({"border": "1px solid #0AA1ED", "color": "#0AA1ED"});
        }).mouseout(function () {
            $(this).css({"border": "1px solid #666", "color": "#666"})
        })
    })
</script>
<script>
    function addCart() {
        //1.获取AJAX对象
        var xmlhttp = null;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //获取输入框中的值
        var product = ${book.isbn};
        var user_id = ${user.phone};
        var count = document.getElementById("buy-num").value;

        var url = "product=" + product + "&user_id=" + user_id + "&count=" + count;
        //处理回调函数
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
                var msg = xmlhttp.responseText;
                if (msg == "true") {
                    alert("加入购物车成功");
                } else {
                    alert("系统异常请稍后再试");
                }
            }
        }
        xmlhttp.open("get", "saveCart.do?" + url);
        xmlhttp.send();
    }

    function collect() {
        //1.获取AJAX对象
        var xmlhttp = null;
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else {
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        //获取输入框中的值
        var product = ${book.isbn};
        var user_id = ${user.phone};

        var url = "product=" + product + "&user_id=" + user_id;
        //处理回调函数
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.status == 200 && xmlhttp.readyState == 4) {
                var msg = xmlhttp.responseText;
                var img = document.getElementById("image");
                alert(msg);
                if (msg == "取消收藏成功") {
                    img.src = "../img/product_detail/product_detail_img6.png";
                } else if (msg == "收藏成功") {
                    img.src = "../img/product_detail/product_detail_img62.png";
                }
            }
        }
        xmlhttp.open("get", "collect.do?" + url);
        xmlhttp.send();
    }

    function buyNow() {
        var price =${book.price};
        var product =${book.isbn};
        var count = document.getElementById("buy-num").value;
        var url = "product=" + product + "&price=" + price + "&count=" + count;
        window.location.href = "buyNow.do?" + url;
    }
</script>
<!--图片效果-->
<script>
    $("#mImg").hover(function () {
        $(this).addClass("animated pulse");
    }, function () {
        $(this).removeClass("animated pulse");
    });
</script>
<script>
    $('#icon_list>li').click(function () {
        $(this).children('img').css('border', '1px solid #CECFCE');
        var address = $(this).children().attr('src');
        console.log(address);
        var newaddress = address.slice(0, -4);
        var bigaddress = newaddress + 'big.jpg';
        $('#mImg').attr('src', bigaddress);
        $(this).siblings().children('img').css('border', '');
    })
</script>
</body>
</html>
    