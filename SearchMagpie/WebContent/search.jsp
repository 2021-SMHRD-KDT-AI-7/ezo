<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>
.product-table {
	background-color: red;
}
</style>
<body>
	<ul>
		<%-- <% for(a = 0; a < 검색한 상품리스트.size(); a++){ %> --%>
		<form action="ProductServiceCon.do" method="post">
			<li class="product-frame">
				<div class="thumb">
					<a href="#"> <img src="images/laptop-img.png"> <%-- <%= 리스트.get(a).get이미지src %> --%>
					</a>
				</div>
				<div class="product-text">
					<a href="#" class="item-title">어렵다어려워</a>
					<%-- <%= 리스트.get(a).get상품명 %> --%>
					<div class="item-price">
						<strong>***원</strong>
						<%-- <%= 리스트.get(a).get상품가격 %> --%>
					</div>
					<div>
						<button type="submit">상품 최저가 탐방하기!</button>
					</div>
				</div>
			</li>
		</form>
		<%-- <%} %> --%>
	</ul>


</body>
</html>