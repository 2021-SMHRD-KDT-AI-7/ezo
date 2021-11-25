<%@page import="Model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>써치까치</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!-- fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <!--  -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

   </head>
   <body>

</head>
<body>
<% 
	memberDTO info = (memberDTO)session.getAttribute("info");
	
%>
      <div class="banner_bg_main">
         <!-- header top section start -->
         <h1 class="title_logo"><a href="Main.jsp">써치까치</a></h1>
         <div class="login_menu">
            <ul class="navbar_icons">
               <li><a href="#">
                  <i class="fa fa-shopping-cart" aria-hidden="true" data-cart="5"></i>
            <% if (info != null){ %>
               <li><a href="wishlist.html">
                  <span class="padding_10">위시리스트</span></a>
               </li>
               <li><a href="#">
               <%} else {%>
               <%} %>
               <% if (info != null){ %>
               <li><span><!-- 안녕하세요. <%=info.getM_id()%>님 --></span>
               <a href="logoutServiceCon.do">
                  <i class="fa fa-user" aria-hidden="true"></i>
                  <span class="padding_10">로그아웃</span></a>
               </li>
               <%} else { %>
               <li><a href="loginFrame.jsp">
                  <i class="fa fa-user" aria-hidden="true"></i>
                  <span class="padding_10">로그인</span></a>
               </li>
               <%} %>
           </ul>
         </div>
         <div class="container">
            <div class="header_section_top">
               <div class="row">
                  <div class="col-sm-12">
                     <div class="custom_menu">
                        <ul>
                           <li><a href="#">가이드</a></li>
                           <li><a href="#">게시판</a></li>
                           <li><a href="#">고객센터</a></li>
                        </ul>

                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- header top section start -->
         <!-- logo section start -->
         <div class="logo_section">
            <div class="container">
               <div class="row">
                  <div class="col-sm-12">
                  <h3 class="title_logo2"><a href="#">Search</a></h3>
                  </div>
               </div>
            </div>
         </div>
         <!-- header section start -->
         <div class="header_section">
            <div class="container">
               <div class="containt_main">
                  <div id="mySidenav" class="sidenav">
                     <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                     <a href="index.html">메인페이지</a>
                     <a href="fashion.html">가이드</a>
                     <a href="electronic.html">게시판</a>
                     <a href="jewellery.html">고객센터</a>
                  </div>
                  <span class="toggle_icon" onclick="openNav()"><img src="images/toggle-icon.png"></span>
                  <div class="dropdown">
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">TV</a>
                        <a class="dropdown-item" href="#">태블릿</a>
                     </div>
                  </div>
                  <div class="main">
                     <!-- Another variation with a button -->
                     <div class="input-group">
                        <input type="text" class="form-control" placeholder="상품 검색 (정확한 상품명을 입력해주시면 정확도가 향상됩니다!)">
                        <div class="input-group-append">
                           <button class="btn btn-secondary" type="button" style="background-color: #f26522; border-color:#f26522 ">
                           <i class="fa fa-search"></i>
                           </button>
                        </div>
                     </div>
                  </div>
                  <div class="header_box">
                     <div class="lang_box ">
                        <div class="dropdown-menu ">
                        </div>
                     </div>

                  </div>
               </div>
            </div>
         </div>
         <!-- header section end -->
         <!-- banner section start -->
                     <div>
                        <iframe class="frame_login" src="" frameborder="no" allowtransparency="false" scrolling="no" ></iframe>
                     </div>
                  </div>
         <!-- banner section end -->

      <div class="footer_section layout_padding1">
         <div class="container">
            <div class="footer_logo"><a href="index.html"><img src="images/KakaoTalk_20211115_142051842.png"></a></div>
            <div class="input_bt">
               <input type="text" class="mail_bt" placeholder="Your Email" name="Your Email">
               <span class="subscribe_bt" id="basic-addon2"><a href="#">Subscribe</a></span>
            </div>
            <div class="footer_menu">
               <ul>
                  <li><a href="#">이메일을 인증하고 푸쉬알림과 다양한 혜택을 받으세요!</a></li>
               </ul>
            </div>
         </div>
      </div>
      <!-- footer section end -->
      <!-- copyright section start -->
      <!-- copyright section end -->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <script src="js/join.js"></script>
      <script>
         function openNav() {
           document.getElementById("mySidenav").style.width = "250px";
         }
         
         function closeNav() {
           document.getElementById("mySidenav").style.width = "0";
         }
      </script>
 
   </body>
</html>