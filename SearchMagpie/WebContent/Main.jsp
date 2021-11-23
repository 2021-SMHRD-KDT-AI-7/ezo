<%@page import="Model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="EUC-KR"> --><!-- basic -->
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
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Scrollbar Custom CSS -->
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
      <!-- owl stylesheets -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
</head>
<body>
<% 
	memberDTO info = (memberDTO)session.getAttribute("info");
%>
<!-- banner bg main start -->
      <div class="banner_bg_main">
         <!-- header top section start -->
         <h1 class="title_logo"><a href="Main.jsp">써치까치</a></h1>
         <div class="login_menu">
            <ul class="navbar_icons">
            <% if (info != null){ %>
               <li><a href="wishlist.html">
                  <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                  <span class="padding_10">위시리스트</span></a>
               </li>
               <%} else {%>
               <%} %>
               <% if (info != null){ %>
               <li><a href="logoutServiceCon.do">
                  <i class="fa fa-user" aria-hidden="true"></i>
                  <span class="padding_10">로그아웃</span></a>
               </li>
               <%} else { %>
               <li><a href="login.jsp">
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
                           <li><a href="#">메인페이지</a></li>
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
                     <div class="logo"><a href="index.html"><img src="images/logo.png"></a></div>
                  </div>
               </div>
            </div>
         </div>
         <!-- logo section end -->
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
                     <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">상품 카테고리 
                     </button>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">TV</a>
                        <a class="dropdown-item" href="#">Xbox</a>
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
         <div class="banner_section layout_padding">
            <div class="container">
               <div id="my_slider" class="carousel slide" data-ride="carousel">
                  <div class="carousel-inner">
                     <div class="carousel-item active">
                        <div class="row">
                           <div class="col-sm-12">
                              <!-- <h1 class="banner_taital"></h1> -->
                              <!-- <div class="buynow_bt"><a href="#">Buy Now</a></div> -->
                           </div>
                        </div>
                     </div>
                     <div>
                        <iframe class="frame" src="search.jsp" frameborder="0"></iframe>
                        <!-- <center>

                           <hr width = 340 size=2 color="blue">
                           <h2>회원 가입</h2>
                           <hr width = 340 size=2 color="blue">
                           <form action="JoinOK" method="post" >
                                <table class="ex1">
                                    <tr>
                                        <td class="date1"><input type="text" name="id" placeholder="아이디"></td>
                                        <td class="date1"><input type="submit" name="id_check" value="중복 확인"></td>
                                    </tr>
                                    <tr>
                                        <td class="date1"><input type="text" name="pw" placeholder="비밀번호"></td>
                                    </tr>
                                 <tr>
                                    <td class="date1"><input type="text" name="pw_check" placeholder="비밀번호 확인"></td>
                                 </tr>
                                 <tr>
                                    <td class="date1"><input type="text" name="name" placeholder="이름"></td>
                                 </tr>
                                 <tr>
                                    <td class="date1"><input type="text" name="nickname" placeholder="닉네임"></td>
                                    <td class="date1"><input type="submit" name="nickname_check" value="중복 확인"></td>
                                 </tr>
                                 <tr>
                                    <td class="date1"><input type="text" name="email" placeholder="이메일"></td>
                                    <td class="date1"><input type="submit" name="email_check" value="인증 메일"></td>
                                 </tr>
                                 <tr>
                                    <td class="date1"><input type="text" name="phone" placeholder="연락처"></td>
                                 </tr>
                                 <tr>
                                    <td class="date1"><input type="submit" name="back" value="뒤로"></td>
                                    <td class="date1"><input type="submit" name="JoinOK" value="가입"></td>
                                 </tr>
                                </table>
                           </form>
                           
                           </center> -->
                     </div>
                     <!-- <div class="carousel-item">
                        <div class="row">
                           <div class="col-sm-12">
                              <h1 class="banner_taital">Get Start <br>Your favriot shoping</h1>
                              <div class="buynow_bt"><a href="#">Buy Now</a></div>
                           </div>
                        </div>
                     </div> -->
                     <!-- <div class="carousel-item">
                        <div class="row">
                           <div class="col-sm-12">
                              <h1 class="banner_taital">Get Start <br>Your favriot shoping</h1>
                              <div class="buynow_bt"><a href="#">Buy Now</a></div>
                           </div>
                        </div>
                     </div> 
                  </div> -->

                  <!-- <a class="carousel-control-prev" href="#my_slider" role="button" data-slide="prev">
                  <i class="fa fa-angle-left"></i>
                  </a>
                  <a class="carousel-control-next" href="#my_slider" role="button" data-slide="next">
                  <i class="fa fa-angle-right"></i>
                  </a> -->
               </div>
            </div>
         </div>
         <!-- banner section end -->
      </div>

      <div class="footer_section layout_padding1">
         <div class="container">
            <div class="footer_logo"><a href="Main.jsp"><img src="images/KakaoTalk_20211115_142051842.png"></a></div>
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
      </div>
      <!-- copyright section end -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
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