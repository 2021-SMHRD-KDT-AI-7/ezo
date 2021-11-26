<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
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
            <tr>
                <td>[공지]</td>
                <td><a href="#">써치까치 사이트 이용 공지사항</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 2번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">써치까치입니다.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 3번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">메인페이지 어케하지</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 4번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">사이트 폐쇄합니다.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 5번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">써치까치입니다.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 6번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">저희 망했어요.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 7번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">써치까치입니다.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 8번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">정식이형 파이팅.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 9번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">집에가고싶다.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 10번째 게시글 -->
            <tr>
                <td>[공지]</td>
                <td><a href="#">살려주세요.</a></td>
                <td>운영자</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
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