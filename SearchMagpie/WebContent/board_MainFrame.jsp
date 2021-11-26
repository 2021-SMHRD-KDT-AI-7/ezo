<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>�Խ���</title>
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

    <h2 class="text-center"><a href="#">�Խ���</a></h2>

    <br>
    <br>

    <table class="table table-striped table-hover" id="paging" style="border: 1px solid;">
        <thead class="thead">
            <tr>
                <th class="head-title"></th>
                <th class="title">����</th>
                <th class="writer">�ۼ���</th>
                <th class="views">��ȸ��</th>
                <th class="write-date">�ۼ���</th>
            </tr>
        </thead>
        <tbody>
            <!-- 1��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">��ġ��ġ ����Ʈ �̿� ��������</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 2��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">��ġ��ġ�Դϴ�.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 3��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">���������� ��������</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 4��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">����Ʈ ����մϴ�.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 5��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">��ġ��ġ�Դϴ�.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 6��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">���� ���߾��.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 7��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">��ġ��ġ�Դϴ�.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 8��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">�������� ������.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 9��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">��������ʹ�.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
            <!-- 10��° �Խñ� -->
            <tr>
                <td>[����]</td>
                <td><a href="#">����ּ���.</a></td>
                <td>���</td>
                <td>2</td>
                <td>2021.11.25</td>
            </tr>
        </tbody>
    </table>

    <div>
        
        <ul class="pagination justify-content-center">
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">��</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">1</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">2</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">3</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">4</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">5</a></li>
            <li><a href="#" style="margin-right: 5px;" class="text-secondary">��</a></li>
        </ul>
        <a href="writeAction.jsp" class="btn btn-outline-info float-right btn- color">�۾���</a>

    </div>

<script src="js/jquery-3.0.0.min.js"></script>
<script src="js/bootstrap.js"></script>
</div>
</body>

</html>