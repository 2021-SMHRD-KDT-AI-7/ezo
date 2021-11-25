<%@page import="Model.SearchProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ�����</title>
<%
	ArrayList<SearchProductDTO> dto_list = (ArrayList<SearchProductDTO>) session.getAttribute("findKeywordList");
%>
</head>
<body>
	<table border="">
		<tr>
			<th>��ǰ��</th>
			<th>����</th>
			<th>��ó</th>
			<th>��ũ</th>
			<th>�̹���</th>
		</tr>

		<%
			for (SearchProductDTO dto : dto_list) {
		%>
		<tr>
			<td><%=dto.getProduct_title()%></td>
			<td><%=dto.getProduct_price()%></td>
			<td><%=dto.getProduct_source()%></td>
			<td><a href="<%=dto.getProduct_url()%>" target='_blank'><button>��ũ</button></a></td>
			<td><img src="<%=dto.getProduct_img()%>"></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>