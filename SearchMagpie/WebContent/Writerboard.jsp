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
				<caption>게시판 목록</caption>
				<thead>
					<tr>
						<th>글 번호</th>
						<th><img src="">이미지</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
				</thead>
				<tbody>
	<%-- <%for(a = 0; a < 게시판리스트.size(); a++){ %> --%>
					<tr>
						<td class="num">1</td> <%-- <%= 리스트.get(a).get게시판번호 %> --%>
						<td class="img"><a href="#"> <%-- <%= 리스트.get(a).get이미지src %> --%>
							<img src="https://m.media-amazon.com/images/I/81aqPGETDDL._AC_SX522_.jpg"></a></td>
						<td class="tit"><a href="#">오늘의 특가</a></td> <%-- <%= 리스트.get(a).get상품명 %> --%>
						<td class="writer">관리자</td> <%-- <%= 리스트.get(a).get작성자 %> --%>
						<td class="date">2021/11/23</td> <%-- <%= 리스트.get(a).get게시날짜 %> --%>
						<td class="view">123</td> <%-- <%= 리스트.get(a).get조회수 %> --%>
					</tr>
					<%-- <%} %> --%>
					<tr>
						<td class="num">1</td>
						<td class="img"><a href="#">샘플 이미지</a></td>
						<td class="tit"><a href="#">오늘의 특가</a></td>
						<td class="writer">관리자</td>
						<td class="date">2021/11/23</td>
						<td class="view">123</td>
					</tr>
				</tbody>
			</table>
			<div class="pages">
				<a href="#">첫 페이지</a>
				<a href="#">이전 페이지</a>
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
				<a href="#">다음 페이지</a>
				<a href="#">마지막 페이지</a>
			</div>
		</div>


</body>
</html>