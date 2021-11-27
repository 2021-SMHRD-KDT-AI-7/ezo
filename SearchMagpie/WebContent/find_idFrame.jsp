<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>

<html lang="en">
 <% String m_id = request.getParameter("m_id"); %>
	<head>
		<title>써치까치 아이디 찾기</title>
        <link rel="stylesheet" type="text/css" href="./css/find_id.css">
      <!-- fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      </head>
      <script> 
  function submit2(frm) { 
    frm.action='loginFrame.jsp'; 
    frm.submit(); 
    return true; 
  } 
</script> 
    
      <body width="100%" height="100%">
      <!-- 아이디 찾기 -->
        <form action="findIdServiceCon.do" method="post" class="find_idForm">
          <h2>아이디 찾기</h2>
          <h5>가입 시 입력했던 이름과 이메일정보가 일치하면<br>아이디를 찾아드립니다.</h5>
          <div class="nameForm">
            <input type="text" class="name" placeholder="이름" name="m_name">
          </div>
          <div class="emailForm">
            <input type="text" class="email" placeholder="이메일" name="m_email">
          </div>
          <div class="forgot">
            <a href="find_pwFrame.jsp" class="find_pw"><i aria-hidden="true">
           	 비밀번호 찾기</i></a><span class="bar"></span>
        </div>
         <br><h2>아이디 : <%=m_id%></h2>
          <button type="submit" class="btn_next" onclick="button()">
            다음
          </button>
          <button type="submit" class="btn_back" style="color: #D3D3D3;" 
           onclick='return submit2(this.form);'>
            뒤로
          </button>
        </form>
      </body>
    </html>