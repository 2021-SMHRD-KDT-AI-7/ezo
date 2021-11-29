<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ page import="java.util.ArrayList" %>
   <%@ page import="Model.memberDTO" %>
   <%@ page import="Model.memberDAO" %>
   <%@ page import="Model.basketDAO" %>
   <%@ page import="Model.basketDTO" %>
 
 <DOCTYPE HTML5>
    <html>
      <head>
        <title>써치까치 찜 목록</title>
        <link rel="stylesheet" type="text/css" href="./css/wish_list.css">
      <!-- fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <!-- jQuery -->
      <script src="./js/jquery-3.0.0.min.js"></script>
      <!-- Bootstrap -->
      <!-- <script src="./js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="./css/bootstrap.min.css"> -->
  <%
    memberDTO info = (memberDTO)session.getAttribute("info");
    
    session.setAttribute("run_check", 0);
    if (session != null) {
       System.out.println("run_check_Okay");
    }
    String findData = null;
    
    ArrayList<basketDTO> list = new ArrayList<>();
	basketDAO dao = new basketDAO();
    list =  dao.viewBasket(info.getM_key());
    %>
      </head>

      <body>
  <a href="Main.jsp">홈으로 가기</a>
          <div class="small-container cart-page table-responsive">

            <div id="header"><h2>찜 목록</h2>
                <h5 class="comment">푸쉬 알림서비스를 통해 할인정보를 알려드립니다!<br></h5>
            </div>

            <table class="table table-bordered table-hover" id="paging">
                <!-- 테이블 머릿말 -->
                <thead>
                    <tr>
                        <th>상품정보</th>
                        <th style="text-align: center;">희망 할인가</th>
                        <th >상품가격</th>
                    </tr>
                </thead>
                <tbody>
                <!-- 1번 상품 -->
               <% for(int i = 0; i<list.size(); i++){%>
                <tr>
                    <td>
                        <div class="cart-info">
                            <img src="<%=list.get(i).getP_file()%>">
                            <div>
                                <p><%=list.get(i).getP_title()%></p>
                                <small></small>
                                <br>
                                <a href="deleteWishlistServiceCon.do?m_key=<%=info.getM_key()%>">삭제</a>
                            </div>
                        </div>
                    </td>

                    <div class="push_alram">
                    <td><select id="sale">
                        <option value="forSale">할인율</option>
                        <option value="5%">5%</option>
                        <option value="10%">10%</option>
                        <option value="15%">15%</option>
                        <option value="20%">20%</option>
                        <option value="25%">25%</option>
                        <option value="30%">30%</option>
                    </select></td>
                    <td><%=list.get(i).getP_price() %></td>
                </div>
                </tr>
                <% }%>
                </tbody>
            </table>

	<div>
            <button type="button" class="btn_next"  >
                완료
            <button type="button" class="btn_alram" onclick="alert('상품 예약이 완료되었습니다!')"">
                할인 푸쉬 알림

          </div>
      </body>
    </html>