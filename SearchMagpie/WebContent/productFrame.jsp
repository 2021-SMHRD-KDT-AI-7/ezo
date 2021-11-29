<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.productDTO"%>
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
<title>비교페이지</title>
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
<link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--  -->
<!-- owl stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Great+Vibes|Poppins:400,700&display=swap&subset=latin-ext" rel="stylesheet">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
<style type="text/css">

</style>
</head>

<body>
<%
	DecimalFormat formatter = new DecimalFormat("###,###,###");
	String data_name_one="",data_name_two="";
	String data_url_one="",data_url_two="";
	String data_img_one="",data_img_two="";
	String price_one="",price_two="";
	ArrayList<productDTO> temp = new ArrayList<productDTO>();
	temp =(ArrayList<productDTO>)session.getAttribute("products");
	if(temp.size() < 2){

		data_name_one = temp.get(0).getP_title();
		data_name_two = "해당물품이 존재하지 않습니다.";
		//가격 0
		price_one = formatter.format(temp.get(0).getP_price());
		price_two = "";
		//제품이 없습니다.
		data_url_one = temp.get(0).getP_url();
		data_url_two="";
		//이미지 준비중
		data_img_one = temp.get(0).getP_file1();
		data_img_two="./images/image_none.jpg";
	}
	else{
		//가격이 더 쌀때 원래 왼쪽 이 더 비싸고, 오른쪽 더 싸.
		if(temp.get(0).getP_price()<temp.get(1).getP_price()){
			data_name_one = temp.get(1).getP_title();
			data_name_two = temp.get(0).getP_title();
			//가격
			price_one = formatter.format(temp.get(1).getP_price());
			price_two = formatter.format(temp.get(0).getP_price());
			//이미지
			data_img_one = temp.get(0).getP_file1();
			data_img_two = temp.get(0).getP_file1();
			//URL
			data_url_one = temp.get(1).getP_url();
			data_url_two = temp.get(0).getP_url();
		}
		else{
			data_name_one = temp.get(0).getP_title();
			data_name_two = temp.get(1).getP_title();
			//가격
			price_one = formatter.format(temp.get(0).getP_price());
			price_two = formatter.format(temp.get(1).getP_price());
			//이미지
			data_img_one = temp.get(0).getP_file1();
			data_img_two = temp.get(0).getP_file1();
			//URL
			data_url_one = temp.get(0).getP_url();
			data_url_two = temp.get(1).getP_url();
		}

	}
	
	
%>
	<!-- electronic section start -->
	<div class="fashion_section">
		<div id="electronic_main_slider" class="carousel slide"
			data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<div class="container">
						<h1 class="fashion_taital">상세 비교</h1>
						<h3 class="h3_comment">
							국/해외 판매처의 가격을 비교하여 <br> 가장 저렴한 두 값만 보여드립니다!
						</h3>
						<!-- <div class="fashion_section_2"> -->
						<div class="box_main1">							
								<div>
									<img src="<%=data_img_one%>">
									<h4 class="shirt_text"><%=data_name_one%></h4>
									<p class="price_text">
										가격 <span style="color: #262626;"><%=price_one%>원</span>
									</p>
									<div class="seemore_bt">
									<a href="<%=data_url_one%>">직접 보러 가기</a>
									</div>
									<a href="#" class="aWish">
									<i class="fa fa-heart" aria-hidden="true" style="font-size:16px;">
									</i> 찜 목록 추가
									</a>
									</div>
								</div>
								
								
								
								<div class="graph">
								<!-- 가격 변동 그래프 들어올 자리 -->
								<iframe src="ViewChangedPriceServiceCon.do"></iframe>
								</div>
								
								
								
								<!-- 반대쪽 -->
								<div class="box_main2 test">
									<img src="<%=data_img_two%>">

									<h4 class="shirt_text"><%=data_name_two%></h4>
									<p class="price_text">
										가격 <span style="color: #262626;"><%=price_two%>원</span>
									</p>
																	
									<div class="seemore_bt">
									<a href="<%=data_url_two%>">직접 보러 가기</a>
									</div>
									<a href="#" class="aWish"><i class="fa fa-heart"
										aria-hidden="true" style="font-size:16px;"></i> 찜 목록 추가</a>
								</div>
						</div>
					</div>
				</div>
			</div>
		</div>