<%@page import="Model.SearchProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품결과값</title>
<%
	ArrayList<SearchProductDTO> dto_list = (ArrayList<SearchProductDTO>) session.getAttribute("findKeywordList");
%>
</head>
<body>
	<table border="">
		<tr>
			<th>상품명</th>
			<th>가격</th>
			<th>출처</th>
			<th>링크</th>
			<th>이미지</th>
		</tr>

		<%
			for (SearchProductDTO dto : dto_list) {
		%>
		<tr>
			<td><%=dto.getProduct_title()%></td>
			<td><%=dto.getProduct_price()%></td>
			<td><%=dto.getProduct_source()%></td>
			<td><a href="<%=dto.getProduct_url()%>" target='_blank'><button>링크</button></a></td>
			<td><img src="<%=dto.getProduct_img()%>"></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>