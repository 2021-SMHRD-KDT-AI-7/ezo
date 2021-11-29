<%@page import="Model.saleinfoDAO"%>
<%@page import="Model.saleinfoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.memberDTO"%>
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
	ArrayList<saleinfoDTO> list = new ArrayList<saleinfoDTO>();
	saleinfoDAO dao = new saleinfoDAO();
	list = dao.saleinfoBoard();
	for (int i = 0;  i < list.size(); i++) { 
	System.out.println(list.get(i).getImg());}
%>
<h3><a href="Main.jsp">메인으로</a></h3>

<div class="container">

    <br>

    <h2 class="text-center"><a href="#">직구 할인정보</a></h2>

    <br>
    <br>

    <table class="table table-striped table-hover" id="paging" style="border: 1px solid;">
        <thead class="thead">
            <tr>
                <th class="image">게시글 썸네일</th>
                <th class="title">제목</th>
            </tr>
        </thead>
        <tbody>
            <!-- 1번째 게시글 -->
            <!-- 인설트 테이블 구조(boardTable (시퀀스,게시판번호,작성자)) -->
            <%for (int i = 0;  i < list.size(); i++) { %>
            <tr>
                <td><a href="<%=list.get(i).getUrl()%>>">
                <img src="images/crawling_img/<%=i+1%>.jpg">
                </a></td>
                <td><a href="<%=list.get(i).getUrl()%>>">
                <%=list.get(i).getTitle()%></a></td>
            </tr>
            <%}%>
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