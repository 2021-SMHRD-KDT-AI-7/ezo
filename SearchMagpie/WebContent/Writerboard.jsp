<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
	<link rel="stylesheet" href="searchstyle.css">
</head>
<body>
		<div class="board_list_wrap">
			<table class="board_list">
				<caption>�Խ��� ���</caption>
				<thead>
					<tr>
						<th>�� ��ȣ</th>
						<th><img src="">�̹���</th>
						<th>����</th>
						<th>�ۼ���</th>
						<th>��¥</th>
						<th>��ȸ��</th>
				</thead>
				<tbody>
	<%-- <%for(a = 0; a < �Խ��Ǹ���Ʈ.size(); a++){ %> --%>
					<tr>
						<td class="num">1</td> <%-- <%= ����Ʈ.get(a).get�Խ��ǹ�ȣ %> --%>
						<td class="img"><a href="#"> <%-- <%= ����Ʈ.get(a).get�̹���src %> --%>
							<img src="https://m.media-amazon.com/images/I/81aqPGETDDL._AC_SX522_.jpg"></a></td>
						<td class="tit"><a href="#">������ Ư��</a></td> <%-- <%= ����Ʈ.get(a).get��ǰ�� %> --%>
						<td class="writer">������</td> <%-- <%= ����Ʈ.get(a).get�ۼ��� %> --%>
						<td class="date">2021/11/23</td> <%-- <%= ����Ʈ.get(a).get�Խó�¥ %> --%>
						<td class="view">123</td> <%-- <%= ����Ʈ.get(a).get��ȸ�� %> --%>
					</tr>
					<%-- <%} %> --%>
					<tr>
						<td class="num">1</td>
						<td class="img"><a href="#">���� �̹���</a></td>
						<td class="tit"><a href="#">������ Ư��</a></td>
						<td class="writer">������</td>
						<td class="date">2021/11/23</td>
						<td class="view">123</td>
					</tr>
				</tbody>
			</table>
			<div class="pages">
				<a href="#">ù ������</a>
				<a href="#">���� ������</a>
				<a href="#">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">6</a>
				<a href="#">7</a>
				<a href="#">8</a>
				<a href="#">9</a>
				<a href="#">10</a>
				<a href="#">���� ������</a>
				<a href="#">������ ������</a>
			</div>
		</div>


</body>
</html>