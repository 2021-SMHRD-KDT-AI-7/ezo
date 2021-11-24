<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
    <html>
      <head>
        <link rel="stylesheet" type="text/css" href="./css/login.css">
      <!-- fonts -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
      <!-- font awesome -->
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      </head>
    
      <body width="100%" height="100%">
        <form action="loginServiceCon.do" method="post" class="loginForm">
          <h2>써치까치 로그인</h2>
          <div class="idForm">
            <input type="text" class="id" placeholder="ID" name="m_id">
          </div>
          <div class="passForm">
            <input type="password" class="pw" placeholder="PW" name="m_pw">
          </div>
          <div class="forgot">
            <a href="find_idFrame.html" class="find_id"><i aria-hidden="true"></i>아이디 찾기</a><span class="bar"> / </span>
            <a href="find_pw.html" class="find_pw"><i aria-hidden="true"></i>비밀번호 찾기</a><span class="bar"> / </span>
            <a href="join.html" class="join"><i aria-hidden="true"></i>회원가입</a>
        </div>
          <button type="submit" class="btn" onclick="button()">
            로그인
          </button>
        </form>
      </body>
    </html>