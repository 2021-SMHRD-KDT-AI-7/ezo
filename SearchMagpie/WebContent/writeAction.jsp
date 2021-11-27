<%@page import="Model.memberDTO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 게시판 웹 사이트</title>
</head>
<body>
	<%
	memberDTO info = (memberDTO) session.getAttribute("info");
	PrintWriter script = response.getWriter();
	// 현재 세션 상태를 체크한다
	if (info != null) {
		script.println("<script>");
		script.println("location.href='write.jsp'");
		script.println("</script>");
	} else {
		// 로그인을 한 사람만 글을 쓸 수 있도록 코드를 수정한다
		script.println("<script>");
		script.println("alert('로그인을 하세요')");
		script.println("location.href='loginFrame.jsp'");
		script.println("</script>");
		// 입력이 안 된 부분이 있는지 체크한다
	}
	%>
</body>
</html>