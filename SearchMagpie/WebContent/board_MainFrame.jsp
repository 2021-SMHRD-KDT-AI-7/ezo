<%@page import="Model.writeboardDTO"%>
<%@page import="Model.memberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.writeboardDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <!-- css -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<%
	ArrayList<writeboardDTO> list = new ArrayList<writeboardDTO>();
	writeboardDAO dao = new writeboardDAO();
	list = dao.allViewWriteboard();
	memberDTO info = (memberDTO)session.getAttribute("info");
%>
<div class="container">

    <br>

    <h2 class="text-center"><a href="#">게시판</a></h2>

    <br>
    <br>

    <table class="table table-striped table-hover" id="paging" style="border: 1px solid;">
        <thead class="thead">
            <tr>
                <th class="head-title"></th>
                <th class="title">제목</th>
                <th class="writer">작성자</th>
                <th class="views">조회수</th>
                <th class="write-date">작성일</th>
            </tr>
        </thead>
        <tbody>
            <!-- 1번째 게시글 -->
            <!-- 인설트 테이블 구조(boardTable (시퀀스,게시판번호,작성자)) -->
            <%for (int i = 0;  i < list.size(); i++) { %>
            <tr>
                <td>[일반게시판]</td>
                <td><a href=""><%=list.get(i).getW_title()%></a></td>
                <td><%=list.get(i).getW_writer()%></td>
                <td><%=list.get(i).getW_cnt()%></td>
                <td><%=list.get(i).getReg_date()%></td>
              	<td><a href="deleteWriteboardServiceCon.do?w_key=<%=list.get(i).getW_key()%>">삭제</a></td>
            </tr>
            <%
}
%>
        </tbody>
    </table>

    <div>
        
        <ul class="pagination justify-content-center">
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">◀</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">1</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">2</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">3</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">4</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">5</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">▶</a></li>
        </ul>
        <a href="writeAction.jsp" class="btn btn-outline-info float-right btn- color">글쓰기</a>

    </div>

<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</div>
</body>

</html>