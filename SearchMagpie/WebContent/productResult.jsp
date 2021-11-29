<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Model.memberDTO"%>
<%@page import="Model.SearchProductDTO"%>
<%@page import="java.util.ArrayList"%>
<DOCTYPE HTML5>
<html>
<head>
<title>써치까치 상품검색</title>
<link rel="stylesheet" type="text/css" href="./css/wish_list.css">
<!-- fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap"
	rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- jQuery -->
<script src="./js/jquery-3.0.0.min.js"></script>
<!-- Bootstrap -->
<!-- <script src="./js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="./css/bootstrap.min.css"> -->
<%
	ArrayList<SearchProductDTO> dto_list = (ArrayList<SearchProductDTO>)session.getAttribute("findKeywordList");
memberDTO info = (memberDTO)session.getAttribute("info");
%>
</head>

<body>
<a href="Main.jsp">홈 가기</a>
	<div class="small-container cart-page table-responsive">

		<div id="header">
			<h2>상품 검색</h2>
			<h5 class="comment">
				효율적인 가격으로 알려드리겠습니다!!<br>
			</h5>
		</div>
		<script type="text/javascript">
			var price;
		</script>
		<table class="table table-bordered table-hover" id="paging">
			<!-- 테이블 머릿말 -->
			<thead>
				<tr>
					<th>상품정보</th>
					<th style="text-align: center;">좋아요</th>
					<th>상품가격</th>
				</tr>
			</thead>
			<tbody>
				<!-- 1번 상품 -->
				<%
					for (int i = 0; i < dto_list.size(); i++) {
				%>
				<tr>
					<td>
						<div class="cart-info">
							<img src="<%=dto_list.get(i).getProduct_img()%>">

							<div>
								<a href="ProductSerachServiceCon.do?seq=<%=dto_list.get(i).getProduct_seq()%>" target='_blank'>
									<h2><%=dto_list.get(i).getProduct_title()%></h4>
								</a> <small>price:<p id="left_price<%=i%>" style="display: inline;"></p>￦</small> 
								<br><small><%=dto_list.get(i).getProduct_source()%></small>
							</div>
						</div>
					</td>
					<div>
					<td>
	
					<button class="btn_like"><a href="InsertWishServiceCon.do?seq=<%=dto_list.get(i).getProduct_seq()%>&m_key=<%=info.getM_key()
					%>">찜하기</button>
					<%System.out.print("JSP m_key :"+info.getM_key());%>
					</td>
					</div>
					<div class="push_alram">
						<td style="text-align:right;"><p id="right_price<%=i%>" style="display: inline;"></p>￦</td>
					</div>
					<script type="text/javascript">
						console.log(<%=dto_list.get(i).getProduct_seq()%>)
						price =	<%=dto_list.get(i).getProduct_price()%>	;
						var result = price.toLocaleString();
						console.log(result);
						var p_1 = document.getElementById("left_price"+<%=i%>);
						var p_2 = document.getElementById("right_price"+<%=i%>);
						p_1.innerHTML = result.toString();
						p_2.innerHTML = result.toString();
					</script>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>