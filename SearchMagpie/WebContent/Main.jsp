<%@page import="Model.memberDTO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<%
   request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
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
      <!-- bootstrap css -->
      <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" type="text/css" href="css/style.css">
      <link rel="stylesheet" type="text/css" href="css/search.css">
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
      <link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">
      <!-- owl stylesheets -->
      <link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
      <link rel="stylesheet" href="css/owl.carousel.min.css">
      <link rel="stylesoeet" href="css/owl.theme.default.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
      <!-- style -->

<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript">
   function sendKeyword() {

      var userKeyword = document.myForm.userKeyword.value;
      if (userKeyword == "") {
         hide();//검색창이 비워져있으면 숨김
         return;
      }
      var params = "userKeyword=" + userKeyword;
      sendRequest("searchClient_ok.jsp", params, displaySuggest, "POST");
   }m, 

   function displaySuggest() {
      if (httpRequest.readyState == 4) {
         if (httpRequest.status == 200) {//서버응답 정상처리인 경우
            var resultText = httpRequest.responseText;//resposne로 넘어온 텍스트 할당
            //alert(resultText);
            //5|abc,ajax,abc마트
            console.log(">>>>>>>이거다" + resultText);
            var resultArray = resultText.split("|"); //{5, {abc,ajax,abc} } 로 나눔
            var count = parseInt(resultArray[0]);//5
            var keywordList = null;
            if (count > 0) {
               keywordList = resultArray[1].split(",");
               var html = "";
               for (var i = 0; i < 5; i++) {
                  html += "<br/><a href=\"javascript:select('"
                        + keywordList[i] + "');\">" + keywordList[i]
                        + "</a><br/>";
                  //<a href="javascript:select('ajax');">ajax</a><br/>
               }
               var suggestListDiv = document.getElementById("suggestListDiv");
               suggestListDiv.innerHTML = html;
               show();
            } else {
               //count==0
               hide();
            }
         } else {
            //status!=200
            hide();
         }
      } else {
         //readyState!=4
         hide();
      }
   }//function..end

   var allArea_find;
   //사용자가 제시어중에서 클릭한 키워드
   function select(selectKeyword) {
      //클릭한 제시어를 inputbox에 넣어줌
      document.myForm.userKeyword.value = selectKeyword;
      allArea_find = selectKeyword
      hide();//다른 제시어 감춤
   }
   function show() {
      var suggestDiv = document.getElementById("suggestDiv");
      suggestDiv.style.display = "block";
   }
   function hide() {
      var suggestDiv = document.getElementById("suggestDiv");
      suggestDiv.style.display = "none";
   }

   //처음 DOM이 로드되었을때 보이지 않도록
   window.onload = function() {
      hide();
   }
</script>
      
</head>
<% 
   memberDTO info = (memberDTO)session.getAttribute("info");
   System.out.println(info);
   session = request.getSession();
   session.setAttribute("run_check", 0);
   if (session != null) {
      System.out.println("is not null");
   }
   String findData = null;
%>
   <body>
      <div class="banner_bg_main">
         <h1 class="title_logo"><a href="#">써치까치</a></h1>
         <div class="container">
            <div class="header_section_top">
               <div class="row">
                  <div class="col-sm-12">
                     <div class="custom_menu">
                        <ul>
                     <%if (info != null) { %>
                     
                        <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i>가이드</a></li>
                          <li><a href="#"><i class="fa fa-file-signature" aria-hidden="true"></i>게시판</a></li>
                        <li><a href="#"><i class="fa fa-bell" aria-hidden="true"></i>고객센터</a></li>
                        <li><a href="wish_list2Frame.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i>찜 목록</a></li>
                        <li><a href="#"><i class="fa fa-user" aria-hidden="true"></i>로그아웃</a></li>
                        
                              <%} else { %>
                              
                        <li><a href="#"><i class="fa fa-book" aria-hidden="true"></i>가이드</a></li>
                        <li><a href="#"><i class="fa fa-file-signature" aria-hidden="true"></i>게시판</a></li>
                        <li><a href="loginFrame.jsp"><i class="fa fa-user" aria-hidden="true"></i>로그인</a></li>
                        <li><a href="#"><i class="fa fa-bell" aria-hidden="true"></i>회원가입</a></li>
                              <%} %>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="header_section">
                     <div id="suggestDiv" class="frame_search">
                     <div id="suggestListDiv"></div></div>
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
                     <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">상품 카테고리 </button>
                     <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">TV</a>
                        <a class="dropdown-item" href="#">Xbox</a>
                        <a class="dropdown-item" href="#">태블릿</a>
                     </div>
                  </div>
                  <div class="main">
                     <!-- Another variation with a button -->
                     <form action="SearchServiceCon" name="myForm" method="post">
                     <div class="input-group">
                        <input type="text" name="userKeyword" class="form-control" placeholder="상품 검색 (정확한 상품명을 입력할수록 검색 정확도가 향상됩니다!)" onkeyup="sendKeyword();" />
                        <div class="input-group-append">
                           <button class="btn_search" type="submit">
                           <i class="fa fa-search"></i>검색
                           </button>
                     </div>
               </div>
                  </form>
                 </div>
                  <div class="header_box">
                     <div class="lang_box ">
                        <div class="dropdown-menu "></div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <!-- header section end -->
         <!-- banner section start -->
            <div class="container">
               <div id="my_slider" class="carousel slide" data-ride="carousel">
                  <div class="carousel-inner">
                     <div id="header">
                        <!-- iframe 들어오는 자리 -->
                        <!-- <iframe class="frame_join" src="joinFrame.html" frameborder="no" allowtransparency="false" scrolling="no"></iframe> -->
                        <!-- iframe 들어오는 자리 -->
                     </div>
                  </div>
               </div>
            </div>
         <!-- banner section end -->
      </div>
      
      <div class="blank_img">
      
      </div>
      
      <div class="blank"> <!-- style.css 에서 .blank 찾고 height(높낮이)속성으로 조절 -->
      <h3>가이드</h3>
      <h3>가이드</h3>
      <h3>가이드</h3>
      </div>
      <div class="footer_section layout_padding1">
         <div class="container">
            <!-- <div class="footer_logo"><a href="index.html"><img src="images/KakaoTalk_20211115_142051842.png"></a></div> -->
            <div class="input_bt">
               <input type="text" class="mail_bt" placeholder="이메일을 입력하세요" name="Your Email">
               <span class="subscribe_bt" id="basic-addon2"><a href="#">인증메일 보내기</a></span>
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
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/popper.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <script src="js/jquery-3.0.0.min.js"></script>
      <script src="js/plugin.js"></script>
      <!-- sidebar -->
      <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
      <script src="js/custom.js"></script>
      <script src="https://kit.fontawesome.com/949677030e.js" crossorigin="anonymous"></script>
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